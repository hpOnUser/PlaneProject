package hust.plane.mapper.mapper;


import hust.plane.mapper.pojo.PlanePath;

public interface PlanePathMapper {
	
	 PlanePath selectByPlanePathVo(PlanePath planepath);

	 void insertPlanePath();

	 void insertPlanePath(PlanePath planePath);

}
