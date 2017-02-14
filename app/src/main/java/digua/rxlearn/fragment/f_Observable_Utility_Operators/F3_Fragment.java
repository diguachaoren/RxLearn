package digua.rxlearn.fragment.f_Observable_Utility_Operators;


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
import rx.Notification;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

import static android.content.ContentValues.TAG;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class F3_Fragment extends BaseFragment {

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;


    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f3, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.m_d})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.m_d:
                sample1();
                break;
        }
    }

    private void sample1() {
        meterializeObserver();
        deMeterializeObserver();
    }


    /**
     * return Observable<Notification<Integer>>
     */
    private void meterializeObserver() {
        Observable.just(1, 2, 3).materialize().subscribe(new Observer<Notification<Integer>>() {
            @Override
            public void onCompleted() {
                Log.e("meterialize", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("meterialize", "onError");
            }

            @Override
            public void onNext(Notification<Integer> integerNotification) {
                Log.e("meterialize", "Next: " + integerNotification.getValue());
            }
        });
    }

    /**
     * return Observable<Notification<Integer>>
     */
    private void deMeterializeObserver() {

        Observable.just(1, 2, 3).dematerialize().subscribe(new Observer<Object>() {

            @Override
            public void onCompleted() {
                Log.e("deMeterialize", "onCompleted");
                CLog("deMeterialize:onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("deMeterialize", "onError");
                CLog("deMeterialize:onError");
            }

            @Override
            public void onNext(Object o) {
                Log.e("deMeterialize", "onNext" + o);
                CLog("deMeterialize:" + "onNext" + o);
            }
        });
    }


}
