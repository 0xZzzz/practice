package java8.optional;

import common.entity.Param;
import common.entity.Param2;
import common.entity.Param3;

import java.util.Optional;

/**
 * Optional测试
 */
public class OptionalTest {

    public static void main(String[] args) {
        Param param = new Param();
        Param2 param2 = new Param2();
        Param3 param3 = new Param3();
        String filed3 = "field3";
        param3.setField3(filed3);
        param2.setParam3(param3);
        param.setParam2(param2);
        System.err.println(getField3(param));
    }

    /**
     * 获取field3
     */
    private static String getField3(Param param) {
        Optional<Param> paramOptional = Optional.ofNullable(param);
        return paramOptional.flatMap(Param::getParam2).flatMap(Param2::getParam3).flatMap(Param3::getField3).orElse("default");
    }

}
