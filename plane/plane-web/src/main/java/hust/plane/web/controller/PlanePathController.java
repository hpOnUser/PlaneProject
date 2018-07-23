package hust.plane.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hust.plane.mapper.pojo.PlanePath;
import hust.plane.mapper.pojo.Route;
import hust.plane.service.interFace.PlanePathService;
import hust.plane.service.interFace.RouteService;
import hust.plane.utils.JsonUtils;
import hust.plane.utils.page.TailPage;
import hust.plane.utils.pojo.JsonView;
import hust.plane.web.controller.vo.PlanePathVo;
import hust.plane.web.controller.vo.RouteVo;

@Controller
public class PlanePathController {
	
	@Autowired
	private PlanePathService planePathServiceImpl;
	
	@Autowired
	public RouteService routeServiceImpl;

	@RequestMapping("/toImportPlanePath")
	public String toImportPlanePath(Model model)
	{
		model.addAttribute("curNav", "importPlanePath");
		return "importPlanePath";
	}
	
	@RequestMapping("/importPlanePath")
	@ResponseBody
	public String importPlanePath(PlanePath planePath)
	{
		if(planePath!=null)
		{
			//E:\\hello.kml
			String filePath = "E:\\\\"+planePath.getPlanepathid()+".kml";//设置文件名
			planePathServiceImpl.importPlanePath(planePath, filePath);
		}
		return   new JsonView(0).toString();
	}
	
	//返回设定飞行路径页面，返回所有路由数据，并在前台显示
	@RequestMapping("/setFlyPath")
	public String doSetFlyPath(Model model) {
		List<Route> allRoute = routeServiceImpl.getAllRoute();
		List<RouteVo> routeList = new ArrayList<RouteVo>();
		for (int i = 0; i < allRoute.size(); i++) {
					
			RouteVo routeVo = new RouteVo(allRoute.get(i));
			routeList.add(routeVo);
		}
		
		model.addAttribute("routeList", JsonUtils.objectToJson(routeList));
		model.addAttribute("curNav","setFlyPath");
		return "setFlyPath";
	}
	
	//获取前台传输的路径字符串
	@RequestMapping("doSetFlyPath")
	@ResponseBody
	public String doSetFlyPath(PlanePath planePath) {
		//System.out.println(route.getRoutePath());
		
		if(planePathServiceImpl.insertPlanePath(planePath)==true)
			return "success";
		else
			return "failed";
	}
	
	 //查询所有的飞行路径列表  分页查询
	@RequestMapping("doGetFlyPathList")
	public String doGetFlyPathListQueryPage(PlanePath planePath, String status,TailPage<PlanePath> page, Model model) {
		
    	if("".equals(planePath.getPlanepathid()))
    	{
    		planePath.setPlanepathid(null);
    	}
        model.addAttribute("selectStatus",status);
        page = planePathServiceImpl.queryPlanePathWithPage(planePath,page);
        model.addAttribute("page",page);
        model.addAttribute("curNav", "flyPathList");
        return "planePathList";
		
		
	}
	
	//返回一条飞行路径，包括所有信息，在这里使用包装类，用于画图
	@RequestMapping(value="showPlanePath",method=RequestMethod.GET)
	public String showPlanePath(@RequestParam("planepathid") String planepathid,Model model) {
			
		PlanePath planePath = new PlanePath();
		planePath.setPlanepathid(planepathid);
		planePath = planePathServiceImpl.selectByPlanepathId(planePath);
		PlanePathVo planePathVo = new PlanePathVo(planePath);
		
		model.addAttribute("PlanePath",JsonUtils.objectToJson(planePathVo));
		return "showPlanePath";
	}
	
}
