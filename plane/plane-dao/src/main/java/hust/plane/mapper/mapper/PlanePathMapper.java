package hust.plane.mapper.mapper;


import java.util.List;

import hust.plane.mapper.pojo.PlanePath;
import hust.plane.utils.page.TailPage;

public interface PlanePathMapper {
	
	 PlanePath selectByPlanePathVo(PlanePath planepath);

	 void insertPlanePath();

	 void insertPlanePath(PlanePath planePath);

	 PlanePath selectByPlanepathId(PlanePath planepath);

	int planePathCount(PlanePath planePath);

	List<PlanePath> queryPlanePathPage(PlanePath planePath, TailPage<PlanePath> page); 
}
