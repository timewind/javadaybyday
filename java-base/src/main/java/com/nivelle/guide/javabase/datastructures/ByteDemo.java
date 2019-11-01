package com.nivelle.guide.javabase.datastructures;

import java.math.BigInteger;

/**
 * 位操作
 *
 * @author fuxinzhong
 * @date 2019/10/31
 */
public class ByteDemo {

    /**
     * 1. &表示按位与,只有两个位同时为1,才能得到1, 0x代表16进制数,0xff表示的数二进制1111 1111 占一个字节.和其进行&操作的数,最低8位,不会发生变化.
     * <p>
     * <p>
     * 2. Java中使用补码来表示负数，具体就是除符号位之外，剩余位取反加1，符号位不变还是1（符号位0-正数，1-负数）
     */
    public static void main(String[] args) {

        Integer intToByte = 127;
        System.out.println(Integer.toBinaryString(intToByte));

        Integer negativeIntToByte = -128;
        System.out.println(Integer.toBinaryString(negativeIntToByte));

        /**
         *  最大最小值
         */
        System.out.println("max value:" + Byte.MAX_VALUE);
        System.out.println("min value:" + Byte.MIN_VALUE);

        byte byteValue = 11;
        Byte byteToString = new Byte(byteValue);
        System.out.println(byteToString.toString());
        String stringValue = "11";
        System.out.println(Byte.valueOf(stringValue));

        System.out.println();

        /**
         * 与运算,两位全为1才是1(0就是false,1就是true)
         *
         * 特殊用法:
         *
         * 1.清零。如果想要将一个单元清零,即使全部二进制为0,只要与一个各位都为零的数值相与,结果为零
         * 2.取一个数中指定位。
         */

        System.out.println("0&0 is " + (0 & 0));
        System.out.println("0&1 is " + (0 & 1));
        System.out.println("1&0 is " + (1 & 0));
        System.out.println("1&1 is " + (1 & 1));

    }

    /**
     * 将byte[]转为各种进制的字符串
     *
     * @param bytes byte[]
     * @param radix 基数可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
     * @return 转换后的字符串
     */
    public static String binary(byte[] bytes, int radix) {
        //这里的1代表正数
        return new BigInteger(1, bytes).toString(radix);
    }
}
