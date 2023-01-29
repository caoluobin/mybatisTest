package org.clb.mybatisTest.config.handler;

import org.apache.ibatis.type.EnumOrdinalTypeHandler;

public class MySexEnumTypeHandler  extends EnumOrdinalTypeHandler {
    public MySexEnumTypeHandler(Class type) {
        super(type);
    }
}
