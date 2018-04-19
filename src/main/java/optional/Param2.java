package optional;

import java.util.Optional;

public class Param2 {

    private String field2;

    private Optional<Param3> param3;

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public Optional<Param3> getParam3() {
        return param3;
    }

    public void setParam3(Param3 param3) {
        this.param3 = Optional.ofNullable(param3);
    }
}