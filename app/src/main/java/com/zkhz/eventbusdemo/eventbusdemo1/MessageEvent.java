package com.zkhz.eventbusdemo.eventbusdemo1;

/**
 * Created by Administrator on 2018/1/2 0002.
 *
 * Step 1.创建事件实体类
 *
 * 所谓的事件实体类，就是传递的事件，
 * 一个组件向另一个组件发送的信息可以储存在一个类中，
 * 该类就是一个事件，会被EventBus发送给订阅者。
 */

public class MessageEvent {
    private String message;

    public MessageEvent() {
    }

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
