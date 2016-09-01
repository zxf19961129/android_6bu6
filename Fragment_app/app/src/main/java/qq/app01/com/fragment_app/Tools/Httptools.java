package qq.app01.com.fragment_app.Tools;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;

import qq.app01.com.fragment_app.Tools.mode.HomeMode;

/**
 * Created by zhuxiaofeng on 2016/8/30.
 */
public class Httptools {

    private static Httptools httptools;
    private FinalHttp finalHttp;

    private Httptools(){
        if(finalHttp==null){
            finalHttp=new FinalHttp();
        }
    }

    public static  Httptools getHttptools(){
        if(httptools==null){
            httptools=new Httptools();
        }
        return httptools;
    }


    /**
     *获取首页信息
     */
    public  void  getshouyexinxi(final Handler handler, String lat, String lng, String searcename){
        String url = BU6_Tools.HOME+"&lat="+lat+"&lng="+lng;
        finalHttp.get(url, new AjaxCallBack<String>() {
            @Override
            public void onStart() {
                super.onStart();
                Log.e("*************","onStart");
            }

            @Override
            public void onSuccess(String o) {
                super.onSuccess(o);
                Log.e("]]]]]]]]]]]]",""+o);

                //获取到数据
                HomeMode homeMode = JsonParse.result(o);

                Message msg = new Message();
                msg.what = 100;
                msg.obj = homeMode;

                handler.sendMessage(msg);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
                Log.e("*************","onFailure");
            }
        });
    }
}
