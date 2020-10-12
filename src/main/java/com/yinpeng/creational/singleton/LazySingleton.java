/*
 * Copyright(C) 2019 FUYUN DATA SERVICES CO.,LTD. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * 该源代码版权归属福韵数据服务有限公司所有
 * 未经授权，任何人不得复制、泄露、转载、使用，否则将视为侵权
 */
package com.yinpeng.creational.singleton;

/**
 * Created By YinP
 * 2020/10/12
 *
 * 懒汉式: 双重校验
 * {@link "https://mp.weixin.qq.com/s/y7InHpFQiauTjlNwZEbKAA"}
 */
public class LazySingleton {

    private LazySingleton() {
    }

    //JDK必须是JDK5或更高版本，因为从JDK5才开始使用新的JSR-133内存模型规范，而在这个规范中才增强了volatile这个语义.
    private static volatile LazySingleton instance = null;

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null)
                    /*
                     * 1.申请内存空间
                     * 2.初始化默认值
                     * 3.执行构造器初始化
                     * 4.将instance指向创建的对象
                     */
                    instance = new LazySingleton();
            }
        }
        return instance;
    }
}
