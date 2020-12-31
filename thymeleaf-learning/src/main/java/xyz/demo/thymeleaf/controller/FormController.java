package xyz.demo.thymeleaf.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.demo.thymeleaf.entity.People;

import java.util.HashMap;

@Controller
public class FormController {

    @ModelAttribute
    public void controllerAttributes(Model model) {
        String[] professions = {
            "ENGINEER",
            "PHYSICIAN",
            "TEACHER",
            "LAWYER",
            "PHARMACIST",
            "ACCOUNTANT",
            "DENTIST",
            "ARCHITECT",
            "VETERINARIAN",
            "ELECTRICIAN",
            "PSYCHOLOGIST",
            "LIBRARIAN",
            "TECHNICIAN",
            "COOK"
        };

        model.addAttribute("professions", professions);

    }

    @GetMapping(path = "/form", produces = MediaType.TEXT_HTML_VALUE)
    public String formPage(@ModelAttribute People people, Model model) {
        return "form";
    }

    @PostMapping(path = "/form")
    public String formSubmit(@Validated @ModelAttribute People people, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            System.out.println("From has been rejected!");
            // for(ObjectError oe : bindingResult.getAllErrors()) {
            //     System.out.printf("Object name: %s\n", oe.getObjectName());
            //     System.out.printf("Code: %s\n", oe.getCode());
            //     System.out.printf("Default message: %s\n\n", oe.getDefaultMessage());
            // }
            return "form";
        }

        System.out.printf("name: %s -> %s\n", people.getName()+"", (people.getName()+"").getClass().getName());
        System.out.printf("age: %d\n", people.getAge());
        System.out.printf("email address: %s -> %s\n", people.getEmailAddress()+"", (people.getEmailAddress()+"").getClass().getName());
        System.out.printf("phone: %s -> %s\n", people.getPhone()+"", (people.getPhone()+"").getClass().getName());
        System.out.printf("profession: %s -> %s\n", people.getProfession()+"", (people.getProfession()+"").getClass().getName());
        System.out.printf("sex: %s -> %s\n", people.getSex()+"", (people.getSex()+"").getClass().getName());
        System.out.printf("remember me: %s\n", people.isRememberMe() ? "yes" : "no");

        model.addAttribute("userMap", new HashMap<>() {
            {
                put("name", "Robert");
                put("surname", "Bill");
            }
        });

        return "redirect:/home";
    }
}
