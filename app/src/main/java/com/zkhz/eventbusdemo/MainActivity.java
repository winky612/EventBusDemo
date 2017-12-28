package com.zkhz.eventbusdemo;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/12/28 0028.
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
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
}

