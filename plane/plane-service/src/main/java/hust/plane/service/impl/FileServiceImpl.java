package hust.plane.service.impl;

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
	
	@Value("ROOT_FILE")
	private String ROOT_FILE;
	
	@Autowired
	private RouteMapper routeMapper;
	//插入路由数据
	@Override
	public void insertRoute(String path,Route route) {
		//修改
		String filepath = ROOT_FILE + path;
		List<RouteExcel> readExcel = ExcelUtil.readExcel(filepath);
		route.setRouteId("5");
		route.setDescripte("这是一条测试数据");
		route.setType("1");
		
		Route r=new Route();
		
		//读取编号
		if(route.getRouteId()!=null)
		{
			r.setRouteId(route.getRouteId());
		}
		//构成经纬度序列
		String s=LineUtil.ListToString(readExcel);
		r.setRoutePath(s);
		//读取描述
		r.setDescripte(route.getDescripte());
		//设置创建时间
		Date date=new Date();
		r.setCreateTime(date);
		r.setUpdateTime(date);
		
		//设置路由类型
		r.setType(route.getType());
		//设置状态
		r.setStatus("0");
		
		routeMapper.insert(r);
		
	}
	public static void main(String[] args) {
		FileServiceImpl fileimpl=new FileServiceImpl();
		String path="D:\\test2.xlsx";
		Route route=new Route();
		route.setRouteId("5");
		route.setDescripte("这是一条测试数据");
		route.setType("1");
		fileimpl.insertRoute(path, route);
		
	}

}
