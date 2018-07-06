package hust.plane.mapper.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PlanePath {
	
	private String planepathid;
	private String plongda;
	private String height;
	private String descripte;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createtime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatetime;

	public String getPlanepathid() {
		return planepathid;
	}
	public void setPlanepathid(String planepathid) {
		this.planepathid = planepathid;
	}
	public String getPlongda() {
		return plongda;
	}
	public void setPlongda(String plongda) {
		this.plongda = plongda;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getDescripte() {
		return descripte;
	}
	public void setDescripte(String descripte) {
		this.descripte = descripte;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
}
