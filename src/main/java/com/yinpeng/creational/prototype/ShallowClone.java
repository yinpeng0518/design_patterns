/*
 * Copyright(C) 2019 FUYUN DATA SERVICES CO.,LTD. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * 该源代码版权归属福韵数据服务有限公司所有
 * 未经授权，任何人不得复制、泄露、转载、使用，否则将视为侵权
 */
package com.yinpeng.creational.prototype;

/**
 * Created By YinP
 * 2020/10/13
 *
 * {@link "https://mp.weixin.qq.com/s/rdNh1LzJiWvinj9M3LY6kg"}
 *
 * 原型模式 - 浅克隆
 * 在浅克隆模式下，克隆生成对象的基本数据类型（包括对应包装类）属性和String拷贝的是值，后续修改克隆对象的该属性值，并不会影响原来的对象里的值。
 * 但如果是引用类型属性拷贝的是引用，拷贝得到的对象和原来的对象的属性指向同一个对象。所以，后续修改其属性值，就会影响原来的对象里的对应的属性值。
 */
public class ShallowClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A();
        a.setA(1);
        B b = new B();
        b.setA(a);
        b.setB(2);

        B b2 = (B) b.clone();
        System.out.println("b-->" + b);
        System.out.println("b2-->" + b2);
        b2.setB(3);
        System.out.println("b-->" + b);
        System.out.println("b2-->" + b2);
        b2.getA().setA(10);
        System.out.println("b-->" + b);
        System.out.println("b2-->" + b2);
    }


    public static class A {
        @Override
        public String toString() {
            return "A{" +
                    "a=" + a +
                    '}';
        }

        private int a;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }

    public static class B implements Cloneable {
        @Override
        public String toString() {
            return "B{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }

        private A a;
        private int b;

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public A getA() {
            return a;
        }

        public void setA(A a) {
            this.a = a;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
