package ninja.starkweather.nodice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;

@Controller
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;

    //Variables for the dice page
    @Value("${dice.name}")
    String diceName;
    @Value("${dice.sides}")
    String diceSides;
    @Value("${dice.value}")
    String diceValue;
    @Value("${dice.border}")
    String diceBorder;
    @Value("${dice.font}")
    String diceFont;
    @Value("${dice.texture}")
    String diceTexture;
    @Value("${dice.borderColor}")
    String diceBorderColor;
    @Value("${dice.fontColor}")
    String diceFontColor;
    @Value("${dice.backgroundColor}")
    String diceBackgroundColor;
    
    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "index";
    }

    @RequestMapping("/dice")
    public String dicePage(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("diceSides", diceSides);
        model.addAttribute("diceValue", diceValue);
        model.addAttribute("diceBorder", diceBorder);
        model.addAttribute("diceFont", diceFont);
        model.addAttribute("diceTexture", diceTexture);
        model.addAttribute("diceBorderColor", diceBorderColor);
        model.addAttribute("diceFontColor", diceFontColor);
        model.addAttribute("diceBackgroundColor", diceBackgroundColor);
        return "dice";
    }

    @RequestMapping("/roll")
    public String rollPage(Model model) {
        model.addAttribute("appName", appName);
        return "roll";
    }
}