package hust.plane.service.interFace;

import hust.plane.mapper.pojo.PlanePath;
import hust.plane.utils.page.TailPage;

public interface PlanePathService {
	
	public void importPlanePath(PlanePath planepath,String filePath);

	public boolean insertPlanePath(PlanePath planePath);

	PlanePath selectByPlanepathId(PlanePath planePath);

	public TailPage<PlanePath> queryAlarmWithPage(PlanePath planePath, TailPage<PlanePath> page);
}
