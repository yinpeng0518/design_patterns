/*
 * Copyright(C) 2019 FUYUN DATA SERVICES CO.,LTD. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * 该源代码版权归属福韵数据服务有限公司所有
 * 未经授权，任何人不得复制、泄露、转载、使用，否则将视为侵权
 */
package com.yinpeng.creational.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created By YinP
 * 2020/10/12
 *
 * 饿汉式: 当类一初始化，该类的对象就立刻会被实例化。
 * {@link "https://mp.weixin.qq.com/s/y7InHpFQiauTjlNwZEbKAA"}
 */
public class HungrySingleton implements Serializable {

    private HungrySingleton() {
        //防止反射破坏单例
        if (instance != null) {
            throw new RuntimeException("只能创建一个对象！");
        }
    }

    private static HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return instance;
    }

    //防止反序列化破坏单例
    //readResolve()方法是在readObject()方法之后才被调用，因而它每次都会用我们自己生成的单实例替换从流中读取的对象。这样自然就保证了单例。
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }
}
