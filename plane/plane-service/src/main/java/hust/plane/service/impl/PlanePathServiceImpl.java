package hust.plane.service.impl;

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
		List<PlanePath> planePathList = planePathMapper.selectByPlanePathVo(planepath);
		List<PlanePathVo> plist = KMLUtil.textToList(planePathList.get(0).getPlongda(),planePathList.get(0).getHeight());
		KMLUtil.importKML(filePath, plist);
		
	}

}
