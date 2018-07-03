package hust.plane.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import hust.plane.mapper.pojo.Route;
import hust.plane.service.impl.FileServiceImpl;
import hust.plane.service.interFace.FileService;

@Controller
public class FileController {
	@Autowired
	private FileService FileServiceImpl;
	
	@RequestMapping("/oneFileImport")
	public String importOneFile(@RequestParam("routePathExcel") MultipartFile file,Route route)
	{
=======
		String filename=file.getOriginalFilename();
>>>>>>> branch 'master' of https://github.com/hpOnUser/PlaneProject.git
		//得到数据插入
		
		
		//String filename="D:\\test2.xlsx";
		FileServiceImpl.insertRoute(filename, route);
		return "success";
	}

}
