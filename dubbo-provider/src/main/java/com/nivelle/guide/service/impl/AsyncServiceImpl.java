package com.nivelle.guide.service.impl;

import com.nivelle.guide.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * 异步方法执行
 *
 * @author fuxinzhong
 * @date 2019/08/23
 */
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {

    @Async("littleExecutor")
    public Future<String> asyncSayHello() {
        try {
            Thread.sleep(10);
            System.err.println("asyncSayHello1 is done ");
            return new AsyncResult<>("asyncSayHello1 is done");
        } catch (Exception e) {
        }
        return new AsyncResult<>("default");
    }

    public Future<String> asyncSayHello2() {
        try {
            Thread.sleep(5000);
            System.err.println("asyncSayHello2 is done ");
            return new AsyncResult<>("asyncSayHello2 is done");
        } catch (Exception e) {
        }
        return new AsyncResult<>("default");
    }

}
