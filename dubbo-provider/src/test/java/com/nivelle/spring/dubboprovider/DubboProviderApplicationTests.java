package com.nivelle.spring.dubboprovider;

import com.nivelle.dubbo.spi.MySpi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ServiceLoader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboProviderApplicationTests {

    @Test
    public void contextLoads() {

        //JDK SPI机制
        ServiceLoader<MySpi> serviceLoader = ServiceLoader.load(MySpi.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(MySpi::sayHello);
    }

}
