package org.clb.mybatisTest.annotions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 年度分表拦截器
 * @author rl
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface YearSplit {

    /**
     * 是否启用
     * @return
     */
    boolean flag() default true;

    /**
     * 数据库字段名
     * @return
     */
    String tableFiledName();

    /**
     * 数据库表名
     * @return
     */
    String orginTableName();

    /**
     * 防混淆前缀
     * @return
     */
    String prefixTag() default "tag_splitYear_";

    /**
     * 实体类
     * @return
     */
    Class<?> clazz();

    /**
     * 实体字段名
     * @return
     */
    String entityFiledName();
}
