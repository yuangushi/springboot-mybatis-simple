package com.ylp.test.genericType;

import java.util.Iterator;
import java.util.List;

public class Test {

    public <T> void show(T t){
        System.out.println(t);
    }

    public <T> void print(T t){
        System.out.println(t);
    }

    public static <T> T getString(String key,Class<T> clazz,T defaults){
        T ret=null;
        if(defaults instanceof Integer){
            ret=clazz.cast(Integer.valueOf(key));
        }
        return ret;
    }

    public static void sop (List<?> a){
        for(Iterator<?> it = a.iterator();it.hasNext();){
            System.out.println(it.next());
        }
    }

    public static <T> void ss(List<T> a){
        for(Iterator<T> it=a.iterator();it.hasNext();){
            System.out.println(it.next());
        }
    }

    public <U,T> void  sum(U u,T t){
        System.out.println(u+"--"+t);
    }

    public static void main(String[] args) {
        Integer aret=getString("123",Integer.class,1);
        System.out.println(aret);
    }
}
