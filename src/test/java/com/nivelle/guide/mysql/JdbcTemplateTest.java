package com.nivelle.guide.mysql;

import com.nivelle.guide.springboot.dao.ActivityDao;
import com.nivelle.guide.springboot.entity.ActivityPvEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO:DOCUMENT ME!
 *
 * @author fuxinzhong
 * @date 2019/08/03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTemplateTest {


    @Autowired
    ActivityDao activityDao;

    @Test
    public void testForUpdate() {
        ActivityPvEntity activityPvEntity = activityDao.getActivitiesForUpdate();
        System.out.println(activityPvEntity);
        int changeCount = activityDao.updateActivityPv(activityPvEntity);
        System.out.println("更新结果:" + changeCount);
    }
}
