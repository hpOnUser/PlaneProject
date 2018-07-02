package hust.phone.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hust.phone.mapper.pojo.Task;
import hust.phone.mapper.pojo.User;
import hust.phone.service.interFace.UserService;
import hust.phone.service.interFace.taskService;

@Controller
public class TaskController {
	
	@Autowired
	private UserService userServiceImpl;
	@Autowired
	private taskService taskServiceImpl;
	
	//工作单跳转
	@RequestMapping("/toTask")
	public String toTaskList()
	{
		return "task";
	}
	
	//查询所有的工作单
	@RequestMapping("/taskList")
	public String taskList(String flag,HttpSession session,Model model)
	{
		Task task=new Task();
		//得到用户id
//		String userId =session.getAttribute("userid").toString();
		String userId="1";
		//得到用户
		User user=userServiceImpl.getUserById(userId);
		//得到用户角色
		String role=user.getRole();
		//根据用户角色，判断相应任务的用户
		if("1".equals(role))
		{
			task.setUserbid(user.getUserid());
		}
		else if("2".equals(role))
		{
			task.setUsercid(user.getUserid());
		}
		if("0".equals(flag))
		{
			//代表全部
			task.setFinishstatus(null);
		}else if("1".equals(flag))
		{
			//查询未完成
			task.setFinishstatus("1");
		}else if("2".equals(flag))
		{
			//查询完成
			task.setFinishstatus(flag);
		}
		List<Task> taskList = taskServiceImpl.getAllTask(task);
		model.addAttribute("taskList",taskList);
		return "taskDetail";
	}
}
