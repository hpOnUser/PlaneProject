package hust.plane.web.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hust.plane.mapper.mapper.TaskMapper;
import hust.plane.mapper.pojo.Task;
import hust.plane.mapper.pojo.User;
import hust.plane.service.interFace.TaskService;
import hust.plane.utils.page.TailPage;
import hust.plane.utils.page.TaskPojo;

@Controller
public class taskController {
	
	
	@Autowired
	private TaskService taskServiceImpl;
	
	@RequestMapping("/task")	
	public String gettestTask()
	{
		return "taskList";
	}
	
	//得到所有的任务
	@RequestMapping("/taskList")
	public String getALLTask(Model model)
	{
		List<TaskPojo> allTask = taskServiceImpl.getALLTask();
		model.addAttribute("taskList",allTask);
		return "taskList";
	}
	//跳转新建任务
	@RequestMapping("/toTaskCreate")
	public String toTaskCrate()
	{
		return "createTask";
	}
	//创建任务
	@RequestMapping("/taskCreate")
	public String createTask(Task task)
	{
		//初始状态为0受理中
		task.setStatus("0");
		taskServiceImpl.saveTask(task);
		return "redirect:/taskPageList";
	}
	
	//分页查询
	@RequestMapping("/taskPageList")
	public String queryPage(Task task,TailPage<TaskPojo> page,Model model)
	{
		if(StringUtils.isNotEmpty(task.getTaskid()))
		{
			task.setTaskid(task.getTaskid());
		}else
		{
			task.setTaskid(null);
		}
		
		if("-1".equals(task.getStatus()))
		{
			//查询全部
			task.setStatus(null);
		}
		page = taskServiceImpl.queryPage(task, page);
		model.addAttribute("page", page);
		
		return "taskList";
	}
	
 
}
