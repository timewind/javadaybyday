package com.nivelle.spring.hbase;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Slf4j
public class MyHBaseDao {

    private final static String TABLE = "test";

    private static final String DEFAULT_FAMILY = "f1";

    private static final String SPLIT_CHAR = "-";

    private static final Integer DEFAULT_MAX_NUM = 100;

    @Autowired
    private MyHBasePoolTemplate myHBasePoolTemplate;

    /**
     * 添加数据
     *
     * @param rowKey
     * @return
     */
    public boolean putData(String rowKey) {
        boolean flag;
        long startTime = System.currentTimeMillis();
        try {
            flag = myHBasePoolTemplate.execute(TABLE, (HTableInterface tableInterface) -> {
                Put put = new Put(Bytes.toBytes(getRowKey(rowKey)));
                put.addColumn(Bytes.toBytes(DEFAULT_FAMILY), Bytes.toBytes("sex"),
                        Bytes.toBytes("boy"));
                tableInterface.put(put);
                return true;
            });
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("putData cost time:" + (endTime - startTime));

        }
        return flag;
    }

    /**
     * scan 查询数据
     *
     * @param userName
     * @return
     */
    public List<Map<String, String>> scanData(String userName) {

        Scan scan = new Scan();
        String startKey = new StringBuffer(userName).reverse().toString();
        String stopKey = "|";
        scan.setStartRow(startKey.getBytes());
        scan.setStopRow(stopKey.getBytes());
        scan.addFamily(DEFAULT_FAMILY.getBytes());
        try {
            return myHBasePoolTemplate.find(TABLE, scan, (ResultScanner resultScanner) -> {
                List<Map<String, String>> list = new ArrayList<>();
                Result[] res = resultScanner.next(DEFAULT_MAX_NUM);
                List<Result> results = Arrays.asList(res);
                results.forEach(result -> {
                    Map<String, String> dataMap = new LinkedHashMap<>();
                    dataMap.put("RowKey", Bytes.toString(result.getRow()));
                    result.listCells().forEach(keyValue -> {
                        //列族
                        String family = Bytes.toString(keyValue.getFamilyArray());
                        //列
                        String qualifier = Bytes.toString(keyValue.getQualifierArray());
                        String value = Bytes.toString(keyValue.getValueArray());
                        dataMap.put(getGetKey(family, qualifier), value);
                        list.add(dataMap);
                    });
                });
                return list;
            });
        } catch (Exception e) {
            System.out.println("Hbase scan error!" + e);
        }
        return null;
    }

    /**
     * 列展示 列族:列
     * @param family
     * @param qualifier
     * @return
     */
    private String getGetKey(String family, String qualifier) {
        return family + ":" + qualifier;
    }

    private static String getRowKey(String usr) {
        return new StringBuffer(usr).reverse().append(SPLIT_CHAR).append(System.currentTimeMillis()).toString();
    }
}
