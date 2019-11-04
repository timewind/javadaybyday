package com.nivelle.guide.hbase.generator;


import com.nivelle.guide.hbase.util.MD5Util;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;

@Component
public class DefaultRowKeyGenerator implements RowKeyGenerator<Map> {
    public DefaultRowKeyGenerator() {
    }

    public String generateRowKey(Map rowKey) {
        Random random = new Random();
        int regionIndex = random.nextInt(10);
        return MD5Util.md5(regionIndex + rowKey.toString());
    }
}
