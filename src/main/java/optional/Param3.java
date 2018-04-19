package optional;

import java.util.Optional;

public class Param3 {

    private Optional<String> field3;

    public Optional<String> getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = Optional.ofNullable(field3);
    }
}