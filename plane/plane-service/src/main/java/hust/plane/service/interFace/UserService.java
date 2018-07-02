package hust.plane.service.interFace;

import hust.plane.mapper.pojo.User;

public interface UserService {
    User login(String username, String password);
    int register(String username, String password);
}
