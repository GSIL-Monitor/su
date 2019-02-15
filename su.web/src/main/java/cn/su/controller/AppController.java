package cn.su.controller;

import cn.su.TaskControlDomain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/su")
public class AppController {

    @RequestMapping("/list")
    public String getTaskControlInfo(){

        return "list";
    }

    @RequestMapping("/check")
    public void check(String data){
        String regEx = "^\\w+$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(data);
        boolean matches = matcher.matches();
        System.out.println("格式是否正确"+matches);
    }


}
