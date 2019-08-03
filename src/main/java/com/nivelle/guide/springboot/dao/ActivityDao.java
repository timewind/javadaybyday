package com.nivelle.guide.springboot.dao;

import com.nivelle.guide.springboot.entity.ActivityPvEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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


    private static final String SELECT_SQL = "select * from activity_pv where id=?";

    private static final String SELECTS_SQL = "select * from activity_pv where position_type=? and device_type=?";

    /**
     *             Long id = rs.getLong("id");
     *             String activityId = rs.getString("activity_id");
     *             int positionType = rs.getInt("position_type");
     *             String ip = rs.getString("ip");
     *             String deviceType = rs.getString("device_type");
     *             String deviceNo = rs.getString("device_no");
     *             String createTime = rs.getString("create_time");
     *             String updateTime = rs.getString("update_time");
     *             activityPvEntity.setId(id);
     *             activityPvEntity.setActivityId(activityId);
     *             activityPvEntity.setPositionType(positionType);
     *             activityPvEntity.setIp(ip);
     *             activityPvEntity.setDeviceNo(deviceNo);
     *             activityPvEntity.setCreateTime(createTime);
     *             activityPvEntity.setUpdateTime(updateTime);
     */

    /**
     * queryForObject
     *
     * @return
     */
    public ActivityPvEntity getActivitiesById() {
        try {
            Object params[] = new Object[]{6};
            /**
             * RowMapper<T
             */
            ActivityPvEntity activityPvEntity = jdbcTemplate.queryForObject(SELECT_SQL, params, new BeanPropertyRowMapper<>(ActivityPvEntity.class));
            return activityPvEntity;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * queryForList 原型
     *
     * @return
     */
    public List<Map<String, Object>> getActivityList() {
        try {
            Object params[] = new Object[]{3, 2};
            List<Map<String, Object>> activityPvEntities = jdbcTemplate.queryForList(SELECTS_SQL, params);
            return activityPvEntities;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * 对象映射
     *
     * @return
     */
    public List<ActivityPvEntity> getActivityList2() {
        try {
            Object params[] = new Object[]{3, 2};
            List<ActivityPvEntity> activityPvEntities = jdbcTemplate.query(SELECTS_SQL, params, new BeanPropertyRowMapper<>(ActivityPvEntity.class));
            return activityPvEntities;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * 自定义映射
     *
     * @return
     */
    public List<ActivityPvEntity> getActivityList3() {
        try {
            Object params[] = new Object[]{3, 2};
            List<ActivityPvEntity> activityPvEntities = jdbcTemplate.query(SELECTS_SQL, params, (resultSet, row) -> {

                Long id = resultSet.getLong("id");
                String activityId = resultSet.getString("activity_id");
                int positionType = resultSet.getInt("position_type");
                String ip = resultSet.getString("ip");
                String deviceType = resultSet.getString("device_type");
                String deviceNo = resultSet.getString("device_no");
                String createTime = resultSet.getString("create_time");
                String updateTime = resultSet.getString("update_time");
                ActivityPvEntity activityPvEntity = new ActivityPvEntity();
                activityPvEntity.setId(id.intValue());
                activityPvEntity.setDeviceType(deviceType);
                activityPvEntity.setActivityId(activityId);
                activityPvEntity.setPositionType(positionType);
                activityPvEntity.setIp(ip);
                activityPvEntity.setDeviceNo(deviceNo);
                activityPvEntity.setCreateTime(createTime);
                activityPvEntity.setUpdateTime(updateTime);
                return activityPvEntity;
            });
            return activityPvEntities;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


}
