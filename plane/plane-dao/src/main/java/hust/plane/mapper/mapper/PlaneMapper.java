package hust.plane.mapper.mapper;

import java.util.Date;
import java.util.List;

import hust.plane.mapper.pojo.Plane;

public interface PlaneMapper {
	
	List<Plane> selectALLPlane();
	List<Plane> selectPlaneByOption(String userid,Date starttime,Date endtime);
	List<Plane> selectByPlaneStatus(String status);
	Plane getPlaneByPlane(Plane plane);
}
