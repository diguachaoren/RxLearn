package digua.rxlearn.fragment.a_Creating_Observables;


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

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class A10_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a10, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.timer})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.timer:
                sample1();
                break;
        }
    }

    private void sample1() {

        Observable<Long> observable = Observable.timer(2, 1, TimeUnit.SECONDS);
        subscribe = observable.subscribe(new Observer() {
            @Override
            public void onCompleted() {
                Log.e("timer", "onCompleted");
                CLog("timer:" + "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("timer", "onError");
                CLog("timer:" + "onError");
            }

            @Override
            public void onNext(Object o) {
                Log.e("timer", o.toString());
                CLog("timer:" + o.toString());
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
