package hust.phone.mapper.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Task {
    private String taskid;

    private String useraid;

    private String userbid;

    private String usercid;

    private String planepathid;

    private String planeid;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date plantime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createtime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date realtime;

    private String status;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatetime;

    private String finishstatus;

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid == null ? null : taskid.trim();
    }

    public String getUseraid() {
        return useraid;
    }

    public void setUseraid(String useraid) {
        this.useraid = useraid == null ? null : useraid.trim();
    }

    public String getUserbid() {
        return userbid;
    }

    public void setUserbid(String userbid) {
        this.userbid = userbid == null ? null : userbid.trim();
    }

    public String getUsercid() {
        return usercid;
    }

    public void setUsercid(String usercid) {
        this.usercid = usercid == null ? null : usercid.trim();
    }

    public String getPlanepathid() {
        return planepathid;
    }

    public void setPlanepathid(String planepathid) {
        this.planepathid = planepathid == null ? null : planepathid.trim();
    }

    public String getPlaneid() {
        return planeid;
    }

    public void setPlaneid(String planeid) {
        this.planeid = planeid == null ? null : planeid.trim();
    }

    public Date getPlantime() {
        return plantime;
    }

    public void setPlantime(Date plantime) {
        this.plantime = plantime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getRealtime() {
        return realtime;
    }

    public void setRealtime(Date realtime) {
        this.realtime = realtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getFinishstatus() {
        return finishstatus;
    }

    public void setFinishstatus(String finishstatus) {
        this.finishstatus = finishstatus == null ? null : finishstatus.trim();
    }
}