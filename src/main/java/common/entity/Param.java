package common.entity;

import java.util.Optional;

/**
 * 参数
 */
public class Param {

    private String field;

    private Param1 param1;

    private Optional<Param2> param2;

    public String getField() {
        return field;
    }

    public Param1 getParam1() {
        return param1;
    }

    public Optional<Param2> getParam2() {
        return param2;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setParam1(Param1 param1) {
        this.param1 = param1;
    }

    public void setParam2(Param2 param2) {
        this.param2 = Optional.ofNullable(param2);
    }

    public void a() {

    }

    public void b() {

    }
}
