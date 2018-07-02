package hust.plane.web.controller.admin;


import hust.plane.constant.WebConst;
import hust.plane.mapper.pojo.User;
import hust.plane.service.interFace.UserService;
import hust.plane.utils.PlaneUtils;
import hust.plane.utils.pojo.JsonView;
import hust.plane.utils.pojo.MapCache;
import hust.plane.utils.pojo.TipException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller("adminIndexController")
@RequestMapping(value = "/admin")
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    private MapCache cache = MapCache.single();
    @Resource
    private UserService userService;
    @RequestMapping(value ="/login" ,method = RequestMethod.GET)
    public String login(){return "login";}

    /**
     * 登陆
     * @param username
     * @param password
     * @param remeber_me
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login",produces="application/json;charset=UTF-8",method = RequestMethod.POST)
    @ResponseBody
    public String doLogin(@RequestParam String username, @RequestParam String password, @RequestParam(required = false) String remeber_me,
                            HttpServletRequest request, HttpServletResponse response){
        Integer error_count = cache.get("login_error_count");
        try {
            User user =userService.login(username,password);
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY,user.getUserid());
            if(StringUtils.isNotBlank(remeber_me)){
                PlaneUtils.setCookie(response,user.getUserid());
            }
        }catch (Exception e){
            error_count=null==error_count?1:error_count+1;
            if(error_count>3){
                return JsonView.render(1,"您输入密码已经错误超过3次，请10分钟后尝试");
            }
            cache.set("login_error_count", error_count, 10 * 60);
            String msg = "登录失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            } else {
                LOGGER.error(msg, e);
            }
            return JsonView.render(1,msg);
        }
        return JsonView.render("");
    }
    /**
     * 注册get请求
     */
    @RequestMapping(value="/register",method = RequestMethod.GET)
    public ModelAndView doRegister(ModelAndView mv){
        mv.setViewName("register");
        return mv;
    }
    /**
     * 注册post请求
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String doRegister(@RequestParam String username, @RequestParam String password, @RequestParam String passwordensure,
                             HttpServletRequest request, HttpSession session){
        try{
               int count = userService.register(username,password);
               if(count<0){
                   return JsonView.render(1,"注册失败，请重新注册");
               }
        }catch(Exception e){
              String msg = "注册失败";
              if(e instanceof TipException){
                  msg = e.getMessage();
              }else{
                  LOGGER.error(msg,e);
              }
              return JsonView.render(1,msg);
        }
        return JsonView.render(0,"注册成功");
    }



}
