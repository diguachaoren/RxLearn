package digua.rxlearn.fragment.c_Filtering_Observables;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import digua.rxlearn.R;
import digua.rxlearn.fragment.other.BaseFragment;
import digua.rxlearn.fragment.other.NoScrollListView;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class C4_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c4, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.filter})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.filter:
                sample1();
                break;
        }
    }

    private void sample1() {

        Observable.interval(1, TimeUnit.SECONDS).take(10).filter(new Func1<Long, Boolean>() {
            @Override
            public Boolean call(Long aLong) {
                return aLong > 5;
            }
        }).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                Log.e("elementAt", ""+aLong);
                CLog("elementAt:" + ""+aLong);
            }
        });

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (subscribe != null) {
            subscribe.unsubscribe();
        }
    }
}
