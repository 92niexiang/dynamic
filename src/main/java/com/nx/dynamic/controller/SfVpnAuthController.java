package com.nx.dynamic.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sangfor/vpn/auth")
public class SfVpnAuthController {

    @RequestMapping(method = RequestMethod.GET)
    public Object list(){
        return "GET";
    }

}
