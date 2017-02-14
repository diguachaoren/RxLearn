package digua.rxlearn.fragment.f_Observable_Utility_Operators;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import digua.rxlearn.R;
import digua.rxlearn.fragment.other.BaseFragment;
import digua.rxlearn.fragment.other.NoScrollListView;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class F5_Fragment extends BaseFragment {

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f5, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.serialize})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.serialize:
                sample1();
                break;
        }
    }

    private void sample1() {

        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onCompleted();
                subscriber.onNext(3);
                subscriber.onCompleted();
            }
        })
                .serialize()
                .doOnUnsubscribe(new Action0() {
                    @Override
                    public void call() {
                        Log.e("serialize","onUnsubscribe");
                        CLog("serialize" + "onUnsubscribe");
                    }
                })
                .unsafeSubscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.e("serialize","onCompleted");
                        CLog("serialize" + "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("serialize","onError");
                        CLog("serialize" + "onError");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("serialize","onNext: "+ integer);
                        CLog("serialize" + "onNext: "+ integer);
                    }
                });
    }


}
