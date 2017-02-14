package digua.rxlearn.fragment.a_Creating_Observables;


import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import digua.rxlearn.R;
import digua.rxlearn.fragment.other.BaseFragment;
import digua.rxlearn.fragment.other.LogAdapter;
import digua.rxlearn.fragment.other.NoScrollListView;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class A1_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    @BindView(R.id.button) Button button;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;


    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a1, container, false);
        return view;
    }


    /**
     * 点击事件
     */
    @OnClick({R.id.button})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.button:
                clear();
                sample();
                break;
        }
    }



    /**
     * 点击事件
     */
    private void sample() {

        // 创建观察者
        Observable observable = Observable
                .create(new Observable.OnSubscribe<Integer>() {
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        try {
                            if (!subscriber.isUnsubscribed()) {
                                for (int i = 0; i <= 5; i++) {
                                    Thread.sleep(1000);
                                    subscriber.onNext(i);
                                }
                                subscriber.onCompleted();
                            }
                        } catch (Exception e) {
                            subscriber.onError(e);
                        }

                    }
                });

        // 订阅
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer() {
                    @Override
                    public void onCompleted() {
                        Log.e("create", "onCompleted");
                        CLog("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("create", "onError");
                        CLog("onError");
                    }

                    @Override
                    public void onNext(Object o) {
                        Log.e("create", "onNext -> " + o.toString());
                        CLog("onNext -> " + o.toString());
                    }
                });

    }



}
