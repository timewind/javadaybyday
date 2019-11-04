package com.nivelle.guide.hbase.annotation;


import com.nivelle.guide.hbase.serialization.HbaseSerializer;
import com.nivelle.guide.hbase.serialization.StringHbaseSerializer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * hbase 列名
 */
@Target({ElementType.FIELD})  
@Retention(RetentionPolicy.RUNTIME)  
public @interface Column {
    /**
     * Column name
     * @return
     */
	String columnName();

	Class<? extends HbaseSerializer> serializer() default StringHbaseSerializer.class;
}
