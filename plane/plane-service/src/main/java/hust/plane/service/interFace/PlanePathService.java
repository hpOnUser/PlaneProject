package hust.plane.service.interFace;

import hust.plane.mapper.pojo.PlanePath;
import hust.plane.utils.page.TailPage;

public interface PlanePathService {

    void importPlanePath(PlanePath planepath, String filePath);

    boolean insertPlanePath(PlanePath planePath);

    PlanePath selectByPlanepathId(PlanePath planePath);

    TailPage<PlanePath> queryAlarmWithPage(PlanePath planePath, TailPage<PlanePath> page);
}
