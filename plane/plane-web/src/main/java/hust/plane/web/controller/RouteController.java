package hust.plane.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hust.plane.constant.WebConst;
import hust.plane.utils.pojo.InfoTplData;
import hust.plane.utils.pojo.JsonView;
import hust.plane.web.controller.vo.QueryRouteVo;
import hust.plane.web.controller.vo.RouteVo;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import hust.plane.mapper.pojo.Route;
import hust.plane.service.interFace.RouteService;
import hust.plane.utils.JsonUtils;
import hust.plane.utils.LineUtil;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouteController {

    @Autowired
    public RouteService routeServiceImpl;

    // 得到路由分布。解决路径序列
    @RequestMapping("/erouteList")
    public String getAllRoute(Model model) {
        List<Route> allRoute = routeServiceImpl.getAllRoute();

        ArrayList<ArrayList<Double>> s = LineUtil.stringLineToList(allRoute.get(1).getRoutePath());
        String path = JsonUtils.objectToJson(s);
        List<String> listString = LineUtil.pathToArray(path);
        String position = listString.get(0);

        InfoTplData infoTplData = new InfoTplData("巡检路线1",
                "<img src=\"http://s7d2.scene7.com/is/image/Caterpillar/C10602924?$cc-s$\" />",
                "工程机械行业或许不是最危险的，但是危险程度也不低。我们身边随时都有事故发生。当我在网络上看到那么多事故的照片时，我甚至有时候都想放弃这一行去改行做其他的  可是我除了会开挖机还会干什么呢！都说隔行如隔山 。都到了有家庭的年纪了再去改行我又应该拿什么去撑起这个家呢！没有办法只有硬着头皮继续走下去。当我在这一行做的越久我就越胆小，当看到别人干一些比较危险的活或者做一些比较危险的动作的时候我都很佩服他，我承认我不如他。");
        String result = JsonUtils.objectToJson(infoTplData);
        model.addAttribute("infoData", result);
        model.addAttribute("position", position);
        model.addAttribute("path", path);
        model.addAttribute("curNav", "routeList");
        return "route";
    }

    //显示全部路由线路
    @RequestMapping("/routeList")
    public String egetAllRoute(Model model) {
        List<Route> allRoute = routeServiceImpl.getAllRoute();
        List<RouteVo> routeList = new ArrayList<RouteVo>();
        for (int i = 0; i < allRoute.size(); i++) {
            RouteVo routeVo = new RouteVo(allRoute.get(i));
            routeList.add(routeVo);
        }
        model.addAttribute("routeList", JsonUtils.objectToJson(routeList));
        model.addAttribute("curNav", "routeList");
        return "routeList";
    }

    // 跳转到路由路径
    @RequestMapping("/routeImport")
    public String toRouteImport(Model model) {
        model.addAttribute("curNav", "routeImport");
        return "importRoute";
    }

    /**
     * POST请求
     *
     * @param [model, routeId, status]
     * @return java.lang.String
     * @author rfYang
     * @date 2018/7/8 11:17
     */
    @RequestMapping(value = "/queryRoute", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String queryRoute(Model model, @RequestParam String routeId, @RequestParam String type) {
        QueryRouteVo queryRouteVo = new QueryRouteVo(routeId, type);
        return JsonView.render(0, WebConst.SUCCESS_RESULT, queryRouteVo);
    }

    /**
     * 跳转到查询路由处
     *
     * @param [model, routeId, type]
     * @return java.lang.String
     * @author rfYang
     * @date 2018/7/8 15:35
     */
    @RequestMapping(value = "/queryRoute/{id}/{type}", method = RequestMethod.GET)
    public String toRouteQuery(Model model, @PathVariable("id") String routeId, @PathVariable("type") String type) {
        List<Route> allRoute =   routeServiceImpl.getRouteByIdAndStatus(routeId, type);
        List<RouteVo> routeList = new ArrayList<RouteVo>();
        for (int i = 0; i < allRoute.size(); i++) {
            RouteVo routeVo = new RouteVo(allRoute.get(i));
            routeList.add(routeVo);
        }
        model.addAttribute("routeList", JsonUtils.objectToJson(routeList));
        model.addAttribute("curNav", "queryRoute");
        return "queryRoute";
    }

}
