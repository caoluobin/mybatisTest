package org.clb.mybatisTest.plugins;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.clb.mybatisTest.annotions.AreaTable;
import org.clb.mybatisTest.annotions.YearSplit;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

//@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class EditQuerySqlInterceptor implements Interceptor {
    public static <T> T realTarget(Object target) {
        if (Proxy.isProxyClass(target.getClass())) {
            MetaObject metaObject = SystemMetaObject.forObject(target);
            return realTarget(metaObject.getValue("h.target"));
        } else {
            return (T)target;
        }
    }
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = realTarget(invocation.getTarget());
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
        //先拦截到RoutingStatementHandler，里面有个StatementHandler类型的delegate变量，其实现类是BaseStatementHandler，然后就到BaseStatementHandler的成员变量mappedStatement
        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        //id为执行的mapper方法的全路径名，如com.uv.dao.UserMapper.insertUser
        String id = mappedStatement.getId();

        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        String mSql = sql;

        //注解逻辑判断  添加注解了才拦截
        Class<?> classType = Class.forName(mappedStatement.getId().substring(0, mappedStatement.getId().lastIndexOf(".")));
        AreaTable areaTableAnnotation = classType.getAnnotation(AreaTable.class);
        YearSplit yearSplitAnnotation = classType.getAnnotation(YearSplit.class);

        if (areaTableAnnotation!=null && areaTableAnnotation.flag()) {
            mSql = areaCodeEdit(mappedStatement.getSqlCommandType(), mSql);
        }
        if (yearSplitAnnotation!=null) {
            mSql = splitYearSql(mappedStatement.getSqlCommandType(), boundSql, mSql, yearSplitAnnotation);
        }


        //通过反射修改sql语句
        Field field = boundSql.getClass().getDeclaredField("sql");
        field.setAccessible(true);
        field.set(boundSql, mSql);
        return invocation.proceed();
    }

    /**
     * 增加区域码
     *
     * @param sql
     * @return
     */
    private String areaCodeEdit(SqlCommandType cmdType, String sql) {

        if ((SqlCommandType.SELECT.equals(cmdType))
                || SqlCommandType.UPDATE.equals(cmdType)
                || SqlCommandType.DELETE.equals(cmdType)) {
            int order_by = sql.indexOf(" ORDER BY ");
            int where = sql.indexOf(" WHERE ");

            String appendStr = "";
//            if (LoginContextHolder.me().getSysLoginUser().getAreaCode() == null) {
//                appendStr = " AND area_code is null ";
//            } else {
//                appendStr = " AND area_code = '" + LoginContextHolder.me().getSysLoginUser().getAreaCode() + "' ";
//            }
//            if (where < 0) {
//                appendStr = " WHERE (area_code = '" + LoginContextHolder.me().getSysLoginUser().getAreaCode() + "') ";
//            }
            if (order_by < 0) {
                return sql + appendStr;
            } else {
                return sql.replace(" ORDER BY ", appendStr + " ORDER BY ");
            }
        }

        return sql;
    }

    /**
     * 按年份分表
     *
     * @param sql
     * @return
     */
    private String splitYearSql(SqlCommandType cmdType, BoundSql boundSql, String sql, YearSplit yearSplit) throws IntrospectionException, InvocationTargetException, IllegalAccessException {

        String year = "";
        if ((SqlCommandType.SELECT.equals(cmdType)
                || SqlCommandType.DELETE.equals(cmdType)
                || SqlCommandType.UPDATE.equals(cmdType)) && sql.contains(yearSplit.tableFiledName() + " =")) {
            // 找到对应字段的占位符位置
            String[] splitSql = sql.split("\\?");
            int index = 0;
            for (; index < splitSql.length; index++) {
                // 找到 【uyear =】
                if (splitSql[index].contains(yearSplit.tableFiledName() + " =")) {
                    break;
                }
            }

            List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
            ParameterMapping parameterMapping = parameterMappings.get(index);
            if (parameterMapping.getMode() != ParameterMode.OUT) {
                Object value;
                String propertyName = parameterMapping.getProperty();
                String[] split = propertyName.split("\\.");

//                if (SqlCommandType.SELECT.equals(cmdType)) {
//                    try {
//                        year = ((QueryWrapper) (((HashMap) boundSql.getParameterObject()).get("ew"))).getParamNameValuePairs().get(split[split.length - 1]).toString();
//                    } catch (Exception e) {
//                        year = ((LambdaQueryWrapper) (((HashMap) boundSql.getParameterObject()).get("ew"))).getParamNameValuePairs().get(split[split.length - 1]).toString();
//                    }
//                } else if (SqlCommandType.UPDATE.equals(cmdType)) {
//                    try {
//                        year = ((UpdateWrapper) (((HashMap) boundSql.getParameterObject()).get("ew"))).getParamNameValuePairs().get(split[split.length - 1]).toString();
//                    } catch (Exception e) {
//                        year = ((LambdaUpdateWrapper) (((HashMap) boundSql.getParameterObject()).get("ew"))).getParamNameValuePairs().get(split[split.length - 1]).toString();
//                    }
//                } else {
//                    try {
//                        year = ((QueryWrapper) (((HashMap) boundSql.getParameterObject()).get("ew"))).getParamNameValuePairs().get(split[split.length - 1]).toString();
//                    } catch (Exception e) {
//                        year = ((LambdaQueryWrapper) (((HashMap) boundSql.getParameterObject()).get("ew"))).getParamNameValuePairs().get(split[split.length - 1]).toString();
//                    }
//                }
            }


        } else {
            Object obj = !SqlCommandType.UPDATE.equals(cmdType) ? boundSql.getParameterObject() : ((HashMap) boundSql.getParameterObject()).get("et");
            PropertyDescriptor pd = new PropertyDescriptor(yearSplit.entityFiledName(), yearSplit.clazz());
            Method getMethod = pd.getReadMethod();
            year = getMethod.invoke(obj, null).toString();
        }

        String newTableName = (yearSplit.orginTableName() + "_" + year).replace(yearSplit.prefixTag(), "");

        sql = sql.replace(yearSplit.orginTableName(), newTableName);

        return sql;
    }
}
