package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sirkleber on 24/05/16.
 */
@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(
      @RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model
    ){
        model.addAttribute("name", name);
        return "greeting";
    }
}
