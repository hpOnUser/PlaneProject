package hust.plane.service.interFace;

import java.util.Date;
import java.util.List;

import hust.plane.mapper.pojo.Plane;

public interface PlaneService {
	
	public List<Plane> getAllPlane();

	public List<Plane> getPlaneByOption(String userid, Date starttime, Date endtime);
	

}
