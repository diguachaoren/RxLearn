package digua.rxlearn.fragment.f_Observable_Utility_Operators;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import digua.rxlearn.R;
import digua.rxlearn.fragment.other.BaseFragment;
import digua.rxlearn.fragment.other.NoScrollListView;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Timestamped;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class F11_Fragment extends BaseFragment {

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f11, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.using})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.using:
                sample1();
                break;
        }
    }

    private void sample1() {
        Observable<Long> observable = usingObserver();
        Subscriber subscriber = new Subscriber() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(Object o) {
            }
        };

        observable.subscribe(subscriber);
        subscriber.unsubscribe();
    }




    private Observable<Long> usingObserver() {
        return Observable.using(() -> new Animal(), i -> Observable.timer(5000,TimeUnit.MILLISECONDS), o -> o.relase());
    }

    private class Animal {
        Subscriber subscriber = new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                Log.d("using","animal eat");
                CLog("using:"+"animal eat");
            }
        };

        public Animal() {
            Log.d("using","create animal");
            CLog("using:"+"create animal");
            Observable.interval(1000, TimeUnit.MILLISECONDS)
                    .subscribe(subscriber);
        }

        public void relase() {
            Log.d("using","animal relase");
            CLog("using:"+"animal relase");
            subscriber.unsubscribe();
        }
    }





}
