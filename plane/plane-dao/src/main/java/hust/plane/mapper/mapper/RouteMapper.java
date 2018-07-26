package hust.plane.mapper.mapper;

import java.util.List;

import hust.plane.mapper.pojo.Route;
import org.apache.ibatis.annotations.Param;

public interface RouteMapper {
	List<Route> selectALLRoute();
	int insert(Route route);
    Route getRouteByIdAndStatus(String routeId, String type);
    List<Route> selectRoute(String routeid,@Param("type") String type);
}
