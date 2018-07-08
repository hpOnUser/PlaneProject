package hust.plane.mapper.mapper;

import java.util.List;

import hust.plane.mapper.pojo.PlanePath;

public interface PlanePathMapper {
	
	 List<PlanePath> selectByPlanePathVo(PlanePath planepath);

	 void insertPlanePath();

	 void insertPlanePath(PlanePath planePath);

}
