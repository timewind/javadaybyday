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

    @Override
    @Transactional
    public int insertOrUpdate(long id) {
        ActivityPvEntity activityPvEntity = activityDaoImpl.getActivitiesForUpdate(id);
        if(Objects.nonNull(activityPvEntity)) {
            activityPvEntity.setActivityId("渣哥");
            return activityDaoImpl.updateActivityPv(activityPvEntity);
        }
        return 0;
    }


}
