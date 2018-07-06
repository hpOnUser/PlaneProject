package hust.plane.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hust.plane.utils.page.AlarmPojo;
import hust.plane.utils.page.TailPage;
import org.apache.commons.lang.StringUtils;
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

    @Override
    public TailPage<AlarmPojo> queryAlarmWithPage(Alarm alarm, TailPage<AlarmPojo> page) {
        int count = alarmMapper.alarmCount();
        page.setItemsTotalCount(count);
        List<Alarm> alarmList = alarmMapper.queryAlarmPage(alarm, page);
        List<AlarmPojo> alarmPojos = new ArrayList<>();
        Iterator<Alarm> iterator = alarmList.iterator();
        while (iterator.hasNext()) {
            alarm = iterator.next();
            alarmPojos.add(new AlarmPojo(alarm));
        }
        page.setItems(alarmPojos);
        return page;
    }

    @Override
    public Alarm selectAlarmById(String id) {
        if (StringUtils.isNotBlank(id)) {
            return alarmMapper.selectInfoById(id);
        }
        return null;
    }
}
