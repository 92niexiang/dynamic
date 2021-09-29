package com.nx.dynamic.dict.controller;

import com.nx.dynamic.dict.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/system/dict")
@ResponseBody
public class SysDictController {

    @Autowired
    SysDictService sysDictService;

    @RequestMapping(method = RequestMethod.GET)


    public Object list(Long id){
        return sysDictService.getOldName(id);
    }

}
