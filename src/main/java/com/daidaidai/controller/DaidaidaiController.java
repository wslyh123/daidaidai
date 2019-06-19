package com.daidaidai.controller;

import com.alibaba.fastjson.JSONObject;
import com.daidaidai.entity.Test;
import com.daidaidai.util.blasphemyUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DaidaidaiController {

    @RequestMapping(value = "test", method = RequestMethod.POST)
    public JSONObject addMachineSq(@RequestBody Test test) {
        boolean flag = blasphemyUtil.calculate(test);
        JSONObject json = new JSONObject();
        json.put("flag", flag);
        json.put("test", test);
        return json;
    }
}
