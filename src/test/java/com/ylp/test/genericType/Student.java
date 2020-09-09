package com.ylp.test.genericType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Student extends Person {
    public Student(String name){
        super(name);
    }

    public static void main(String[] args) {
        List<Person> personList=new ArrayList<>();
        personList.add(new Person("1"));
        personList.add(new Person("2"));
        personList.add(new Person("3"));

        printList(personList);

        //下面的是错误的
        List<Student> students=new ArrayList<>();
        students.add(new Student("s1"));
        students.add(new Student("s2"));
        students.add(new Student("s3"));
        printList(students);

        TreeSet<Person> ts=new TreeSet<>();
        ts.add(new Person("p1"));
        ts.add(new Person("p2"));
        ts.add(new Person("p3"));

        List<String> stringList=new ArrayList<>();
        stringList.add("str");

        List<Double> douList=new ArrayList<>();
        List<Integer> intList=new ArrayList<>();
        List<Float> floatList=new ArrayList<>();
        List<Number> numberList=new ArrayList<>();

//        showValue(stringList);
        showValue(douList);
        showValue(intList);
        showValue(floatList);
        showValue(numberList);

        showSuperValue(intList);
//        showSuperValue(floatList);
//        showSuperValue(floatList);
//        showSuperValue(stringList);
        showValue(numberList);
    }

    public static void printList(List<? extends Person> a){
        Iterator<? extends Person> it=a.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getName());
        }
    }

//    public  <T extends Number> void showGeneric(List<T extends Number> lists){
//
//    }

    public <T extends Number> void show1(List<T> lists){

    }

    public static void showValue(List<? extends Number> lists){
    }

    public static void showSuperValue(List<? super Integer> lists){}
}
