package hust.plane.service.interFace;

import java.util.List;

import hust.plane.mapper.pojo.Route;

public interface RouteService {
    List<Route> getAllRoute();

    Route getRouteByIdAndStatus(String routeId, String type);
}