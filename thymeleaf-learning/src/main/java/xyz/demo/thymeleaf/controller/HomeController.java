package xyz.demo.thymeleaf.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

//    @ModelAttribute
//    public Map<String, String> userMap() {
//        return new HashMap<>() {
//            {
//                put("name", "Robert");
//                put("surname", "Bill");
//            }
//        };
//    }



    @GetMapping(path = {"/", "/home", "/index"}, produces = MediaType.TEXT_HTML_VALUE)
    public String home(Model model,
    @RequestParam(name = "p", defaultValue = "nothing") String p) {
        model.addAttribute("userMap", new HashMap<>() {
            {
                put("name", "Robert");
                put("surname", "Bill");
            }
        });
//        System.out.println(p);
        return "home";
    }

}
