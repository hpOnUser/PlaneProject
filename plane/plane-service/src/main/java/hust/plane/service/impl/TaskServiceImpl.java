package hust.plane.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hust.plane.mapper.mapper.TaskMapper;
import hust.plane.mapper.mapper.UserMapper;
import hust.plane.mapper.pojo.Task;
import hust.plane.mapper.pojo.TaskExample;
import hust.plane.mapper.pojo.TaskExample.Criteria;
import hust.plane.mapper.pojo.User;
import hust.plane.service.interFace.TaskService;
import hust.plane.utils.page.TailPage;
import hust.plane.utils.page.TaskPojo;
@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskMapper taskMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<TaskPojo> getALLTask() {
		TaskExample example=new TaskExample();
		//得到所有的任务
		List<Task> taskList = taskMapper.selectByExample(example);
		List<TaskPojo> list=null;
		//得到每个人的名称
		if(taskList!=null)
		{
			list=new ArrayList<TaskPojo>();
			for(Task task:taskList)
			{
				TaskPojo taskPojo=new TaskPojo();
				//查询姓名
				User user1 = userMapper.selectByPrimaryKey(task.getUseraid());
				User user2 = userMapper.selectByPrimaryKey(task.getUserbid());
				User user3 = userMapper.selectByPrimaryKey(task.getUsercid());
				taskPojo.setTask(task);
				taskPojo.setUserAName(user1.getUsername());
				taskPojo.setUserBName(user2.getUsername());
				taskPojo.setUserCName(user3.getUsername());
				list.add(taskPojo);
			}
		}
		return list;
	}

	//分页查询
	@Override
	public TailPage<TaskPojo> queryPage(Task task, TailPage<TaskPojo> page) {
		TaskExample example =new TaskExample();
		Criteria createCriteria = example.createCriteria();
		if("-1".equals(task.getStatus()))
		{
			task.setStatus(null);
		}
		else if(task.getStatus()!=null){
			createCriteria.andStatusEqualTo(task.getStatus());
		}
		if(task.getTaskid()!=null)
		{
			createCriteria.andTaskidEqualTo(task.getTaskid());
		}
		int itemsTotalCount = taskMapper.countByExample(example);
		List<Task> taskList = taskMapper.queryPage(task, page);
		//包装数据
		List<TaskPojo> items=null;
		if(taskList!=null)
		{
			items=new ArrayList<TaskPojo>();
			for(Task task1:taskList)
			{
				TaskPojo taskPojo=new TaskPojo();
				//查询姓名
				User user1 = userMapper.selectByPrimaryKey(task1.getUseraid());
				User user2 = userMapper.selectByPrimaryKey(task1.getUserbid());
				User user3 = userMapper.selectByPrimaryKey(task1.getUsercid());
				taskPojo.setTask(task1);
				taskPojo.setUserAName(user1.getUsername());
				taskPojo.setUserBName(user2.getUsername());
				taskPojo.setUserCName(user3.getUsername());
				items.add(taskPojo);
			}
		}
		page.setItemsTotalCount(itemsTotalCount);
		page.setItems(items);
		return page;
	}

	@Override
	public void saveTask(Task task) {
		taskMapper.insert(task);
		
	}
	
	

}
