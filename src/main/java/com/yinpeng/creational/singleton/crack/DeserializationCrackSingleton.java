/*
 * Copyright(C) 2019 FUYUN DATA SERVICES CO.,LTD. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * 该源代码版权归属福韵数据服务有限公司所有
 * 未经授权，任何人不得复制、泄露、转载、使用，否则将视为侵权
 */
package com.yinpeng.creational.singleton.crack;

import com.yinpeng.creational.singleton.HungrySingleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created By YinP
 * 2020/10/12
 *
 * 破解单例 - 反序列化（前提是单例类实现了Serializable接口）
 * {@link "https://mp.weixin.qq.com/s/y7InHpFQiauTjlNwZEbKAA"}
 */
public class DeserializationCrackSingleton {

    public static void main(String[] args) throws Exception {
        System.out.println(HungrySingleton.getInstance());
        System.out.println(HungrySingleton.getInstance());
        System.out.println("反序列化破解单例...");

        HungrySingleton instance1 = HungrySingleton.getInstance();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(instance1);    //序列化

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        HungrySingleton instance2 = (HungrySingleton) ois.readObject();    //反序列化

        System.out.println(instance1);
        System.out.println(instance2);
    }
}
