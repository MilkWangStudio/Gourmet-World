package com.github.milk.gourmet.controller;

import com.github.milk.gourmet.domain.GourmetFacility;
import com.github.milk.gourmet.domain.Result;
import com.github.milk.gourmet.service.GourmetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/gourmet")
public class GourmetController {
    @Resource
    private GourmetService gourmetService;

    @GetMapping("/facilities")
    public Result<List<GourmetFacility>> queryFacilities() {
        return gourmetService.queryFacilities();
    }
}
