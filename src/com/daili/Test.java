package com.daili;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Rent rent=new RentImpl();
//        Intermediary intermediary=new Intermediary(rent);
//        Rent rent1 = (Rent) Proxy.newProxyInstance(rent.getClass().getClassLoader(), rent.getClass().getInterfaces(), intermediary);
//        rent1.rent();
    }
}
