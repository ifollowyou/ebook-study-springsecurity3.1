package com.packtpub.springsecurity.web.controller;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("th")
public class ThymeLeafLayoutController {

    @RequestMapping(value = "content1", method = RequestMethod.GET)
    public String content1() {
        return "th/content1";
    }

    @RequestMapping(value = "content2", method = RequestMethod.GET)
    public String content2() {
        return "th/content2";
    }

    @RequestMapping(value = "content3", method = RequestMethod.GET)
    public String content3() {
        return "th/content3";
    }

    @RequestMapping(value = "json", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> json() {
        Map<String, String> result = Maps.newHashMap();
        result.put("key", "value");

        return result;
    }

}
