package com.zkhz.eventbusdemo.eventbusdemo1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zkhz.eventbusdemo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

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

    private static String TAG="SecondActivity";


    @BindView(R.id.btn_sendMessage)
    Button btnSendMessage;
    @BindView(R.id.btn_sendStickyMessage1)
    Button btnSendStickyMessage1;
    @BindView(R.id.btn_sendStickyMessage2)
    Button btnSendStickyMessage2;
    @BindView(R.id.btn_sendStickyMessage3)
    Button btnSendStickyMessage3;
    @BindView(R.id.btn_sendStickyMessage4)
    Button btnSendStickyMessage4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);


    }


    @OnClick({R.id.btn_sendMessage, R.id.btn_sendStickyMessage1, R.id.btn_sendStickyMessage2, R.id.btn_sendStickyMessage3, R.id.btn_sendStickyMessage4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_sendMessage:
                EventBus.getDefault().post(new MessageEvent("Hello..........."));
                finish();
                break;
            case R.id.btn_sendStickyMessage1:
                EventBus.getDefault().postSticky(new MessageEvent("粘性事件1"));
                Log.d(TAG, "发送粘性事件1... ");
                break;
            case R.id.btn_sendStickyMessage2:
                EventBus.getDefault().postSticky(new MessageEvent("粘性事件2"));
                Log.d(TAG, "发送粘性事件2... ");

                break;
            case R.id.btn_sendStickyMessage3:
                EventBus.getDefault().postSticky(new MessageEvent("粘性事件3"));
                Log.d(TAG, "发送粘性事件3... ");

                break;
            case R.id.btn_sendStickyMessage4:
                EventBus.getDefault().register(this);
                Log.d(TAG, "注册成为订阅者...");

                break;
        }
    }

    /**
     * 关于粘性事件，可以参考Android的广播机制，其中有一个粘性广播
     * 粘性广播的意思是：该广播发送后，会保存在内存中，如果后来有注册的Receiver与之匹配，那么该Receiver便会接收到该广播。
     * 那么粘性事件同理，在注册之前便把事件发生出去，等到注册之后便会收到最近发送的粘性事件（必须匹配）。
     * 注意：只会接收到最近发送的一次粘性事件，之前的会接受不到
     *
     */
    @Subscribe(sticky = true)
    public void onEvent(MessageEvent event){
        Toast.makeText(this, "接受到了来自EventBus的事件："+event.getMessage(), Toast.LENGTH_SHORT).show();
        Log.d(TAG, "接受到了来自EventBus的事件: "+event.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

