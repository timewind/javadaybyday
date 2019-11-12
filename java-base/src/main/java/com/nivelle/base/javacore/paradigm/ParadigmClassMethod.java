package com.nivelle.base.javacore.paradigm;

/**
 * 范型类&范型方法
 *
 * @author fuxinzhong
 * @date 2019/11/12
 */
public class ParadigmClassMethod<T> {

    /**
     * 范型方法1
     *
     * <T>:表明是范型方法
     * <p>
     * T:表示是返回值
     *
     * @param <T>
     * @return
     */
    public <T> T getParam1(Integer params) {
        T result = (T) params;
        return result;
    }

    /**
     * 范型方法1变异
     *
     * <T>:表明是范型方法
     * <p>
     * T:表示是返回值
     *
     * @param <T>
     * @return
     */
    public <T> T getParam1Sub(T params) {
        T result = params;
        return result;
    }


    /**
     * 范型方法2
     *
     * @param <T>
     * @return
     */
    public <T> void getParam2(T params) {
        T result = params;
        System.out.println(result);
        return;
    }

    /**
     * 范型方法3
     *
     * @param <T>
     * @return
     */
    public <T> void getParam3(Integer params) {
        T result = (T) params;
        System.out.println(result);
        return;
    }


    /**
     * 非范型方法：只是一个使用了范型类的方法
     *
     * @param
     * @return
     */
    public void getParam4(T params) {
        T result = params;
        System.out.println(result);
        return;
    }


}
