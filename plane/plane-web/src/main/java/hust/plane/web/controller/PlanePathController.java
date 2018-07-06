package hust.plane.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import hust.plane.mapper.pojo.PlanePath;
import hust.plane.service.interFace.PlanePathService;
import hust.plane.utils.pojo.JsonView;

@Controller
public class PlanePathController {
	
	@Autowired
	private PlanePathService planePathServiceImpl;

	@RequestMapping("/toImportPlanePath")
	public String toImportPlanePath()
	{
		return "importPlanePath";
	}
	
	@RequestMapping("/importPlanePath")
	public String importPlanePath(PlanePath planePath,String filePath)
	{
		planePathServiceImpl.importPlanePath(planePath, filePath);
		return  JsonView.render(0);
	}
}
