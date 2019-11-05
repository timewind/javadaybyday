package com.nivelle.spring.hbase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO:DOCUMENT ME!
 *
 * @author fuxinzhong
 * @date 2019/11/05
 */
@Controller
@RequestMapping("test/hbase")
@Validated
@Slf4j
public class HBaseController {

    @Autowired
    MyHBaseDao myHBaseDao;

    @RequestMapping("/put")
    @ResponseBody
    public Object put() {
        myHBaseDao.putData("Nivelle");
        return true;
    }
}
