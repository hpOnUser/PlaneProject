package hust.plane.mapper.mapper;

import hust.plane.mapper.pojo.User;
import hust.plane.mapper.pojo.UserExample;
import java.util.List;

import hust.plane.utils.page.TailPage;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String userid);

    int insert(User record);

    int insertSelective(User record);
    //Id自增
    int insertSelectiveWithIdInc(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //根据该用户名查出用户的数量
    int selectByUserName(String username);

    int selectByUserNameAndRole(@Param("username") String username,@Param("role") String role);

    int selectUserCount();

    List<User> selectAllUser(@Param("page") TailPage<User> page);
}