package com.tasteele.examples.basicspringboot.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        return "Hello and welcome to the Basic SpringBoot Example.";
    }
}
