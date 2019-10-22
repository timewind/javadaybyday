package com.nivelle.guide.springboot.service;

import com.nivelle.guide.springboot.entity.ActivityPvEntity;

import java.util.List;

public interface ActivityService {


    List<ActivityPvEntity> getAll();

    int insert(ActivityPvEntity activityPvEntity);

    int update(ActivityPvEntity activityPvEntity);

    ActivityPvEntity getActivityById(Integer id);

    int requiredCommitted(long id);

    ActivityPvEntity getActivityInTransactional(long id);

}
