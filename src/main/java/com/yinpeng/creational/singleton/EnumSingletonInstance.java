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
 * 枚举实现: Java中的枚举类型本身就天然单例的,唯一遗憾的是，这个方案和饿汉式一样，没法延迟加载。枚举类加载自然就会初始化INSTANCE。
 */
public enum EnumSingletonInstance {

    INSTANCE;

    public static EnumSingletonInstance getInstance() {
        return INSTANCE;
    }
}
