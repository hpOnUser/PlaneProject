package hust.phone.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	// 工作单跳转
	@RequestMapping("/toTask")
	public String toTaskList() {
		return "task";
	}

	// 查询所有的工作单
	@RequestMapping("/taskList")
	public String taskList(String flag, HttpSession session, Model model) {
		Task task = new Task();
		// 得到用户id
		// String userid =session.getAttribute("userid").toString();
		String userId = "1"; // 起飞
		// 得到用户
		User user = userServiceImpl.getUserById(userId);
		// 得到用户角色
		String role = user.getRole();
		List<Task> taskList = new ArrayList<Task>();
		
		//判断是哪类查询条件
		switch (flag) {
		case "0":
			task.setFinishstatus("0");
			break;
		case "1":
			task.setFinishstatus("1");
			break;
		default:
			task.setFinishstatus(null);
			break;
		}
		// 根据用户角色，判断相应任务的用户
		if ("1".equals(role)) {

			task.setUserbid(user.getUserid());
			taskList = taskServiceImpl.getAllTask(task);
			model.addAttribute("taskList", taskList);
			return "C1subtasklist";

		} else {

			task.setUsercid(user.getUserid());
			taskList = taskServiceImpl.getAllTask(task);
			model.addAttribute("taskList", taskList);
			return "C2subtasklist";
		}

	}
	
	@RequestMapping("getTaskNumber")
	@ResponseBody
	public User getTaskNumber(String userid){
		
		
		
		
		
		return null;
	}

}
