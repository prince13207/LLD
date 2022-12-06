package main.java;

import main.java.domain.Storage;
import main.java.impl.SimpleCacheImpl;
import main.java.util.LRUCachePolicy;

public class Main {
    public static void main(String[] args) {
        Cache lruCache = new SimpleCacheImpl(new Storage(5),new LRUCachePolicy());

        lruCache.put("4","10");
        System.out.println(lruCache.get("4"));
        lruCache.put("5","13");
        System.out.println(lruCache.get("5"));

        lruCache.put("4","12");
        System.out.println(lruCache.get("4"));

        lruCache.put("9","17");
        lruCache.put("10","17");
        lruCache.put("11","17");
        lruCache.put("12","17");

        System.out.println(lruCache.get("5"));


    }
}
