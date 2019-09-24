package com.nivelle.guide.core;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * TODO:DOCUMENT ME!
 *
 * @author fuxinzhong
 * @date 2019/09/24
 */
public class MyImportSelector implements ImportSelector {


    public String[] selectImports(AnnotationMetadata importingClassMetadata){
        //要注入类的全限定名
       return new String[]{"com.nivelle.guide.model.Cat"};
    }
}
