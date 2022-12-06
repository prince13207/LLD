package main.java.domain;

import java.util.HashMap;

public class Storage {
    HashMap<String,String> data;
    int maxCapacity;

    public Storage(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.data = new HashMap<>();
    }

    public String get(String key)
    {
        return data.get(key);
    }

    public void add(String key, String value){
        data.put(key,value);
    }

    public void remove(String key)
    {
        data.remove(key);
    }
    public boolean isCapacityBreached(){
        return data.size()>maxCapacity;
    }

}
