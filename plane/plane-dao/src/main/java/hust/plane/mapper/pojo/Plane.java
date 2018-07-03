package hust.plane.mapper.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Plane {
	private String planeId;
	private String planename;
	private String userid;
	private String status;
	private String flongda;
	private String dec;
	private String height;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createTime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updateTime;
	
    public String getHeight() {
    	return height;
    }
    public void setHeight(String height) {
    	this.height = height;
    }
	public String getPlaneId() {
		return planeId;
	}
	public void setPlaneId(String planeId) {
		this.planeId = planeId;
	}

	public String getPlanename() {
		return planename;
	}
	public void setPlanename(String planename) {
		this.planename = planename;
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
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
