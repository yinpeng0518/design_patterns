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
 * 静态内部类实现: 根据类加载机制，外部类的初始化并不会导致静态内部类的初始化。
 * {@link "https://mp.weixin.qq.com/s/y7InHpFQiauTjlNwZEbKAA"}
 */
public class StaticInnerSingleton {

    private StaticInnerSingleton() {
    }

    private static class StaticInnerSingletonInstance {
        private static final StaticInnerSingleton instance = new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance() {
        return StaticInnerSingletonInstance.instance;
    }
}
