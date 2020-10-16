/*
 * Copyright(C) 2019 FUYUN DATA SERVICES CO.,LTD. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * 该源代码版权归属福韵数据服务有限公司所有
 * 未经授权，任何人不得复制、泄露、转载、使用，否则将视为侵权
 */
package com.yinpeng.creational.prototype;

import java.io.*;

/**
 * Created By YinP
 * 2020/10/16
 *
 * {@link "https://mp.weixin.qq.com/s/rdNh1LzJiWvinj9M3LY6kg"}
 * 序列化和反序列化实现深克隆
 */
public class DeepCloneBySerializable {

    public static class A implements Serializable {
        private int a;

        @Override
        public String toString() {
            return "A{" +
                    "a=" + a +
                    '}';
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }
    public static class B implements Serializable {
        @Override
        public String toString() {
            return "B{" +
                    "b=" + b +
                    ", a=" + a +
                    '}';
        }

        private Integer b;

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

        private A a;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A a = new A();
        a.setA(1);
        B b = new B();
        b.setA(a);
        b.setB(2);

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos)){
            oos.writeObject(b);
            ByteArrayInputStream in = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(in);
            B b2 = (B) ois.readObject();
            System.out.println("b2-->" + b2);
            System.out.println("b-->" + b);
            b2.setB(3);
            System.out.println("b2-->" + b2);
            System.out.println("b-->" + b);
            b2.getA().setA(10);
            System.out.println("b2-->" + b2);
            System.out.println("b-->" + b);
        }
    }
}
