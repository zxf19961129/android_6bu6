package qq.app01.com.fragment_app;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FragmentManager fragmentManager = getSupportFragmentManager();

    LinearLayout shouye, tongchengaiwan, youhuizhuanqu, wode;
    ImageView shouye_img, tongcheng_img, youhui_img, wode_img;
    TextView shouye_text, tongcheng_text, youhui_text, wode_text;
    final String tag1 = "BlankFragment_one";
    final String tag2 = "BlankFragment_two";
    final String tag3 = "BlankFragment_three";
    final String tag4 = "BlankFragment_four";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        wode = (LinearLayout) findViewById(R.id.wode);
        wode.setOnClickListener(this);

        tongchengaiwan = (LinearLayout) findViewById(R.id.tongcheng);
        tongchengaiwan.setOnClickListener(this);

        youhuizhuanqu = (LinearLayout) findViewById(R.id.youhuizhuanqu);
        youhuizhuanqu.setOnClickListener(this);

        shouye = (LinearLayout) findViewById(R.id.shouye);
        shouye.setOnClickListener(this);

        shouye_img = (ImageView) findViewById(R.id.shouye_img);
        shouye_text = (TextView) findViewById(R.id.shouye_text);

        tongcheng_img = (ImageView) findViewById(R.id.tongcheng_img);
        tongcheng_text = (TextView) findViewById(R.id.tongcheng_text);

        youhui_img = (ImageView) findViewById(R.id.youhui_img);
        youhui_text = (TextView) findViewById(R.id.youhui_text);

        wode_img = (ImageView) findViewById(R.id.wode_img);
        wode_text = (TextView) findViewById(R.id.wode_text);



        shouye1();
    }

    private void shouye() {
        shouye_img.setImageResource(R.drawable.shouye_xuanzhong);
        shouye_text.setTextColor(Color.parseColor("#E03131"));

        tongcheng_img.setImageResource(R.drawable.tongchengaiwan_weixuanzhong);
        tongcheng_text.setTextColor(Color.parseColor("#636267"));

        youhui_img.setImageResource(R.drawable.youhuizhuanqu_weixuanzhong);
        youhui_text.setTextColor(Color.parseColor("#636267"));

        wode_img.setImageResource(R.drawable.wode_weixuanzhong);
        wode_text.setTextColor(Color.parseColor("#636267"));

    }

    private void tongcheng() {
        tongcheng_img.setImageResource(R.drawable.tongchangaiwan_xuanzhong);
        tongcheng_text.setTextColor(Color.parseColor("#E03131"));

        shouye_img.setImageResource(R.drawable.shouye_weixuanzhong);
        shouye_text.setTextColor(Color.parseColor("#636267"));

        youhui_img.setImageResource(R.drawable.youhuizhuanqu_weixuanzhong);
        youhui_text.setTextColor(Color.parseColor("#636267"));

        wode_img.setImageResource(R.drawable.wode_weixuanzhong);
        wode_text.setTextColor(Color.parseColor("#636267"));

    }

    private void youhui() {
        youhui_img.setImageResource(R.drawable.youhuizhuanqu_xuanzhong);
        youhui_text.setTextColor(Color.parseColor("#E03131"));

        shouye_img.setImageResource(R.drawable.shouye_weixuanzhong);
        shouye_text.setTextColor(Color.parseColor("#636267"));

        tongcheng_img.setImageResource(R.drawable.tongchengaiwan_weixuanzhong);
        tongcheng_text.setTextColor(Color.parseColor("#636267"));

        wode_img.setImageResource(R.drawable.wode_weixuanzhong);
        wode_text.setTextColor(Color.parseColor("#636267"));

    }

    private void wode() {
        wode_img.setImageResource(R.drawable.wode_xuanzhong);
        wode_text.setTextColor(Color.parseColor("#E03131"));

        shouye_img.setImageResource(R.drawable.shouye_weixuanzhong);
        shouye_text.setTextColor(Color.parseColor("#636267"));

        tongcheng_img.setImageResource(R.drawable.tongchengaiwan_weixuanzhong);
        tongcheng_text.setTextColor(Color.parseColor("#636267"));

        youhui_img.setImageResource(R.drawable.youhuizhuanqu_weixuanzhong);
        youhui_text.setTextColor(Color.parseColor("#636267"));
    }

    private void aaa(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fra01, fragment, tag);
        fragmentTransaction.commit();
    }


    private void hide(String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment1 = fragmentManager.findFragmentByTag(tag);
        if (fragment1 != null) {
            fragmentTransaction.hide(fragment1);
        }
        fragmentTransaction.commit();
    }


    private void shouye1() {
        shouye();
        BlankFragment_one one = new BlankFragment_one();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentByTag(tag1);
        if (fragment == null) {
            aaa(one, tag1);
        } else {
            fragmentTransaction.show(fragment);
            hide(tag2);
            hide(tag3);
            hide(tag4);
            fragmentTransaction.commit();
        }
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == shouye.getId()) {
            shouye1();
        } else if (id == tongchengaiwan.getId()) {
            tongcheng();
            BlankFragment_two two = new BlankFragment_two();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment fragment = fragmentManager.findFragmentByTag(tag2);
            Log.i("-----------", "" + fragment);
            if (fragment == null) {
                aaa(two, tag2);
            } else {
                fragmentTransaction.show(fragment);
                hide(tag1);
                hide(tag3);
                hide(tag4);
                fragmentTransaction.commit();
            }
        } else if (id == youhuizhuanqu.getId()) {
            youhui();
            BlankFragment_three three = new BlankFragment_three();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment fragment = fragmentManager.findFragmentByTag(tag3);
            if (fragment == null) {
                aaa(three, tag3);
            } else {
                fragmentTransaction.show(fragment);
                hide(tag1);
                hide(tag2);
                hide(tag4);
                fragmentTransaction.commit();
            }
        } else if (id == wode.getId()) {
            wode();
            BlankFragment_four four = new BlankFragment_four();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment fragment = fragmentManager.findFragmentByTag(tag4);
            Log.i("-----------", "" + fragment);
            if (fragment == null) {
                aaa(four, tag4);
            } else {
                fragmentTransaction.show(fragment);
                hide(tag1);
                hide(tag2);
                hide(tag3);
                fragmentTransaction.commit();
            }
        }
    }
}
