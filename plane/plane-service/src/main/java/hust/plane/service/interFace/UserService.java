package hust.plane.service.interFace;

import hust.plane.mapper.pojo.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    User login(String username, String password);

    int register(String username, String password);

    User queryUserById(String uid);

    void modifyPwd(HttpServletRequest request, String oldpassword, String password);
}
