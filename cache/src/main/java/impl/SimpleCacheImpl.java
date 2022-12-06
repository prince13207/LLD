package main.java.impl;

import main.java.Cache;
import main.java.domain.Storage;
import main.java.util.CachePolicy;

public class SimpleCacheImpl implements Cache {
    Storage data;
    CachePolicy policy;

    public SimpleCacheImpl(Storage data, CachePolicy policy) {
        this.data = data;
        this.policy = policy;
    }

    @Override
    public String get(String key) {
        policy.touch(key);
        return data.get(key);
    }

    @Override
    public void put(String key, String value) {
        data.add(key, value);
        policy.touch(key,value);
        if(data.isCapacityBreached())
        {
            String removedKey = policy.evict();
            data.remove(removedKey);
        }
    }


}
