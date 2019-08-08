package com.nivelle.guide;

import com.nivelle.guide.configbean.LearnConfig;
import com.nivelle.guide.javacore.instance.Son;
import com.nivelle.guide.springboot.dao.ActivityDaoImpl;
import com.nivelle.guide.springboot.entity.ActivityPvEntity;
import com.nivelle.guide.springboot.mapper.ActivityPvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    LearnConfig learnConfig;
    @Autowired
    ActivityPvMapper activityPvMapper;

    @Autowired
    ActivityDaoImpl activityDao;

    @RequestMapping("/config")
    public String config() {

        String desc = learnConfig.getDesc();

        Son man = new Son(1,

                "nivelle", 100);

        System.out.println(desc);

        System.out.println(man.getScore() + man.getName() + man.getAge());

        return "hello world my name is " + desc;
    }

    @RequestMapping("/extends")
    @ResponseBody
    public String hello() {

        Son man = new Son(1, "nivelle", 100);
        System.out.println(man.getScore() + man.getName() + man.getAge());
        return "class extends name is:" + man.getName() + " " + "score is: " + man.getScore();
    }

    /**
     * 优雅停机
     *
     * @return
     */
    @RequestMapping("/graceFull")
    @ResponseBody
    public String graceFull() {

        try {
            System.out.println("等待过程中终止进程,但是依然等待当前任务执行完毕");
            Thread.sleep(30000);
        } catch (Exception e) {

        }
        System.out.println("优雅停机执行完毕");
        return "stop success";
    }


    /**
     * jdbcTemplate 实践
     *
     * @return
     */
    @RequestMapping("/activityPv")
    @ResponseBody
    public ActivityPvEntity getActivityPv() {
        ActivityPvEntity activityPvEntity = activityDao.getActivitiesById();
        System.out.println("activityPv is:" + activityPvEntity);
        return activityPvEntity;
    }

    /**
     * 原型返回
     *
     * @return
     */
    @RequestMapping("/activityPvs")
    @ResponseBody
    public Object getActivityPvs() {
        List<Map<String, Object>> activityList = activityDao.getActivityList();
        System.out.println("activityList is:" + activityList);
        return activityList;
    }

    /**
     * 自动映射
     *
     * @return
     */
    @RequestMapping("/activityPvs2")
    @ResponseBody
    public Object getActivityPvs2() {
        List<ActivityPvEntity> activityList = activityDao.getActivityList2();
        System.out.println("activityList is:" + activityList);
        return activityList;
    }

    /**
     * 自定义对象映射
     *
     * @return
     */
    @RequestMapping("/activityPvs3")
    @ResponseBody
    public Object getActivityPvs3() {
        List<ActivityPvEntity> activityList = activityDao.getActivityList3();
        System.out.println("activityList is:" + activityList);
        return activityList;
    }

    /**
     * 自定义对象映射
     *
     * @return
     */
    @RequestMapping("/updateActivity/{id}")
    @ResponseBody
    public Object changeActivityPv(@PathVariable String id) {
        ActivityPvEntity activityPvEntity = activityDao.getActivitiesForUpdate(Long.valueOf(id));
        System.out.println(activityPvEntity);
        int changeCount = activityDao.updateActivityPv(activityPvEntity);
        return changeCount;
    }

    /**
     * 自定义对象映射
     *
     * @return
     */
    @RequestMapping("/selectForUpdate/{id}")
    @ResponseBody
    public Object getActivityPvForUpdate(@PathVariable String id) {
        ActivityPvEntity activityPvEntity = activityDao.getActivitiesForUpdate(Long.valueOf(id));
        return activityPvEntity;
    }


}
