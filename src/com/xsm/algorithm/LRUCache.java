package com.xsm.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xsm
 * @date 2021/3/11
 * @Description
 * 146. LRU 缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache {

    private int capacity;

    // 通过LinkedHashMap实现 LRU
    private LRULinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LRULinkedHashMap<>(capacity);
    }

    public int get(Integer key) {
        return map.getOrDefault(key, -1);
    }

    public void put(Integer key, int value) {
        map.put(key, value);
    }
}

class LRULinkedHashMap<K,V> extends LinkedHashMap<K, V>{

    private int capacity;

    public LRULinkedHashMap(int capacity) {
        super(16,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest){
        return size()>capacity;
    }

}

