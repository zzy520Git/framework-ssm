package com.jd.frameworkssm.service.impl;

import com.jd.frameworkssm.beanutil.BeanMapper;
import com.jd.frameworkssm.beanutil.test.From;
import com.jd.frameworkssm.beanutil.test.FromInner;
import com.jd.frameworkssm.beanutil.test.To;
import com.jd.frameworkssm.beanutil.test.ToInner;
import com.jd.frameworkssm.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2019/3/7 17:12
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);

    @Value("${framework.ssm.author}")
    private String author;
    @Autowired
    private BeanMapper beanMapper;

    @Override
    public int getAge() {
        From from = new From();
        FromInner inner = new FromInner();
        inner.setA(666);
        from.setList(Arrays.asList(inner));
        from.getMap().put("sb", "up");
        To to = beanMapper.map(from, beanMapper.getType(From.class), beanMapper.getType(To.class));
        ToInner o = to.getList().get(0);
        o.getA();

        LOGGER.error("framework.ssm.author={}", author);
        return -1;
    }

    @Override
    public int testUmp(int x, List<String> y) {
//        int a = 0;
//        int b = 100/a;
//        if(b>100) {
//            return 0;
//        }
        return 1;
    }
}
