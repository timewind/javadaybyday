package com.nivelle.spring.hbase.hbasebean;

import com.alibaba.fastjson.JSONObject;
import com.nivelle.spring.hbase.annotation.Column;
import com.nivelle.spring.hbase.annotation.RowKey;
import com.nivelle.spring.hbase.annotation.Table;
import com.nivelle.spring.hbase.generator.MD5RowKeyGenerator;
import com.nivelle.spring.hbase.serialization.JsonHbaseSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(tableName = "miaobt_credit:miaobt_credit_mobile", columnFamilyName = "info", generator = MD5RowKeyGenerator.class)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileDataModel extends HbaseModel {

    @RowKey
    private String phone;

    @Column(columnName = "report", serializer = JsonHbaseSerializer.class)
    private JSONObject report;

    @Column(columnName = "raw", serializer = JsonHbaseSerializer.class)
    private JSONObject raw;
}
