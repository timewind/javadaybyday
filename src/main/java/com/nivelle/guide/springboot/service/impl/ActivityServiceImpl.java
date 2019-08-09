package com.nivelle.guide.springboot.service.impl;

import com.nivelle.guide.springboot.core.AopAnnotation;
import com.nivelle.guide.springboot.dao.ActivityDaoImpl;
import com.nivelle.guide.springboot.entity.ActivityPvEntity;
import com.nivelle.guide.springboot.mapper.ActivityPvMapper;
import com.nivelle.guide.springboot.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * mybatis && jdbcTemplate
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    private static final Logger logger = LoggerFactory.getLogger(ActivityServiceImpl.class);


    @Autowired
    private ActivityPvMapper activityPvMapper;
    @Autowired
    private ActivityDaoImpl activityDaoImpl;

    @Override
    @AopAnnotation
    public List<ActivityPvEntity> getAll() {
        List<ActivityPvEntity> ativities = activityPvMapper.getAll();
        return ativities;

    }

    @Override
    public int insert(ActivityPvEntity activityPvEntity) {

        return activityPvMapper.insert(activityPvEntity);
    }

    @Override
    public int update(ActivityPvEntity activityPvEntity) {
        return 0;
    }

    @Override
    //@Cacheable(value = "activityPvEntity",key="#id")
    public ActivityPvEntity getActivityById(Integer id) {

        ActivityPvEntity activityPvEntity = activityPvMapper.getActivityById(id);

        logger.info("查询数据库返回为:{}", activityPvEntity);

        return activityPvEntity;
    }

    /**
     * 1.只有 public 方法打上 @Transactional 注解, 事务控制才能生效.
     * 2.注意自调用问题, @Transactional 注解仅在外部类的调用才生效, 原因是使用 Spring AOP 机制造成的. 所以: 主调函数如果是本Service类, 应该也要打上 @Transactional, 否则事务控制被忽略.
     * 3.缺省的情况下, 只有 RuntimeException 类异常才会触发回滚. 如果在事务中抛出其他异常,并期望回滚事务, 必须设定 rollbackFor 参数.
     * 4.如果主调函数和多个被调函数都加了 @Transactional 注解, 则整个主调函数将是一个统一的事务控制范围, 甚至它们分属多个Service也能被统一事务控制着
     * 5.通常我们应该使用 Propagation.REQUIRED, 但需要说明的是, 如果一个非事务方法顺序调用了"两个不同service bean"的事务函数, 它们并不在同一个事务上下文中, 而是分属于不同的事务上下文.
     */

    /**
     * 1. public限制和自调用问题都是因为使用Spring AOP代理造成的，如果要解决需要使用AspectJ取代Spring AOP代理
     * 2. Transactional 也可以放在类上,此时它的所有方法和子类都能识别
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false,
            isolation= Isolation.READ_COMMITTED,timeout=100,rollbackFor = Exception.class)
    public int insertOrUpdate(long id) {
        ActivityPvEntity activityPvEntity = activityDaoImpl.getActivitiesForUpdate(id);
        if(Objects.nonNull(activityPvEntity)) {
            activityPvEntity.setActivityId("渣哥");
            return activityDaoImpl.updateActivityPv(activityPvEntity);
        }
        return 0;
    }


}
