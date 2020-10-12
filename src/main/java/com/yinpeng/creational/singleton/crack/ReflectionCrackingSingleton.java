/*
 * Copyright(C) 2019 FUYUN DATA SERVICES CO.,LTD. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * 该源代码版权归属福韵数据服务有限公司所有
 * 未经授权，任何人不得复制、泄露、转载、使用，否则将视为侵权
 */
package com.yinpeng.creational.singleton.crack;

import com.yinpeng.creational.singleton.HungrySingleton;

import java.lang.reflect.Constructor;

/**
 * Created By YinP
 * 2020/10/12
 *
 * 破解单例 - 反射
 * {@link "https://mp.weixin.qq.com/s/y7InHpFQiauTjlNwZEbKAA"}
 */
public class ReflectionCrackingSingleton {

    public static void main(String[] args) throws Exception {
        System.out.println(HungrySingleton.getInstance());
        System.out.println(HungrySingleton.getInstance());

        System.out.println("反射破解单例...");
        HungrySingleton instance1 = reflectSingleton(HungrySingleton.class);
        HungrySingleton instance2 = reflectSingleton(HungrySingleton.class);
        System.out.println(instance1);
        System.out.println(instance2);
    }

    private static <T> T reflectSingleton(Class<T> clazz) throws NoSuchMethodException, InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException {
        Constructor<T> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }
}
