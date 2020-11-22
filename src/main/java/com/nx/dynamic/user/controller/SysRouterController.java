package com.nx.dynamic.user.controller;

import com.nx.dynamic.dict.model.DictEntity;
import com.nx.dynamic.dict.service.SysDictService;
import com.nx.dynamic.user.dao.RouterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/system/router")
@ResponseBody
public class SysRouterController {

    @Autowired
    RouterRepository routerRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Object list(Long id){
        return routerRepository.getName(id);
    }
}
