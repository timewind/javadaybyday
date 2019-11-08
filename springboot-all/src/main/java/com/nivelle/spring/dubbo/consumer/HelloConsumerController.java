package com.nivelle.spring.dubbo.consumer;


import com.alibaba.dubbo.config.annotation.Reference;
import com.nivelle.base.commonservice.HelloDubboService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * dubbo demo
 *
 * @author fuxinzhong
 * @date 2019/08/16
 */
@Controller
@RequestMapping("/dubbo")
public class HelloConsumerController {


    /**
     * 启动检查
     *
     * check(默认true): Dubbo 缺省会在启动时检查依赖的服务是否可用，不可用时会抛出异常，阻止 Spring 初始化完成，以便上线时，能及早发现问题，默认 check="true"。
     */

    /**
     * 集群容错模式
     *
     * org.apache.dubbo.rpc.cluster.support.FailoverCluster(默认): 失败自动切换，当出现失败，重试其它服务器 [1]。通常用于读操作，但重试会带来更长延迟。可通过 retries="2" 来设置重试次数(不含第一次)
     * org.apache.dubbo.rpc.cluster.support.FailfastCluster:快速失败，只发起一次调用，失败立即报错。通常用于非幂等性的写操作，比如新增记录。
     * org.apache.dubbo.rpc.cluster.support.FailsafeCluster:失败安全，出现异常时，直接忽略。通常用于写入审计日志等操作。
     * org.apache.dubbo.rpc.cluster.support.FailbackCluster:失败自动恢复，后台记录失败请求，定时重发。通常用于消息通知操作。
     * org.apache.dubbo.rpc.cluster.support.ForkingCluster:并行调用多个服务器，只要一个成功即返回。通常用于实时性要求较高的读操作，但需要浪费更多服务资源。可通过 forks="2" 来设置最大并行数。
     * org.apache.dubbo.rpc.cluster.support.AvailableCluster:广播调用所有提供者，逐个调用，任意一台报错则报错 [2]。通常用于通知所有提供者更新缓存或日志等本地资源信息。
     */

    /**
     * 负载均衡
     *
     * org.apache.dubbo.rpc.cluster.loadbalance.RandomLoadBalance(默认):随机，按权重设置随机概率;在一个截面上碰撞的概率高，但调用量越大分布越均匀，而且按概率使用权重后也比较均匀，有利于动态调整提供者权重
     * org.apache.dubbo.rpc.cluster.loadbalance.RoundRobinLoadBalance:轮询，按公约后的权重设置轮询比率。存在慢的提供者累积请求的问题，比如：第二台机器很慢，但没挂，当请求调到第二台时就卡在那，久而久之，所有请求都卡在调到第二台上
     * org.apache.dubbo.rpc.cluster.loadbalance.LeastActiveLoadBalance:最少活跃调用数，相同活跃数的随机，活跃数指调用前后计数差。使慢的提供者收到更少请求，因为越慢的提供者的调用前后计数差会越大。
     * org.apache.dubbo.rpc.cluster.loadbalance.ConsistentHashLoadBalance:一致性 Hash，相同参数的请求总是发到同一提供者。
     *
     *
     * */

    @Reference(version = "${helloDubbo.service.version}", check = false, cluster = "failover", retries = 2,loadbalance = "loadbalance")
    private HelloDubboService helloDubboService;


    @RequestMapping("/sayHello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return helloDubboService.sayHello(name);
    }


}
