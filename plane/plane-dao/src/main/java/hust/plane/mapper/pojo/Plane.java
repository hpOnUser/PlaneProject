package hust.plane.mapper.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Plane {
	private String planeid;
	private String planename;
	private String userid;
	private String status;
	private String flongda;
	private String dec;
	private String height;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createtime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatetime;
	
    public String getPlaneid() {
		return planeid;
	}
	public void setPlaneid(String planeid) {
		this.planeid = planeid;
	}
	public String getPlanename() {
		return planename;
	}
	public void setPlanename(String planename) {
		this.planename = planename;
	}
	public String getHeight() {
    	return height;
    }
    public void setHeight(String height) {
    	this.height = height;
    }
	public String getPlaneId() {
		return planeid;
	}
	public void setPlaneId(String planeId) {
		this.planeid = planeId;
	}

	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFlongda() {
		return flongda;
	}
	public void setFlongda(String flongda) {
		this.flongda = flongda;
	}
	public String getDec() {
		return dec;
	}
	public void setDec(String dec) {
		this.dec = dec;
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
