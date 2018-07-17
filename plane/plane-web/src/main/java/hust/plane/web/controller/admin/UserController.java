package hust.plane.web.controller.admin;

import hust.plane.constant.WebConst;
import hust.plane.mapper.pojo.User;
import hust.plane.service.interFace.UserService;
import hust.plane.utils.page.TailPage;
import hust.plane.utils.pojo.JsonView;
import hust.plane.utils.pojo.TipException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping(value = "toUserCreate", method = RequestMethod.GET)
    public String userModify(TailPage<User> page, Model model) {
        page = userService.getAllUserWithPage(page);
        model.addAttribute("page", page);
        return "userModify";
    }

    @RequestMapping(value = "deleteUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String doDelUser(@RequestParam String userid) {
        try {
            int count = userService.delUserById(userid);
        } catch (Exception e) {
            String msg = "删除失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            } else {
                LOGGER.error(msg, e);
            }
            return JsonView.render(1, msg);
        }
        return JsonView.render(0, WebConst.SUCCESS_RESULT);
    }
}
