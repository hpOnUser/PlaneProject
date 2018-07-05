package hust.plane.web.controller.vo;

import java.util.List;

import hust.plane.mapper.pojo.Alarm;
import hust.plane.utils.PointUtil;


public class AlarmVo {
	
	private String alarmid;
	private String image;
	private String planeid;
	private String descripte;
	private String createTime;
	private String updateTime;
	private String alongda;
	private List<Double> positionList;


	public AlarmVo(Alarm alarm) {
		
		this.alarmid = alarm.getAlarmid();
		if (alarm.getImage() != null) {
			this.image = alarm.getImage();
		}
		if (alarm.getPlaneid() != null) {
			this.planeid = alarm.getPlaneid();
		}
		if (alarm.getDescripte() != null) {
			this.descripte = alarm.getDescripte();
		}
		if (alarm.getCreateTime() != null) {
			this.createTime = alarm.getCreateTime().toString();
		}
		if (alarm.getUpdateTime() != null) {
			this.updateTime = alarm.getUpdateTime().toString();
		}
		if(alarm.getAlongda()!=null) {
			this.positionList = PointUtil.StringPointToList(alarm.getAlongda());
			this.alongda = PointUtil.pointToString(PointUtil.StringPointToList(alarm.getAlongda()));
		}			
	}
	
	public String getAlarmid() {
		return alarmid;
	}
	public void setAlarmid(String alarmid) {
		this.alarmid = alarmid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPlaneid() {
		return planeid;
	}
	public void setPlaneid(String planeid) {
		this.planeid = planeid;
	}
	public String getDescripte() {
		return descripte;
	}
	public void setDescripte(String descripte) {
		this.descripte = descripte;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getAlongda() {
		return alongda;
	}

	public void setAlongda(String alongda) {
		this.alongda = alongda;
	}

	public List<Double> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<Double> positionList) {
		this.positionList = positionList;
	}
}
