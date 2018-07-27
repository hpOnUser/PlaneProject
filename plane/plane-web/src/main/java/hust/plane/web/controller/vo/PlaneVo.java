package hust.plane.web.controller.vo;

import java.util.List;

import hust.plane.mapper.pojo.Plane;
import hust.plane.utils.PointUtil;

public class PlaneVo {

	private String planeId = "";
	private String status = "";
	private List<Double> flongda;
	private String dec = "";
	private String updateTime = "";

	public PlaneVo(Plane plane) {

		// 使用Plane初始化该对象

		this.planeId = plane.getPlaneId();
		if (plane.getStatus() != null) {
			this.status = plane.getStatus();
		}
		if (plane.getFlongda() != null) {
			this.flongda = PointUtil.StringPointToList(plane.getFlongda());		
		}
		if (plane.getDec() != null) {
			this.dec = plane.getDec();
		}
		if (plane.getUpdateTime() != null) {
			this.updateTime = plane.getUpdateTime().toString();
		}
	}

	public String getPlaneId() {
		return planeId;
	}

	public void setPlaneId(String planeId) {
		this.planeId = planeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Double> getFlongda() {
		return flongda;
	}

	public void setFlongda(List<Double> flongda) {
		this.flongda = flongda;
	}

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
