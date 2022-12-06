package main.java.util;

public interface CachePolicy {
    String evict();
    void touch(String key, String... value);
}
