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
import rx.Notification;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class F4_Fragment extends BaseFragment {

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f4, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.observe_on})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.observe_on:
                sample1();
                break;
        }
    }

    private void sample1() {
        Observable.just("RxJava")
                .observeOn(getNamedScheduler("map之前的observeOn"))
                .map(s -> {
                    threadInfo(".map()-1");
                    return s + "-map1";
                })
                .map(s -> {
                    threadInfo(".map()-2");
                    return s + "-map2";
                })
                .observeOn(getNamedScheduler("subscribe之前的observeOn"))
                .subscribe(s -> {
                    threadInfo(".onNext()");
                    Log.e("observeOn", s + "-onNext");
                    CLog("observeOn" + s + "-onNext");
                });
    }


    public static Scheduler getNamedScheduler(String name) {
        return Schedulers.from(Executors.newCachedThreadPool(r -> new Thread(r, name)));
    }

    public static void threadInfo(String caller) {
        Log.e("observeOn", caller + " => " + Thread.currentThread().getName());
    }


}
