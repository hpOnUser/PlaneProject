package hust.plane.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hust.plane.mapper.pojo.Route;
import hust.plane.service.interFace.RouteService;
import hust.plane.web.controller.vo.RouteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hust.plane.mapper.pojo.Alarm;
import hust.plane.service.interFace.AlarmService;
import hust.plane.service.interFace.FileService;
import hust.plane.utils.JsonUtils;
import hust.plane.web.controller.vo.AlarmVo;

import javax.annotation.Resource;

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
		Iterator<Alarm> iterator =alarmAll.iterator();
		while(iterator.hasNext()){
			Alarm alarm=iterator.next();
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
		model.addAttribute("alarmList",JsonUtils.objectToJson(alarmList));
		model.addAttribute("curNav", "alarmList");
		return "alarmList";
	}
	
}
