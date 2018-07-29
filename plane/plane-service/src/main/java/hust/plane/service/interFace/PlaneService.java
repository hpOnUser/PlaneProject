package hust.plane.service.interFace;

import hust.plane.mapper.pojo.Plane;

import java.util.Date;
import java.util.List;

public interface PlaneService {

    List<Plane> getAllPlane();

    List<Plane> getPlaneByOption(String userid, Date starttime, Date endtime);

	List<Plane> findByPlaneStatus(Plane plane);



}
