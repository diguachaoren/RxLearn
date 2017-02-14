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

public class A6_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;


    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a6, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.just})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.just:
                sample1();
                break;
        }
    }

    private void sample1() {
        Observable observable = Observable.just(1, 2, 3);
        subscribe = observable.subscribe(new Observer() {
            @Override
            public void onCompleted() {
                Log.e("just", "onCompleted");
                CLog("just:" + "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("just", "onError");
                CLog("just:" + "onError");
            }

            @Override
            public void onNext(Object o) {
                Log.e("just", o.toString());
                CLog("just:" + o.toString());
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
