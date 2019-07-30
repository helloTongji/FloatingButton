package com.example.contentui;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.azhon.suspensionfab.FabAttributes;
import com.azhon.suspensionfab.OnFabClickListener;
import com.azhon.suspensionfab.SuspensionFab;
import com.example.contentui.BottomBar.BlankFragment;
import com.example.contentui.BottomBar.SignActivity;
import com.example.contentui.FloatButton.AnimationUtil;
import com.example.contentui.FloatButton.FloatingDraftButton;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  {
    private RadioGroup mTabRadioGroup;
    private SparseArray<Fragment> mFragmentSparseArray;



    FloatingDraftButton floatingDraftButton;
    FloatingActionButton liveness;
    FloatingActionButton floatingActionButton2;
    FloatingActionButton floatingActionButton3;
    FloatingActionButton floatingActionButton4;
    FloatingActionButton floatingActionButton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







        initView();
        ButterKnife.bind(this);
        floatingDraftButton = findViewById(R.id.floatingActionButton);
        liveness = findViewById(R.id.floatingActionButton_liveness);
        floatingDraftButton.registerButton(liveness);
        floatingActionButton2 = findViewById(R.id.floatingActionButton_2);
        floatingActionButton3 = findViewById(R.id.floatingActionButton_3);
        floatingActionButton4 = findViewById(R.id.floatingActionButton_4);
        floatingActionButton5 = findViewById(R.id.floatingActionButton_5);

        floatingDraftButton.registerButton(floatingActionButton2);
        floatingDraftButton.registerButton(floatingActionButton3);
        floatingDraftButton.registerButton(floatingActionButton4);
        floatingDraftButton.registerButton(floatingActionButton5);

        floatingDraftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //弹出动态Button
                AnimationUtil.slideButtons(MainActivity.this,floatingDraftButton);
            }
        });





        liveness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {        //关闭动态Button
                AnimationUtil.slideButtons(MainActivity.this,floatingDraftButton);
                Toast.makeText(getApplicationContext(), "liveness", Toast.LENGTH_SHORT).show();
            }
        });

        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {        //关闭动态Button
                AnimationUtil.slideButtons(MainActivity.this,floatingDraftButton);
                Toast.makeText(getApplicationContext(), "floatingActionButton2", Toast.LENGTH_SHORT).show();
            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {        //关闭动态Button
                AnimationUtil.slideButtons(MainActivity.this,floatingDraftButton);
                Toast.makeText(getApplicationContext(), "floatingActionButton3", Toast.LENGTH_SHORT).show();
            }
        });
        floatingActionButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {        //关闭动态Button
                AnimationUtil.slideButtons(MainActivity.this,floatingDraftButton);
                Toast.makeText(getApplicationContext(), "floatingActionButton4", Toast.LENGTH_SHORT).show();
            }
        });
        floatingActionButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {        //关闭动态Button
                AnimationUtil.slideButtons(MainActivity.this,floatingDraftButton);
                Toast.makeText(getApplicationContext(), "floatingActionButton5", Toast.LENGTH_SHORT).show();
            }
        });
    }







    private void initView() {
        mTabRadioGroup = findViewById(R.id.tabs_rg);
        mFragmentSparseArray = new SparseArray<>();
        mFragmentSparseArray.append(R.id.today_tab, BlankFragment.newInstance("今日"));
        mFragmentSparseArray.append(R.id.record_tab, BlankFragment.newInstance("记录"));
        mFragmentSparseArray.append(R.id.contact_tab, BlankFragment.newInstance("通讯录"));
        mFragmentSparseArray.append(R.id.settings_tab, BlankFragment.newInstance("设置"));
        mTabRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 具体的fragment切换逻辑可以根据应用调整，例如使用show()/hide()
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        mFragmentSparseArray.get(checkedId)).commit();
            }
        });
        // 默认显示第一个
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                mFragmentSparseArray.get(R.id.today_tab)).commit();
        findViewById(R.id.sign_iv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignActivity.class));
            }
        });
    }
}
