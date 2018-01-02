package com.zkhz.eventbusdemo.eventbusdemo1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.zkhz.eventbusdemo.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/12/28 0028.
 * <p>
 * Step 4.发送事件
 * 与观察者模式对应的，当有事件发生，需要通知观察者的时候，
 * 被观察者会调用notifyObservers()方法来通知所有已经注册的观察者，
 * 在EventBus中，对观察者模式底层进行了封装，
 * 我们只需要调用以下代码就能把事件发送出去：EventBus.getDefault().post(EventType eventType);
 */

public class SecondActivity extends AppCompatActivity {


    @BindView(R.id.btn_sendMessage)
    Button btnSendMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);


    }


    @OnClick(R.id.btn_sendMessage)
    public void onViewClicked() {

        EventBus.getDefault().post(new MessageEvent("Hello..........."));
    }
}

