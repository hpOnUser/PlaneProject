package hust.plane.service.interFace;

import java.util.List;

import hust.plane.mapper.pojo.PlanePath;
import hust.plane.utils.page.TailPage;

public interface PlanePathService {

    void importPlanePath(PlanePath planepath, String filePath);

    boolean insertPlanePath(PlanePath planePath);

    PlanePath selectByPlanepathId(PlanePath planePath);

    TailPage<PlanePath> queryPlanePathWithPage(PlanePath planePath, TailPage<PlanePath> page);

	List<PlanePath> findAllplanePath();

	boolean deletePlanePath(PlanePath planePath);
}
