package hust.phone.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hust.phone.service.interFace.testService;

@Controller
public class testController {
	@Autowired
	private testService testServiceimpl;
	
	//产生任务提示模态框
	@RequestMapping("/index")
	public String testindex(Model model)
	{
		String testCon = testServiceimpl.testCon();
		model.addAttribute("sname",testCon);
		return "test";
	}

}
