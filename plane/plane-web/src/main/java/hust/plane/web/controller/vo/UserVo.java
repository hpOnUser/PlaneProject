package hust.plane.web.controller.vo;

import hust.plane.mapper.pojo.User;

public class UserVo {
    private String userid;

    private String role;

    private String username;

    private String password;

    private String createtime;

    private String updatetime;

    private String descripte;

    private Integer tasknum;


    public UserVo() {
    }

    public UserVo(User user) {
        this.userid = user.getUserid();
        if (user.getUsername() != null) this.username = user.getUsername();
        if (user.getDescripte() != null) this.descripte = user.getDescripte();
        if (user.getRole() != null) this.role = user.getRole();
        if (user.getTasknum() != null) this.tasknum = user.getTasknum();
        if (user.getCreatetime() != null) this.createtime = user.getCreatetime().toString();
        if (user.getUpdatetime() != null) this.updatetime = user.getUpdatetime().toString();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDescripte() {
        return descripte;
    }

    public void setDescripte(String descripte) {
        this.descripte = descripte;
    }

    public Integer getTasknum() {
        return tasknum;
    }

    public void setTasknum(Integer tasknum) {
        this.tasknum = tasknum;
    }
}
