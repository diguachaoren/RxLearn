package digua.rxlearn.fragment.c_Filtering_Observables;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import digua.rxlearn.R;
import digua.rxlearn.fragment.other.BaseFragment;
import digua.rxlearn.fragment.other.NoScrollListView;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class C6_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c6, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.IgnoreElements})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.IgnoreElements:
                sample1();
                break;
        }
    }

    private void sample1() {

        Observable.range(1, 10).ignoreElements().subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                Log.e("IgnoreElements", "onCompleted");
                CLog("IgnoreElements:" + "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("IgnoreElements", "onError");
                CLog("IgnoreElements:" + "onError");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e("IgnoreElements", "onNext" + integer);
                CLog("IgnoreElements:" + "onNext" + integer);
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
