package hust.plane.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import hust.plane.mapper.mapper.RouteMapper;
import hust.plane.mapper.pojo.Route;
import hust.plane.service.interFace.FileService;
import hust.plane.utils.ExcelUtil;
import hust.plane.utils.LineUtil;
import hust.plane.utils.pojo.RouteExcel;
@Service
public class FileServiceImpl implements FileService {
	

	@Value("${ROOT_FILE}")
	private String ROOT_FILE;

	@Autowired
	private RouteMapper routeMapper;
	//插入路由数据
	@Override
	public void insertRoute(File file,Route route) {
		//修改
		//String filepath = ROOT_FILE + path;
		List<RouteExcel> readExcel = ExcelUtil.readExcel(file);
		
		//构成经纬度序列
		String s=LineUtil.ListToString(readExcel);
		route.setRoutePath(s);
		//设置创建时间
		Date date=new Date();
		route.setCreateTime(date);
		route.setUpdateTime(date);
		
		routeMapper.insert(route);
		
	}

}
