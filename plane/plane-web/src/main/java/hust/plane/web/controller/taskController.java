package hust.plane.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import hust.plane.utils.DateKit;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hust.plane.mapper.pojo.Plane;
import hust.plane.mapper.pojo.PlanePath;
import hust.plane.mapper.pojo.Task;
import hust.plane.mapper.pojo.User;
import hust.plane.service.interFace.PlanePathService;
import hust.plane.service.interFace.PlaneService;
import hust.plane.service.interFace.TaskService;
import hust.plane.service.interFace.UserService;
import hust.plane.utils.PlaneUtils;
import hust.plane.utils.page.TailPage;
import hust.plane.utils.page.TaskPojo;
import hust.plane.utils.pojo.JsonView;

@Controller
public class taskController {
	
	
	@Autowired
	private TaskService taskServiceImpl;
	@Autowired
	private PlanePathService planePathServiceImpl;
	@Autowired
	private UserService userServiceImpl;
	@Autowired
	private PlaneService planeServiceImpl;
	
	
	
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
		model.addAttribute("curNav", "taskAllList");
		return "taskList";
	}
	//跳转新建任务
	@RequestMapping("/toTaskCreate")
	public String toTaskCrate(Model model,Task task,HttpServletRequest request)
	{
		//操作者
		//放飞者
		//回收者
		//无人机编号
		//飞行路线
		User aUser = PlaneUtils.getLoginUser(request);
		User userExmple = new User();
		userExmple.setRole("1");
		List<User> bUsers =  userServiceImpl.findByUserRole(userExmple);
		userExmple.setRole("2");
		List<User> cUsers =  userServiceImpl.findByUserRole(userExmple);
		Plane plane = new Plane();
		plane.setStatus("1");
		List<Plane> planes = planeServiceImpl.findByPlaneStatus(plane);
		
		List<PlanePath> planePaths = planePathServiceImpl.findAllplanePath();
		
		model.addAttribute("aUser",aUser);
		model.addAttribute("bUsers",bUsers);
		model.addAttribute("cUsers",cUsers);
		model.addAttribute("planes",planes);
		model.addAttribute("planePaths",planePaths);

		task.setPlantime(DateKit.get2HoursLater());
		//在这传输数据
		model.addAttribute("task", task);
		model.addAttribute("curNav", "createTask");
		return "createTask";
	}
	//创建任务
	@RequestMapping("/taskCreate")
	public String createTask(Task task,HttpServletRequest request)
	{
		//初始状态为1归档
		task.setStatus("1");
		User aUser = PlaneUtils.getLoginUser(request);
		
		task.setUseraid(aUser.getUserid());
		taskServiceImpl.saveTask(task);    //保存新建的任务


		User userb = new User();
		User userc = new User();
		userb.setUserid(task.getUserbid());
		userc.setUserid(task.getUsercid());
		userServiceImpl.updataTasknumByUser(userb);
		userServiceImpl.updataTasknumByUser(userc);    //并且把操作员的任务数量+1

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
		model.addAttribute("selectStatus", task.getStatus());
		model.addAttribute("page", page);
		model.addAttribute("curNav", "taskAllList");
		return "taskList";
	}
	
	@RequestMapping(value = "onsureFly", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String onsureFly(Task task) {
		
		
		taskServiceImpl.setStatusTaskByTask(task,"7");
		
		return JsonView.render(1,"已确认，可以放飞");
	}
	
	@RequestMapping(value = "taskReport", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String taskReport(Task task,HttpServletRequest request) {
		
		Task task2 = taskServiceImpl.getTaskByTask(task);
		String status = task2.getStatus();
		
		User bUser = userServiceImpl.getUserById(task2.getUserbid());
		User cUser = userServiceImpl.getUserById(task2.getUsercid());
		
		if(status.equals("9")) {
			taskServiceImpl.setStatusTaskByTask(task,"10");       //设置任务完成
			taskServiceImpl.setFinishStatusTaskByTask(task,"1");
			
			userServiceImpl.reduceTasknumByUser(bUser);      //减少bc任务数目
			userServiceImpl.reduceTasknumByUser(cUser);
			
			return JsonView.render(1,"任务完成，打印飞行报告!");
		}
		else {
			
			return JsonView.render(1,"任务未完成，不可打印报告!");
		}			
	}
	
 
}
