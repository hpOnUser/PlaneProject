package hust.phone.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import hust.phone.service.interFace.testService;
import hust.phone.utils.HttpClientUtil;
@Service
public class testServiceImpl implements testService{
	@Value("${PLANE_URL}")
	private String PLANE_URL;
	@Value("${PROJECT_NAME}")
	private String PROJECT_NAME;
	@Value("${PLANE_TEST}")
	private String PLANE_TEST;
	@Override
	public String testCon() {

//		String url=PLANE_URL+PLANE_PORT+"/test";
		String url=PLANE_URL+PROJECT_NAME+PLANE_TEST;
		String json=HttpClientUtil.doGet(url);
		return json;
	}

}
