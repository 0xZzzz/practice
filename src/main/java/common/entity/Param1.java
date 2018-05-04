package common.entity;

import java.util.Objects;

public class Param1 {

    private int intField;

    private String field1;

    public Param1() {
    }

    public Param1(int intField, String field1) {
        this.intField = intField;
        this.field1 = field1;
    }

    public int getIntField() {
        return intField;
    }

    public void setIntField(int intField) {
        this.intField = intField;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Param1 param1 = (Param1) o;
        return intField == param1.intField &&
                Objects.equals(field1, param1.field1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intField, field1);
    }

    @Override
    public String toString() {
        return "Param1{" +
                "intField=" + intField +
                ", field1='" + field1 + '\'' +
                '}';
    }
}