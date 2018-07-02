package hust.phone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hust.phone.mapper.mapper.TaskMapper;
import hust.phone.mapper.pojo.Task;
import hust.phone.mapper.pojo.TaskExample;
import hust.phone.mapper.pojo.TaskExample.Criteria;
import hust.phone.service.interFace.taskService;
@Service
public class TaskServiceImpl implements taskService {

	@Autowired
	private TaskMapper taskMapper;
	@Override
	public List<Task> getAllTask(Task task) {
		TaskExample example=new TaskExample();
		Criteria createCriteria = example.createCriteria();
		if(task.getUseraid()!=null)
		{
			createCriteria.andUserbidEqualTo(task.getUseraid());
		}
		if(task.getUsercid()!=null)
		{
			createCriteria.andUsercidEqualTo(task.getUsercid());
		}
		if(task.getStatus()!=null)
		{
			createCriteria.andStatusEqualTo(task.getStatus());
		}
		if(task.getFinishstatus()!=null)
		{
			createCriteria.andFinishstatusEqualTo(task.getFinishstatus());
		}
		List<Task> taskList = taskMapper.selectByExample(example);
		return taskList;
	}

}
