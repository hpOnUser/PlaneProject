package hust.plane.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hust.plane.mapper.mapper.PlanePathMapper;
import hust.plane.mapper.pojo.PlanePath;
import hust.plane.service.interFace.PlanePathService;
import hust.plane.utils.KMLUtil;
import hust.plane.utils.pojo.PlanePathVo;

@Service
public class PlanePathServiceImpl implements PlanePathService{
	
	@Autowired
	private PlanePathMapper planePathMapper;

	@Override
	public void importPlanePath(PlanePath planepath,String filePath) {
		PlanePath planePathList = planePathMapper.selectByPlanePathVo(planepath);
		List<PlanePathVo> plist = KMLUtil.textToList(planePathList.getPlongda(),planePathList.getHeight());
		KMLUtil.importKML(filePath, plist);
		
	}

	//插入一条飞行路径
	@Override
	public boolean insertPlanePath(PlanePath planePath) {
		
		planePath.setPlongda("LINESTRING" + planePath.getPlongda());
		Date date=new Date();
		planePath.setCreatetime(date);
		planePath.setUpdatetime(date);
		
		//然后在下面进行插入数据
		planePathMapper.insertPlanePath(planePath);
		return true;
	}

}
