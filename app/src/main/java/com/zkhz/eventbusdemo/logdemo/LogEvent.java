package com.zkhz.eventbusdemo.logdemo;

/**
 * Created by Administrator on 2017/12/28 0028.
 */

public class LogEvent {

    private String text;

    public LogEvent(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
