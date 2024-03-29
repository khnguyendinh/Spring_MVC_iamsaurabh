package org.saurabhsood.controllers;

import org.saurabhsood.bean.User;
import org.saurabhsood.exception.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by saurabh on 2/11/17.
 */
@Controller
public class HelloController {
    @RequestMapping("/index")
    public String index() {
        return "home";
    }
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String doGetAddUser(Model model) {
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new User());
        }
        return "add-user";
    }
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String doPostAddUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "add-user";
        }
        return "view-user";
    }
    @RequestMapping(value = "/unauthorizedException")
    public String testUnauthorizedException() throws IOException {
        throw new UnauthorizedException();
    }

    @ExceptionHandler(NullPointerException.class)
    public String processNullPointerException() {
        return "null-pointer-exception";
    }
    @RequestMapping(value = "/nullPointerException")
    public String testNullPointerException() throws NullPointerException {
        throw new NullPointerException("this is null pointer exception");
    }
    @RequestMapping(value = "/ioException")
    public String testIOException() throws IOException {
        throw new IOException("this is io exception");
    }

}