package hust.plane.mapper.mapper;

import hust.plane.mapper.pojo.Task;
import hust.plane.mapper.pojo.TaskExample;
import hust.plane.utils.page.TailPage;
import hust.plane.utils.page.TaskPojo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskMapper {
    int countByExample(TaskExample example);

    int deleteByExample(TaskExample example);

    int deleteByPrimaryKey(String taskid);

    int insert(Task record);

    int insertSelective(Task record);

    List<Task> selectByExample(TaskExample example);

    Task selectByPrimaryKey(String taskid);

    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
    
    List<Task> queryPage(Task task, TailPage<TaskPojo> page);

	String getStatusByTask(Task task);
}