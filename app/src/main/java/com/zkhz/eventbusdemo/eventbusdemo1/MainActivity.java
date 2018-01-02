package com.zkhz.eventbusdemo.eventbusdemo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zkhz.eventbusdemo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/12/28 0028.
 *
 * Step 2.向EventBus注册，成为订阅者以及解除注册
 * 即 可将当前类注册，成为订阅者，即对应观察者模式的“观察者”，
 * 一旦有事件发送过来!!! 该观察者就会接收到匹配的事件。
 * 通常，在类的初始化时便进行注册，如果是Activity则在onCreate()方法内进行注册。
 *
 */

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_wechat)
    RadioButton btnWechat;
    @BindView(R.id.btn_qq)
    RadioButton btnQq;
    @BindView(R.id.btn_other)
    RadioButton btnOther;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.tv_text)
    TextView tvText;
    @BindView(R.id.btn_start)
    Button btnStart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //注册成为订阅者
        EventBus.getDefault().register(this);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.btn_wechat:


                        break;
                    case R.id.btn_qq:

                        break;
                    case R.id.btn_other:

                        break;

                }
            }
        });


    }

    /**
     * Step 3.声明订阅方法,当接收到事件的时候，会调用该方法
     *
     * 在EventBus 3.0中，声明一个订阅方法需要用到@Subscribe注解，
     * 因此在订阅者类中添加一个有着@Subscribe注解的方法即可，
     * 方法名字可自定义，而且必须是public权限!!!
     * 其方法参数有且只能有一个!!!
     * 另外类型必须为第一步定义好的事件类型(比如上面的MessageEvent)
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event){

        Log.d("demo1", "onEvent:receive ");
        tvText.setText(event.getMessage());

        Toast.makeText(MainActivity.this,event.getMessage(),Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.btn_start)
    public void onViewClicked() {

        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除注册
        EventBus.getDefault().unregister(this);
    }
}

