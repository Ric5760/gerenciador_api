package com.freitas.api.controller;


import com.freitas.api.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CustomController {

    @Autowired
    CustomService customService;

    @GetMapping("{apiName}")
    public List<Map<String, Object>> executeApi(@PathVariable String apiName) {
        return customService.executeSqlScript(apiName);
    }

}
