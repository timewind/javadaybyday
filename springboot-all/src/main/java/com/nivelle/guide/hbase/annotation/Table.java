package com.nivelle.guide.hbase.annotation;


import com.nivelle.guide.hbase.generator.DefaultRowKeyGenerator;
import com.nivelle.guide.hbase.generator.RowKeyGenerator;

import java.lang.annotation.*;

/**
 * @author pc
 *表名注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {

	/**
	 * 表名
	 */
	String tableName();
	/**
	 * 列簇名
	 */
	String columnFamilyName();

	/**
	 * rowKey生成器
	 * @return
	 */
	Class<? extends RowKeyGenerator> generator() default DefaultRowKeyGenerator.class;
	
}
