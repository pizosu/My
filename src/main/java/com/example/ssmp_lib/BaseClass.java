package com.example.ssmp_lib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//一个日记对象，可通过继承BaseClass来达到方便书写
public class BaseClass {
    public static  Logger log;
    private Class clazz;

    public BaseClass(){
        clazz = this.getClass();
        log = LoggerFactory.getLogger(clazz);
    }

}
