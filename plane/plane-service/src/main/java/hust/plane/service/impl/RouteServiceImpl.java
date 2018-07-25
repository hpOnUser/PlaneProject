package hust.plane.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hust.plane.mapper.mapper.RouteMapper;
import hust.plane.mapper.pojo.Route;
import hust.plane.service.interFace.RouteService;

@Service
public class RouteServiceImpl implements RouteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RouteServiceImpl.class);
    @Autowired
    private RouteMapper routeMapper;

    @Override
    public List<Route> getAllRoute() {
        // TODO Auto-generated method stub
        List<Route> routeList = routeMapper.selectALLRoute();
        return routeList;
    }

    @Override
    public List<Route> getRouteByIdAndStatus(String routeId, String type) {
        List<Route> routeList = new ArrayList<>();
        Route route = new Route();
        if (StringUtils.isBlank(routeId) && StringUtils.isBlank(type)) {
            LOGGER.error("查询的路由Id和Type为空");
        }
        if (StringUtils.isNotBlank(routeId)) {
            if (StringUtils.isNotBlank(type)) {
                route = routeMapper.getRouteByIdAndStatus(routeId, type);
            }
            routeList = routeMapper.selectRoute(routeId, type);
        }
        if (route == null) {
            return routeList;
        } else {
            List<Route> listOnlyOne = new ArrayList<>(1);
            listOnlyOne.add(route);
            return listOnlyOne;
        }
    }
}
