package hust.plane.mapper.mapper;

import java.util.List;

import hust.plane.mapper.pojo.Route;

public interface RouteMapper {
	List<Route> selectALLRoute();
	int insert(Route route);
    Route getRouteByIdAndStatus(String routeId, String type);
}
