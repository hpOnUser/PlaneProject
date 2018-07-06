package hust.plane.web.controller;

import hust.plane.mapper.pojo.Alarm;
import hust.plane.service.interFace.AlarmService;
import hust.plane.utils.page.AlarmPojo;
import hust.plane.utils.page.TailPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;


@Controller
public class AlarmHistoryController {
    @Resource
    private AlarmService alarmService;

    @RequestMapping(value = "alarmHistory")
    public String alarmHistoryQueryPage(Alarm alarm, TailPage<AlarmPojo> page, Model model) {
        page = alarmService.queryAlarmWithPage(alarm,page);
        model.addAttribute("page",page);
        return "alarmHistory";
    }
}
