package com.ylp.test.functionInterface;

import com.ylp.test.entity.User;
import com.ylp.test.exception.MyException;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class MyTest {
    public static void main(String[] args) {

//        GreetInteger greetInteger=message -> System.out.println("消息"+message);
//        int[] nums={100,20,30,52,49,10};
//
//        List<Integer> b=Stream.of(30,40,50).filter(a->isLength(a)).collect(toList());
//        System.out.println(b);
//        Integer cc=Integer.compare(100,90);
//        System.out.println(cc);
//
//        shopping(5000,x-> System.out.println(x*10));

        User[] users={
                new User(null,"ylp",10),
                new User(1,"ylp",11),
                new User(1,"ylp",9)
        };
        Optional<Integer> op1=Optional.ofNullable(1);
        Optional<Integer> op2=Optional.ofNullable(null);
        Optional<Integer> op3=Optional.ofNullable(3);
        //如果op1为null,则返回1000,不为null的话返回本身
        boolean bop1 = op1.orElse(1000) == 1;
        Integer orElseGET1=op1.orElseGet(()->3);
        boolean bop3=op1.orElseGet(()->3)==3;
        //如果b2为null,则返回2000,否则返回本身
        boolean b2 = op2.orElse(2000) == 1;
        Integer orElseGet2=op2.orElseGet(()->2);

        System.out.println("第一个的结果"+bop1);
        System.out.println("op1的orElseGet结果是:"+orElseGET1);
        System.out.println("bop3的结果"+bop3);
        System.out.println(b2);
        System.out.println("op2的orElseGet结果是:"+orElseGet2);

        //这个的map里是一个Function对象,传一个user对象过去,判断user对象的userName是否为空,不为空的话就返回这个username,否则返回orElse的值
        String name=Optional.ofNullable(users[0]).map(u->u.getUserName()).orElse("空值");

        Integer userName=Optional.ofNullable(users[0]).map(u->u.getId()).orElseThrow(()->new MyException("1"));
        System.out.println("123111111111111111111111111111");
        List<User> userList=Arrays.asList(users);
        userList.stream().filter(user-> !StringUtils.isEmpty(user.getId())).filter(user -> !StringUtils.isEmpty(user.getUserName())).findFirst().get();
        Optional.ofNullable(userList).filter(users1->users1!=null&&users1.size()>0).orElseThrow(()->new RuntimeException("数据不对"));

        Set<Integer> ages=Arrays.stream(users).flatMap(u->
            Stream.of(u.getAge())
        ).map(i->i*10).collect(toSet());
        ages.forEach(System.out::println);

        Integer sumAge=Arrays.stream(users).flatMap(u->Stream.of(u.getAge())).reduce((x,y)->x+y).get();
        System.out.println("总年龄:"+sumAge);

        /**
         * 说明,sort接收2个参数,一个是数组,另外一个是Compator接口的对象,这个对象有唯一一个抽象方法compare,
         * compare方法有2个参数,分别是person1 ,person2,lambda体中执行的就是compare方法体
         *
         */
         Arrays.sort(users,(p1,p2)->{
            return p1.getAge()-p2.getAge();
        });
        for(User u:users){
            System.out.println(u);
        }

        //List<Integer> numss=getNumList(10,()->(int) Math.random()*100);
        //numss.forEach(System.out::println);

        String aStr=handlerStr("aa",str->str.substring(1));
        String bstr=Stream.of("aa").map(a->a.substring(1)).findFirst().get();
        System.out.println(aStr);
        System.out.println(bstr);

//        int[] nums={100,20,30,52,49,10};
        String[] nums={"abcddddddd","aa","ccccccccccc","ddddddddd"};
        List<String> strFilterList=filterStr(Arrays.asList(nums),str->strLen(str)>=5);
        //strFilterList.forEach(System.out::println);
        List<String> abcList=Stream.of(nums).
                filter(abc->abc.length()>5).
                map(dc->dc.toUpperCase()).
                collect(Collectors.toList());
        abcList.forEach(System.out::println);


//        shopping(40,x-> System.out.println(x*50));
    }

    public static int strLen(String str){
        return str==null?0:str.length();
    }

    public static List<String> filterStr(List<String> str, Predicate<String> pre){
        List<String> resultList=new ArrayList<>();
        str.forEach(a->{
            if(pre.test(a)){
                resultList.add(a);
            }
        });
        return resultList;
    }

    /**
     * Function<T,R> 类型的说明,它的抽象方法接收一个T类型的参数,返回R类型结果
     * @param str
     * @param fun
     * @return
     */
    public static String handlerStr(String str, Function<String,String> fun){
        return fun.apply(str);
    }

    public static List<Integer> getNumList(Integer a,Supplier<Integer> sup){
        List<Integer> integerList=new ArrayList<>();
        for(int i=0;i<a;i++){
            int target=sup.get();
            integerList.add(target);
        }
        return integerList;
    }

    public static void shopping(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    public static int getMaxValue(List<Integer> list,Supplier<Integer> sup){
        return sup.get();
    }

    public static boolean isLength(Integer a){
        return a>30;
    }
}
