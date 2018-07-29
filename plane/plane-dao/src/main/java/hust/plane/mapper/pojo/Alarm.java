package hust.plane.mapper.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Alarm {
	
	private String alarmid;
	private String image;
	private String planeid;
	private String alongda;
	private String descripte;
	private String status;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createtime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatetime;
    
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getAlongda() {
		return alongda;
	}
	public void setAlongda(String alongda) {
		this.alongda = alongda;
	}
	public String getDescripte() {
		return descripte;
	}
	public void setDescripte(String descripte) {
		this.descripte = descripte;
	}
	public Date getCreateTime() {
		return createtime;
	}
	public void setCreateTime(Date createTime) {
		this.createtime = createTime;
	}
	public Date getUpdateTime() {
		return updatetime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updatetime = updateTime;
	}
	
}
