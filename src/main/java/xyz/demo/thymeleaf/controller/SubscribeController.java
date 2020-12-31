package xyz.demo.thymeleaf.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Controller
public class SubscribeController {

    @PostMapping(path = {"/subscribe/submit", "/subscribe/go"}, produces = MediaType.TEXT_HTML_VALUE)
    public String subscribeSubmit(
    @RequestParam(name = "email", defaultValue = "noemail") String emailField,
    @RequestParam(name = "password", defaultValue = "nopass") String passwordField) {
        String message = String.format("email: %s\npassword: %s\n", emailField, passwordField);
        System.out.println(message);
        return "redirect:/subscribe/form";
    }

    @GetMapping(path = {"/subscribe/form"}, produces = MediaType.TEXT_HTML_VALUE)
    public String subscribeForm(
    SessionLocaleResolver localeResolver,
    @RequestParam(name = "locale", defaultValue = "en_US") String locale) {
        localeResolver.setLocaleAttributeName(locale);
        return "subscribe";
    }
}
