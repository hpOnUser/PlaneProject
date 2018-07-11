package hust.phone.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
	
	@RequestMapping("/myindex")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("/toPlane")
	public String toPlane()
	{
		return "fight";
	}

}
