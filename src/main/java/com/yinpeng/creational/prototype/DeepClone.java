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
 * 2020/10/16
 *
 * {@link "https://mp.weixin.qq.com/s/rdNh1LzJiWvinj9M3LY6kg"}
 * 原型模式 - 深克隆
 */
public class DeepClone {

    public static class A implements Cloneable {
        private int a;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class B implements Cloneable {
        private Integer b;
        private A a;

        @Override
        public Object clone() throws CloneNotSupportedException {
            B b = (B) super.clone();
            A a = b.getA();
            b.setA((A) a.clone());
            return b;
        }

        public Integer getB() {
            return b;
        }

        public void setB(Integer b) {
            this.b = b;
        }

        public A getA() {
            return a;
        }

        public void setA(A a) {
            this.a = a;
        }
    }

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
}
