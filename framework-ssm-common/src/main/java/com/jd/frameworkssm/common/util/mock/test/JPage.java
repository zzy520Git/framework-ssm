package com.jd.frameworkssm.common.util.mock.test;

import com.jd.frameworkssm.common.util.mock.MockValue;
import lombok.Data;

import java.util.List;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2019/8/8 20:07
 * @ see
 * @since
 */
@Data
public class JPage<T> {
    private static final long serialVersionUID = -5987590313658059295L;
    private List<T> data;
    @MockValue({"666", "888"})
    private Integer totalCount;
    @MockValue("2")
    private int currentPage;
}
