package hust.plane.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hust.plane.mapper.mapper.RouteMapper;
import hust.plane.mapper.pojo.Route;
import hust.plane.service.interFace.RouteService;

@Service
public class RouteServiceImpl implements RouteService {
	
	@Autowired
	private RouteMapper routeMapper;

	@Override
	public List<Route> getAllRoute() {
		// TODO Auto-generated method stub
		List<Route> routeList = routeMapper.selectALLRoute();
		return routeList;
	}

	@Override
	public Route getRouteByIdAndStatus(String routeId, String type) {
		if(StringUtils.isNotBlank(routeId)&&StringUtils.isNotBlank(type)){
			Route route=routeMapper.getRouteByIdAndStatus(routeId,type);
			if(route != null) return route;
		}
		return null;
	}
}
