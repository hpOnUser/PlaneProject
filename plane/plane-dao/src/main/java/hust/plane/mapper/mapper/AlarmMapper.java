package hust.plane.mapper.mapper;

import hust.plane.mapper.pojo.Alarm;
import hust.plane.utils.page.AlarmPojo;
import hust.plane.utils.page.TailPage;

import java.util.List;



public interface AlarmMapper {

	List<Alarm> selectALLAlarm();
	List<Alarm> selectAllAlarmByCreateTimeDesc();
	int alarmCount(Alarm alarm);
	List<Alarm> queryAlarmPage(Alarm alarm, TailPage<AlarmPojo> page);
    Alarm selectInfoById(String id);
	void updateByAlarmId(String alarmid);
    int insertAlarmSelective(Alarm alarm);
	void updateDesByAlarmId(String alarmid, String description);
	List<Alarm> getAlarmsByTaskId(String taskid);
}
