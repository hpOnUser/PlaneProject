package hust.plane.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hust.plane.mapper.mapper.AlarmMapper;
import hust.plane.mapper.pojo.Alarm;
import hust.plane.service.interFace.AlarmService;

@Service
public class AlarmServiceImpl implements AlarmService {

	@Autowired
	public AlarmMapper alarmMapper;
	
	@Override
	public List<Alarm> getAllAlarm() {
		
		List<Alarm> alarmList = alarmMapper.selectALLAlarm();
		return alarmList;
	}

}
