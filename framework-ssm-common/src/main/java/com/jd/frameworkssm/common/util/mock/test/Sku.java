package com.jd.frameworkssm.common.util.mock.test;

import com.jd.frameworkssm.common.util.mock.MockObj;
import com.jd.frameworkssm.common.util.mock.MockValue;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2019/8/8 20:06
 * @ see
 * @since
 */
@Data
public class Sku {
    @MockValue("1993-05-20 06:07:08")
    private Date date;

    @MockValue("666.777")
    private BigDecimal num;

    @MockValue({"123456789", "987654321"})
    private Long time;

    private Set<Base> sets;

    @MockObj(Child.class)
    private List<? extends Code> codes;

    private SkuExt exts;

    private AbcEnum abc;

    @MockObj(Base.class)
    private JPage<Base> bases;

    @Data
    public static class Base {
        @MockValue("521")
        private String base;
        @MockValue("520")
        private int baseInt;
    }

    @Data
    public static class Child extends Base implements Code {
        private String child;
        private Boolean childBool;
        private Integer childInt;
        private Vender v;

        @Override
        public int getCode() {
            return 999;
        }

        @Data
        public static class Vender {
            private Vender ved;
            private char ch;
            private double d = 1.0;
        }
    }

    @Data
    public static class SkuExt {
        private List<SkuExt> exts1;
        @MockValue("extStr")
        private String extStr;
    }

    @Getter
    public static enum AbcEnum {
        A(0, "123");
        private int code;
        private String desc;
        AbcEnum(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }
}










