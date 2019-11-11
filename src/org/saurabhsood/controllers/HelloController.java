package org.saurabhsood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}