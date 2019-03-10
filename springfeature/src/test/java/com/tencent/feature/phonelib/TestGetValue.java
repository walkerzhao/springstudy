package com.tencent.feature.phonelib;

/**
 * Created by andy on 2019/3/2.
 */
public class TestGetValue {

    public static Long getValue(Comparable<?> value){
        Long val = 0L;
        if(value instanceof Integer){
            val = new Long((Integer)value);
        }else if(value instanceof Long){
            val = (Long) value;
        }else{
            val = new Long(value.hashCode() & 0x7fffffff);
        }
        return val;
    }

    public static void main(String[] args) {
        String value = "oyoXQv5SNoDpmjuZIa7jPFLo5YNo";
        System.out.println(getValue(value));
    }

}
