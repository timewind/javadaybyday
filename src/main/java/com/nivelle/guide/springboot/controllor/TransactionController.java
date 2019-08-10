package com.nivelle.guide.springboot.controllor;

import com.nivelle.guide.springboot.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 事物测试
 *
 * @author fuxinzhong
 * @date 2019/08/09
 */
@Controller
@RequestMapping("test/transaction")
@Validated
public class TransactionController {

    @Autowired
    ActivityService activityService;

    @RequestMapping("/requiredCommit/{id}")
    @ResponseBody
    public Object forUpdate(@PathVariable String id) {
        int result = activityService.requiredCommited(Long.valueOf(id));
        return result;
    }

}
