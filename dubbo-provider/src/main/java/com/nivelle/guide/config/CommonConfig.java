package com.nivelle.guide.config;

import com.nivelle.guide.annotation.ImportBeanAnnotation;
import com.nivelle.guide.service.ConcreteService;
import org.springframework.context.annotation.Configuration;

/**
 * 公用配置，@Configuration 会在启动时被扫描到
 *
 * @author fuxinzhong
 * @date 2019/08/25
 */
@Configuration
@ImportBeanAnnotation(targets = {ConcreteService.class})
public class CommonConfig {
}
