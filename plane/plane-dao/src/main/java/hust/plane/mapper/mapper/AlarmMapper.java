package hust.plane.mapper.mapper;

import java.util.List;

import hust.plane.mapper.pojo.Alarm;
import hust.plane.utils.page.AlarmPojo;
import hust.plane.utils.page.TailPage;



public interface AlarmMapper {

	List<Alarm> selectALLAlarm();
	List<Alarm> selectAllAlarmByCreateTimeDesc();
	int alarmCount();
	List<Alarm> queryAlarmPage(Alarm alarm, TailPage<AlarmPojo> page);
    Alarm selectInfoById(String id);
}
