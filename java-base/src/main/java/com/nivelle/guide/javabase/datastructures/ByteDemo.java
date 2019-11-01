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
         * 1.清零:如果想要将一个单元清零,即使全部二进制为0,只要与一个各位都为零的数值相与,结果为零
         * 2.取一个数中指定位:与1进行与运算
         */

        System.out.println("0&0 is: " + (0 & 0));
        System.out.println("0&1 is: " + (0 & 1));
        System.out.println("1&0 is: " + (1 & 0));
        System.out.println("1&1 is: " + (1 & 1));

        /**
         * 二进制的表示: 0b开头+(0或1表示的二进制)
         */
        int getLow4Byte = (0b10101110 & 0b00001111);
        System.out.println("低四位整数:" + getLow4Byte);
        System.out.println("取低四位二进制表示:" + Integer.toBinaryString(getLow4Byte));

        System.out.println();


        /**
         * 或运算,只要有一个1结果就是1(1代表true)
         *
         * 特殊用法:
         *
         */
        System.out.println("0｜0 is: " + (0 | 0));
        System.out.println("0｜1 is: " + (0 | 1));
        System.out.println("1｜0 is: " + (1 | 0));
        System.out.println("1｜1 is: " + (1 | 1));

        /**
         * 1.对一个数据的某位置1
         */
        int set4LowByte = 0b10101110;
        int show4LowByte = (set4LowByte | 0b00001111);
        System.out.println("置低四位全为1:" + show4LowByte);
        System.out.println(Integer.toBinaryString(show4LowByte));


        /**
         * 异或运算（两个相应位为"异",则该位结果为1,否则为0）
         *
         * 特殊用法:
         *
         * 1. 使特定位翻转: 找一个数,对应原来要翻转的各位,该数对应的位为1,其余各位为0,此数与原来要数异或即可。
         *
         * 2. 保留原值:0与原值进行异或,保留原值
         *
         */
        System.out.println("0^0 is: " + (0 ^ 0));
        System.out.println("0^1 is: " + (0 ^ 1));
        System.out.println("1^0 is: " + (1 ^ 0));
        System.out.println("1^1 is: " + (1 ^ 1));

        /**
         * 使特定位翻转: 找一个数,对应原来要翻转的各位,该数对应的位为1,其余各位为0,此数与原来要数异或即可。
         */
        int flipByte = 0b10101110;
        int showFlipByte = (flipByte ^ 0b00001111);
        System.out.println("指定位翻转:" + Integer.toBinaryString(showFlipByte));

        int holdByte = 0b10101110;
        int showHoldByte = (holdByte ^ 0b00000000);
        System.out.println("指定位保留原值:" + Integer.toBinaryString(showHoldByte));


        /**
         *  左移 <<
         *
         *  将一个运算对象的各二进制位全部左移若干位(左边的二进制位丢弃,右边补0),
         *  若左移舍弃的高位不包含1,则左移一位相当于乘以2
         */
        System.out.println("左移1位:" + (2 << 1));


        int negativeNum = -11;
        System.out.println("-11的二进制位:" + Integer.toBinaryString(negativeNum));

        int leftNegativeNum = -11 << 300;
        System.out.println("-11的二进制位左移一位:" + Integer.toBinaryString(leftNegativeNum));

        System.out.println(leftNegativeNum / negativeIntToByte);


    }

}
