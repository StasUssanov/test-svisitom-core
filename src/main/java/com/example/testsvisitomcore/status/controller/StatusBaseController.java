package com.example.testsvisitomcore.status.controller;

import com.example.testsvisitomcore.status.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public abstract class StatusBaseController {

    @Autowired
    protected StatusService statusService;

}
