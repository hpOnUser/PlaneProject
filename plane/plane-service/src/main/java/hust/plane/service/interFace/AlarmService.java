package hust.plane.service.interFace;

import hust.plane.mapper.pojo.Alarm;
import hust.plane.utils.page.AlarmPojo;
import hust.plane.utils.page.TailPage;

import java.util.List;


public interface AlarmService {

    List<Alarm> getAllAlarm();

    TailPage<AlarmPojo> queryAlarmWithPage(Alarm alarm, TailPage<AlarmPojo> page);

    Alarm selectAlarmById(String id);

    void updateAlarmStatus(String alarmid);

    int insertAlarmById(String planeId);
}
