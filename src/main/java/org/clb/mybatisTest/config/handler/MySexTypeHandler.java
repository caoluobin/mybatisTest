package org.clb.mybatisTest.config.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.clb.mybatisTest.enums.SexEnum;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.VARCHAR)
public class MySexTypeHandler  extends BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        //入参设置
        SexEnum sexEnum = SexEnum.findSexEnumByName(parameter);
        ps.setInt(i, sexEnum.getValue());
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        SexEnum sexEnum = SexEnum.findSexEnumByValue(rs.getInt(columnName));
        return sexEnum.getName();
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        SexEnum sexEnum = SexEnum.findSexEnumByValue(rs.getInt(columnIndex));
        return sexEnum.getName();
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        SexEnum sexEnum = SexEnum.findSexEnumByValue(cs.getInt(columnIndex));
        return sexEnum.getName();
    }
}
