package com.jd.frameworkssm.beanutil.test;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2019/7/8 19:26
 * @ see
 * @since
 */
@Data
public class To {
    private Integer a = 1;
    private Map<String, String> map = new HashMap<>();
    private List<ToInner> list = new ArrayList<>();
}
