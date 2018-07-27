package hust.plane.web.controller.vo;

import java.util.ArrayList;

import hust.plane.mapper.pojo.PlanePath;
import hust.plane.utils.LineUtil;

public class PlanePathVo {

	private String planepathid;
	private ArrayList<ArrayList<Double>> plongda;
	private ArrayList<Double> height;
	private String descripte;
	private String createtime;
	private String updatetime;
	
	
	public PlanePathVo(PlanePath planePath) {
		
		this.planepathid = planePath.getPlanepathid();
		if(planePath.getPlongda()!=null) {
			this.plongda = LineUtil.stringLineToList(planePath.getPlongda());
		}
		if(planePath.getHeight()!=null) {
			this.height = LineUtil.stringpointToList(planePath.getHeight());
		}
		if(planePath.getDescripte()!=null) {
			this.descripte = planePath.getDescripte();
		}
		if(planePath.getCreatetime()!=null) {
			this.createtime = planePath.getCreatetime().toString();
		}
		if(planePath.getUpdatetime()!=null) {
			this.createtime = planePath.getUpdatetime().toString();
		}
		
	}

	public String getPlanepathid() {
		return planepathid;
	}

	public void setPlanepathid(String planepathid) {
		this.planepathid = planepathid;
	}

	public ArrayList<ArrayList<Double>> getPlongda() {
		return plongda;
	}

	public void setPlongda(ArrayList<ArrayList<Double>> plongda) {
		this.plongda = plongda;
	}

	public ArrayList<Double> getHeight() {
		return height;
	}

	public void setHeight(ArrayList<Double> height) {
		this.height = height;
	}

	public String getDescripte() {
		return descripte;
	}

	public void setDescripte(String descripte) {
		this.descripte = descripte;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

}
