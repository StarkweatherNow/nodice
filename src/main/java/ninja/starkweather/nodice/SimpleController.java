package ninja.starkweather.nodice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;

    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "index";
    }

    @RequestMapping("/dice")
    public String dicePage(Model model) {
        model.addAttribute("appName", appName);
        return "dice";
    }

    @RequestMapping("/roll")
    public String rollPage(Model model) {
        model.addAttribute("appName", appName);
        return "roll";
    }
}