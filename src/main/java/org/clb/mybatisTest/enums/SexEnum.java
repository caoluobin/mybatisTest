package org.clb.mybatisTest.enums;

public enum SexEnum {
    MAN(0,"男"),
    WOMAN(1,"女");
    private Integer value;
    private String name;

    SexEnum(Integer value,String name) {
        this.value = value;
        this.name = name;
    }
    public static SexEnum  findSexEnumByValue(Integer value) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.value==value) {
                return sexEnum;
            }
        }
        return SexEnum.MAN;
    }
    public static SexEnum  findSexEnumByName(String name) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.name.equals(name)) {
                return sexEnum;
            }
        }
        return SexEnum.MAN;
    }
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
