package hust.plane.web.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import hust.plane.mapper.pojo.Plane;
import hust.plane.mapper.pojo.User;
import hust.plane.service.interFace.PlaneService;
import hust.plane.utils.JsonUtils;
import hust.plane.utils.PointUtil;
import hust.plane.web.controller.vo.PlaneVo;

@Controller
public class PlaneController {
	@Autowired
	public PlaneService planeServiceimpl;
	
	@RequestMapping("/plane")
	//获取飞机信息
	//实例解决经纬度路径
	public String getAllPlane(Model model)
	{
		List<Plane> allPlane = planeServiceimpl.getAllPlane();
		List<Double> p=PointUtil.StringPointToList(allPlane.get(0).getFlongda());
		String pp =JsonUtils.objectToJson(p);
		model.addAttribute("pp",pp);		
		return "plane";
	}

	@RequestMapping("/planeList")
	//获取飞机列表信息
	//实例解决经纬度路径
	public String getPlaneList(Model model)
	{
		List<Plane> allPlane = planeServiceimpl.getAllPlane();
		List<PlaneVo> planeList = new ArrayList<PlaneVo>(); 	
		for(int i=0;i<allPlane.size();i++) {
			PlaneVo planevo = new PlaneVo(allPlane.get(i)) ;
			planeList.add(planevo);	
		}
		model.addAttribute("planelist",JsonUtils.objectToJson(planeList));
		model.addAttribute("curNav", "planeAllList");
		//System.out.println(planeList.size());
		//return JsonUtils.objectToJson(planeList);
		return "planeList";
	}
	
	//使用user接收前台数据，userid接收负责人id，createtime接收起始时间，updatetime接收终止时间
	@RequestMapping("doFindPlane")
	public String doFindPlane(Model model,User user) {
		//ModelAndView mv = new ModelAndView("planeList");
		List<Plane> allPlane = planeServiceimpl.getAllPlane();
		List<PlaneVo> planeList = new ArrayList<PlaneVo>(); 	
		for(int i=0;i<allPlane.size();i++) {
			PlaneVo planevo = new PlaneVo(allPlane.get(i)) ;
			planeList.add(planevo);	
		}
		model.addAttribute("planelist",JsonUtils.objectToJson(planeList));
		//List<PlaneVo> planeList = 
		//mv.addObject("planelist",JsonUtils.objectToJson(planeList));
		model.addAttribute("curNav", "routeImport");
		
		return "planeList";
		
		
	}
	
	
}
