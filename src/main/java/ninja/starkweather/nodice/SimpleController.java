package ninja.starkweather.nodice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ninja.starkweather.nodice.dice.dice;

import org.springframework.beans.factory.annotation.Value;

@Controller
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;
    
    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "index";
    }

    @RequestMapping(value = "/dice", params = {"diceName", "diceSides"})
    public @ResponseBody dice getDicePage(
        @RequestParam(value = "diceName") String diceName,
        @RequestParam(value = "diceSides") int diceSides
        ){
        return "dice";
    }

    @RequestMapping("/roll")
    public String rollPage(Model model) {
        model.addAttribute("appName", appName);
        return "roll";
    }
}