package com.nivelle.spring.hbase;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class MyHBaseDao {

    private final static String TABLE = "test";

    private static final String DEFAULT_FAMILY = "f1";

    private static final String SPLIT_CHAR = "-";

    @Autowired
    private MyHBasePoolTemplate myHBasePoolTemplate;


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

    private static String getRowKey(String usr) {
        return new StringBuffer(usr).reverse().append(SPLIT_CHAR).append(System.currentTimeMillis()).toString();
    }
}
