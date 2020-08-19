package org.example.excep;

/**
 * 异常的类
 */

public class NotEnoughException extends RuntimeException {

    //重写构造方法
    public NotEnoughException() {
    }

    public NotEnoughException(String message) {
        super(message);
    }
}
