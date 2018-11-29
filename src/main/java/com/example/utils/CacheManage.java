package com.example.utils;


// 缓存接口
public interface CacheManage {
    // 新增
    <V> void set(String key, V value);

    // 新增
    // timeSpan 单位：毫秒
    <V> void set(String key, V value, Long timeSpan);

    // 获取
    <V> V get(String key);

    // 移除
    void remove(String key);

    // 判断是否存在
    boolean exist(String key);

    // 续期
    boolean expire(String key,Long timeSpan);
}
