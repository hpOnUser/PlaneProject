package hust.plane.service.impl;

import hust.plane.constant.WebConst;
import hust.plane.mapper.mapper.AlarmMapper;
import hust.plane.mapper.pojo.Alarm;
import hust.plane.service.interFace.AlarmService;
import hust.plane.utils.ImgUtils;
import hust.plane.utils.page.AlarmPojo;
import hust.plane.utils.page.TailPage;
import hust.plane.utils.pojo.TipException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AlarmServiceImpl implements AlarmService {
    private static Logger logger = LoggerFactory.getLogger(AlarmService.class);
    @Autowired
    public AlarmMapper alarmMapper;

    @Override
    public List<Alarm> getAllAlarm() {

        List<Alarm> alarmList = alarmMapper.selectALLAlarm();
        return alarmList;
    }

    @Override
    public TailPage<AlarmPojo> queryAlarmWithPage(Alarm alarm, TailPage<AlarmPojo> page) {

        int count = alarmMapper.alarmCount(alarm);
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

    @Override
    public void updateAlarmStatus(String alarmid) {
        alarmMapper.updateByAlarmId(alarmid);

    }

    @Override
    public int insertAlarmById(String planeId) {
        try {
            if (StringUtils.isBlank(planeId)) {
                logger.error("输入的无人机编号为空");
                throw new TipException("输入的无人机编号为空");
            }
            List<Alarm> alarmList = new ArrayList<>();
            alarmList = ImgUtils.alarmList(WebConst.ALARM_PIC_PATH, planeId);
            if(alarmList.size()==0){
                throw new TipException("文件夹内无告警图片");
            }
            for(Alarm alarm:alarmList){
                int count = alarmMapper.insertAlarmSelective(alarm);
                if(count<1){
                    logger.error("告警点插入错误");
                    throw new TipException("告警点插入错误");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;
    }
}
