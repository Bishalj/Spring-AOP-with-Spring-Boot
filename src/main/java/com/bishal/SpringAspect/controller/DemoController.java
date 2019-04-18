package com.bishal.SpringAspect.controller;

import com.bishal.SpringAspect.aspectConfig.LoggingActivity;
import com.bishal.SpringAspect.wrapper.DemoRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @LoggingActivity(source = "Renewals")
    @PostMapping("/create")
    public String create(@RequestBody DemoRequest demoRequest){
        System.out.println("Demo request from controller: "+demoRequest.toString());
        return "Done";
    }

    @LoggingActivity
    @PostMapping("/create2")
    public String create2(@RequestBody DemoRequest demoRequest){
        System.out.println("Demo request from controller: "+demoRequest.toString());
        return "Done";
    }
}

