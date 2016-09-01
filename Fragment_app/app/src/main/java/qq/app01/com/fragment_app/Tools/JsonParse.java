package qq.app01.com.fragment_app.Tools;

import com.google.gson.Gson;

import qq.app01.com.fragment_app.Tools.mode.HomeMode;

/**
 * Created by zhuxiaofeng on 2016/8/31.
 */
public class JsonParse {


    public static HomeMode result(String message){
        HomeMode homeMode = null;
        Gson gson = new Gson();
        homeMode= gson.fromJson(message,HomeMode.class);
        return homeMode;
    }


}
