package qq.app01.com.fragment_app;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.tsz.afinal.FinalBitmap;

import java.util.ArrayList;
import java.util.List;

import qq.app01.com.fragment_app.Tools.BU6_Tools;
import qq.app01.com.fragment_app.Tools.Httptools;
import qq.app01.com.fragment_app.Tools.mode.Ad;
import qq.app01.com.fragment_app.Tools.mode.HengMode;
import qq.app01.com.fragment_app.Tools.mode.HomeMode;
import qq.app01.com.fragment_app.adpater.AdAdpater;


public class BlankFragment_one extends Fragment {

    private ViewPager viewPager;
    private ListView listView;
    private AdAdpater adAdpater;
    private FinalBitmap finalBitmap;
    private HomeMode homeMode;
    BaseAdapter baseAdapter;

    List<HengMode> list;

    Httptools httptools = Httptools.getHttptools();

    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 100:
                    parseHandlerMsg(msg.obj);
                    message(msg.obj);
                    break;
                case 200:
                    logicCars();
                    break;
                default:
                    break;
            }
        }

    };

    private void parseHandlerMsg(Object obj) {
        if (obj != null && obj instanceof HomeMode) {
            homeMode = (HomeMode) obj;
            if (homeMode != null && homeMode.getResultCode() != null) {
                List<Ad> ad = homeMode.getResultCode().getAd();
                List<View> views = new ArrayList<View>();
                for (int i = 0; i < ad.size(); i++) {
                    ImageView imageView = new ImageView(getActivity());
                    views.add(imageView);
                }
                adAdpater.setAd(ad);
                adAdpater.setViews(views);
                adAdpater.notifyDataSetChanged();

                if (views != null && views.size() > 1) {
                    mHandler.sendEmptyMessageDelayed(200, 3000);
                }
            }
            message(obj);
        }
    }

    public void message(Object obj) {
        list = new ArrayList();
        for (int i = 0; i < homeMode.getResultCode().getRecommenMode().getHeng().size(); i++) {
            list.add(homeMode.getResultCode().getRecommenMode().getHeng().get(i));
        }
        baseAdapter.notifyDataSetChanged();
        for (int i = 0; i < list.size(); i++) {
            Toast.makeText(getActivity(), list.get(i).getAddress(), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 首页轮播图动画
     */
    public void logicCars() {
        int item = viewPager.getCurrentItem();
        if (item == adAdpater.getAd().size() - 1) {
            viewPager.setCurrentItem(0);
        } else {
            viewPager.setCurrentItem(item + 1);
        }
        mHandler.sendEmptyMessageDelayed(200, 3000);
    }

    public BlankFragment_one() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        httptools.getshouyexinxi(mHandler, "1", "1", null);


    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blank_fragment_one, container, false);
        listView = (ListView) view.findViewById(R.id.list);
        listView.setAdapter(base());

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        adAdpater = new AdAdpater(getActivity());
        viewPager.setAdapter(adAdpater);

        return view;
    }


    public BaseAdapter base() {
        baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {

                return list == null ? 0 : list.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                LayoutInflater innn = LayoutInflater.from(getActivity());
                View view = innn.inflate(R.layout.shouye, null);
                RelativeLayout img = (RelativeLayout) view.findViewById(R.id.re01);
                RelativeLayout img2 = (RelativeLayout) view.findViewById(R.id.re02);
                img2.getBackground().setAlpha(100);
                FinalBitmap finalBitmap = FinalBitmap.create(getActivity());
                finalBitmap.display(img, BU6_Tools.BASE + list.get(position).getPic());
                TextView text = (TextView) view.findViewById(R.id.texview);
                text.setText(list.get(position).getShopname());
                TextView text2 = (TextView) view.findViewById(R.id.texview2);
                text2.setText(list.get(position).getAddress());
                return view;
            }
        };
        return baseAdapter;
    }


}
