package digua.rxlearn.fragment.d_Combining_Observables;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.joins.Pattern2;
import rx.joins.Plan0;
import rx.observables.JoinObservable;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class D2_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;


    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d2, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.combinelatest})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.combinelatest:
                sample1();
                break;
        }
    }

    private void sample1() {
        Observable<String> o1 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("o1");
                subscriber.onNext("o2");
                subscriber.onNext("o3");
            }
        });
        Observable<String> o2 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("o4");
                subscriber.onNext("o5");
                subscriber.onNext("o6");
            }
        });

        // 将两个数据源的释放item放到一起通过一个func(某种方法)返回你想要的东西
        Observable.combineLatest(o2, o1, new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {
                Log.e("combine --- >", "s = " + s + " | s2 = " + s2);
                CLog("combine:" + "s = " + s + " | s2 = " + s2);
                return s + s2;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.e("onCompleted --- >", "onCompleted");
                CLog("combine:" + "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("onError --- >", "onError");
                CLog("combine:" + "onError");

            }

            @Override
            public void onNext(String o) {
                Log.e("onNext --- >", o);
                CLog("combine:" + "onNext" + o);
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
