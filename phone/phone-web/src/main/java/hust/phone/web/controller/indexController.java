package hust.phone.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
	
	@RequestMapping("/Myidnex")
	public String index()
	{
		return "index";
	}

}
