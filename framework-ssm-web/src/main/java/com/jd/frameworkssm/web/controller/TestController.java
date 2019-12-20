package com.jd.frameworkssm.web.controller;

import com.jd.frameworkssm.service.TestService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2019/3/7 17:00
 */
@Controller
@RequestMapping("/test")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private TestService testService;

    @Value("${framework.ssm.version}")
    private Long version;

    @Value("${profile.env}")
    private String env;

    @RequestMapping("/index")
    public String test(HttpServletRequest request, Model model) {
        String uri = request.getRequestURI();
        String buf = request.getRequestURL().toString();
        String queryStr = request.getQueryString();
        if (StringUtils.isNotBlank(queryStr) && queryStr.contains("a=1")) {
            return "redirect://z.com";
        }
        System.out.println(uri);
        LOGGER.error("当前环境={},版本={}", env, version);
        int xx = testService.testUmp(1, Arrays.asList("zz"));
        //int age = testService.getAge();
        model.addAttribute("abc", null);
        return "index";
    }

}
