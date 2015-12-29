package com.kwmath.www.verygood;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;


public class MainActivity extends Activity {

    FragmentManager manager;
    FragmentTransaction trans;

    homeFragment homeFg;
    calenderFragment calenderFg = new calenderFragment();
    developerPageFragment developerFg  = new developerPageFragment();
    donationFragment donationFg = new donationFragment();
    alarmFragment alarmFg = new alarmFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuItemSetting(); //반드시 이 위치에 실행되어야 한다.




    }


    public void menuItemSetting()
    {



        //**********************************Circular Floating Menu Button 라이브러리 코드****************************//
        //**********************************Circular Floating Menu Button 라이브러리 코드****************************//
        //**********************************Circular Floating Menu Button 라이브러리 코드****************************//
        //**********************************Circular Floating Menu Button 라이브러리 코드****************************//

        final ImageView icon = new ImageView(this); // Create an icon
        final FloatingActionButton rightLowerButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .build();

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        ImageView info_icon = new ImageView(this);   //메뉴 아이템 5개 만들기
        ImageView dollar_icon = new ImageView(this);
        ImageView alarm_icon = new ImageView(this);
        ImageView calendar_icon = new ImageView(this);
        ImageView home_icon = new ImageView(this);

        icon.setImageResource(R.drawable.new_add);        //+ 메뉴버튼 아이콘
        info_icon.setImageResource(R.drawable.info_icon); //만든이 정보 아이콘
        dollar_icon.setImageResource(R.drawable.dollar_icon); //기부 정보 아이콘
        alarm_icon.setImageResource(R.drawable.alarm_icon);  // 알람 설정 아이콘
        calendar_icon.setImageResource(R.drawable.calendar_icon); // 캘린더 정보 아이콘
        home_icon.setImageResource(R.drawable.home_icon_256); // 홈화면 아이콘콘


        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(this);
        final FloatingActionMenu rightLowerMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(rLSubBuilder.setContentView(info_icon).build())
                .addSubActionView(rLSubBuilder.setContentView(dollar_icon).build())
                .addSubActionView(rLSubBuilder.setContentView(alarm_icon).build())
                .addSubActionView(rLSubBuilder.setContentView(calendar_icon).build())
                .addSubActionView(rLSubBuilder.setContentView(home_icon).build())
                .attachTo(rightLowerButton)
                .build();

        // Listen menu open and close events to animate the button content view
        rightLowerMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
            @Override
            public void onMenuOpened(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees clockwise
                icon.setRotation(0);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 45);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(icon, pvhR);
                animation.start();
            }

            @Override
            public void onMenuClosed(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees counter-clockwise
                icon.setRotation(45);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 0);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(icon, pvhR);
                animation.start();
            }
        });

        //**********************************Circular Floating Menu Button 라이브러리 코드****************************//
        //**********************************Circular Floating Menu Button 라이브러리 코드****************************//
        //**********************************Circular Floating Menu Button 라이브러리 코드****************************//
        //**********************************Circular Floating Menu Button 라이브러리 코드****************************//


        manager = getFragmentManager();
        homeFg = (homeFragment)manager.findFragmentById(R.id.home_fg);

        home_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trans = manager.beginTransaction();
                trans.replace(R.id.home_fg, homeFg);
                trans.commit();
            }
        });

        calendar_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trans = manager.beginTransaction();
                trans.replace(R.id.home_fg, calenderFg);
                trans.commit();

            }
        });

        info_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trans = manager.beginTransaction();
                trans.replace(R.id.home_fg, developerFg);
                trans.commit();

            }
        });

        dollar_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trans = manager.beginTransaction();
                trans.replace(R.id.home_fg, donationFg);
                trans.commit();

            }
        });
        alarm_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trans = manager.beginTransaction();
                trans.replace(R.id.home_fg, alarmFg);
                trans.commit();

            }
        });

    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
