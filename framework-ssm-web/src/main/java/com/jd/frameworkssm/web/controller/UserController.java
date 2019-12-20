package com.jd.frameworkssm.web.controller;

import com.jd.frameworkssm.common.result.ResponseResult;
import com.jd.frameworkssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2019/3/10 13:03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/insert")
    public ResponseResult insert() {
        userService.insertOne();
        return ResponseResult.success("成功");
    }
}
