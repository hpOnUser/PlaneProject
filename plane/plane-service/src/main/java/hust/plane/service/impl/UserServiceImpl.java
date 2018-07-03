package hust.plane.service.impl;

import hust.plane.mapper.mapper.UserMapper;
import hust.plane.mapper.pojo.User;
import hust.plane.mapper.pojo.UserExample;
import hust.plane.service.interFace.UserService;
import hust.plane.utils.PlaneUtils;
import hust.plane.utils.pojo.TipException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userDao;

    /**
     * 登陆
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new TipException("用户名和密码不能为空");
        }
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        int count = userDao.countByExample(example);
        if (count < 1) {
            throw new TipException("没有该用户");
        }
        String pwd = PlaneUtils.MD5encode(username + password);
        criteria.andPasswordEqualTo(pwd);
        criteria.andRoleEqualTo("0");
        List<User> userList = userDao.selectByExample(example);
        if (userList.size() != 1) {
            throw new TipException("用户名密码错误或您没有操作权限");
        }
        return userList.get(0);
    }

    /**
     * 注册
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public int register(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new TipException("用户名和密码不能为空");
        }
        int usernameCount = userDao.selectByUserName(username);
        if (usernameCount == 1) {
            throw new TipException("该用户名已经存在");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(PlaneUtils.MD5encode(username + password));
        user.setRole("0");
        user.setCreatetime(new Date());
        user.setDescripte("操作员");
        user.setUserid("4");
        int count = userDao.insertSelective(user);
        return count;
    }

    /**
     * 根据用户id查询到用户
     * @param uid
     * @return
     */
    @Override
    public User queryUserById(String uid) {
        User user = null;
        if (uid != null) {
            user = userDao.selectByPrimaryKey(uid);
        }
        return user;
    }
}
