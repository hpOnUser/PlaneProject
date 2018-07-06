package hust.plane.service.interFace;

import java.util.List;

import hust.plane.mapper.pojo.Alarm;
import hust.plane.utils.page.AlarmPojo;
import hust.plane.utils.page.TailPage;



public interface AlarmService {

	List<Alarm> getAllAlarm();
	TailPage<AlarmPojo> queryAlarmWithPage(Alarm alarm, TailPage<AlarmPojo> page);

}
