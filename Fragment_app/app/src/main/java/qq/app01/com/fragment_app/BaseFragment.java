package qq.app01.com.fragment_app;

import android.app.Fragment;
import android.os.Bundle;

import qq.app01.com.fragment_app.Tools.Httptools;

public abstract class BaseFragment extends Fragment {

    protected Httptools httptools;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        httptools = Httptools.getHttptools();

    }

}
