package hust.plane.web.controller.admin;

import hust.plane.mapper.pojo.User;
import hust.plane.service.interFace.UserService;
import hust.plane.utils.page.TailPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;


@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "toUserCreate", method = RequestMethod.GET)
    public String userModify(TailPage<User> page, Model model) {
        page = userService.getAllUserWithPage(page);
        model.addAttribute("page",page);
        return "userModify";
    }
}
