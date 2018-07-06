package hust.plane.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hust.plane.constant.WebConst;
import hust.plane.mapper.pojo.Route;
import hust.plane.service.interFace.RouteService;
import hust.plane.utils.pojo.InfoTplData;
import hust.plane.utils.pojo.JsonView;
import hust.plane.web.controller.vo.RouteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hust.plane.mapper.pojo.Alarm;
import hust.plane.service.interFace.AlarmService;
import hust.plane.service.interFace.FileService;
import hust.plane.utils.JsonUtils;
import hust.plane.web.controller.vo.AlarmVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    @Resource
    private RouteService routeServiceImpl;

    //返回所有的告警点
    @RequestMapping("/alarmList")
    public String alarmList(Model model) {
        List<Alarm> alarmAll = alarmService.getAllAlarm();
        List<AlarmVo> alarmList = new ArrayList<AlarmVo>();
        Iterator<Alarm> iterator = alarmAll.iterator();
        while (iterator.hasNext()) {
            Alarm alarm = iterator.next();
            AlarmVo alarmVo = new AlarmVo(alarm);
            alarmList.add(alarmVo);
        }
        //告警点路由显示
        List<Route> allRoute = routeServiceImpl.getAllRoute();
        List<RouteVo> routeList = new ArrayList<RouteVo>();
        for (int i = 0; i < allRoute.size(); i++) {
            RouteVo routeVo = new RouteVo(allRoute.get(i));
            routeList.add(routeVo);
        }
        model.addAttribute("routeList", JsonUtils.objectToJson(routeList));
        model.addAttribute("alarmList", JsonUtils.objectToJson(alarmList));
        model.addAttribute("curNav", "alarmList");
        return "alarmList";
    }

    /**
     * 返回相应的告警信息
     *
     * @param [id, request]
     * @return java.lang.String
     * @author rfYang
     * @date 2018/7/6 15:05
     */
    @RequestMapping(value = "alarmInfo", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String getAlarmInfo(@RequestParam(value = "alarmId") String id, HttpServletRequest request) {
        Alarm alarm = alarmService.selectAlarmById(id);
        InfoTplData info = new InfoTplData();
        info.setImg(alarm.getImage());
        info.setBody(alarm.getDescripte());
        return JsonView.render(0, WebConst.SUCCESS_RESULT, info);
    }

}
