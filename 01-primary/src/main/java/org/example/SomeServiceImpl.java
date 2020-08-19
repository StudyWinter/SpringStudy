package org.example;

public class SomeServiceImpl implements SomeService {

    /**
     * Spring默认调用无参数的构造方法创建对象
     * 如果没有无参数的构造方法，报错：No default constructor found
     */
    //无参的构造方法
    public SomeServiceImpl(){
       System.out.println("SomeServiceImpl 的无参构造方法");
    }


    @Override
    public void doSome() {
        System.out.println("=====SomeServiceImpl 的业务方法=========");
    }
}
