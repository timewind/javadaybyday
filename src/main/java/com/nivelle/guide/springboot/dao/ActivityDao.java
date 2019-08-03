package com.nivelle.guide.springboot.dao;

import com.nivelle.guide.springboot.entity.ActivityPvEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * JdbcTemplate
 *
 * @author fuxinzhong
 * @date 2019/08/03
 */
@Repository
public class ActivityDao {


    @Resource
    private JdbcTemplate jdbcTemplate;


    public List<ActivityPvEntity> getActivitiesById(){




        return null;


    }
}
