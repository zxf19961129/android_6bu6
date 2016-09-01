package qq.app01.com.fragment_app.adpater;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import net.tsz.afinal.FinalBitmap;

import java.util.ArrayList;
import java.util.List;

import qq.app01.com.fragment_app.Tools.BU6_Tools;
import qq.app01.com.fragment_app.Tools.mode.Ad;

/**
 * Created by zhuxiaofeng on 2016/8/31.
 */
public class AdAdpater extends PagerAdapter{

    private List<Ad> ad = new ArrayList<Ad>();
    private List<View> views = new ArrayList<View>();
    private FinalBitmap finalBitmap;

    public AdAdpater(Context context){
        finalBitmap = FinalBitmap.create(context);
//        finalBitmap.configLoadingImage();
    }

    public List<Ad> getAd() {
        return ad;
    }

    public void setAd(List<Ad> ad) {
        this.ad.addAll(ad);
    }

    public List<View> getViews() {
        return views;
    }

    public void setViews(List<View> views) {
        this.views.addAll(views);
    }

    @Override
    public int getCount() {
        return ad.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
        container.removeView(views.get(position));
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView view = (ImageView) views.get(position);
        container.addView(views.get(position));

        finalBitmap.display(view, BU6_Tools.BASE+ad.get(position).getPic());
        return views.get(position);
    }
}
