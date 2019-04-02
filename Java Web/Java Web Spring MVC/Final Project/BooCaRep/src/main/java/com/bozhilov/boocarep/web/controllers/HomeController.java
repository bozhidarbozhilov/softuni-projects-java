package com.bozhilov.boocarep.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getIndexPage(){
        return "index";
    }
}
