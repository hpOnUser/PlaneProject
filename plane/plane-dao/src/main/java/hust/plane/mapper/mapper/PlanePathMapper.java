package hust.plane.mapper.mapper;

import java.util.List;

import hust.plane.mapper.pojo.PlanePath;

public interface PlanePathMapper {
	
	public List<PlanePath> selectByPlanePathVo(PlanePath planepath);

}
