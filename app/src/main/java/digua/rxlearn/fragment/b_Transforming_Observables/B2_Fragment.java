package digua.rxlearn.fragment.b_Transforming_Observables;


import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class B2_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;


    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b2, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.flatmap})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.flatmap:
                sample1();
                break;
        }
    }

    private void sample1() {
        String[] args = {"a","b","c","d","e","f","g","h","i"};

        Log.e("flatmap","---flatmap前-----");
        CLog("flatmap:" + "---flatmap前-----");
        Observable observable = Observable.from(args);
        observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.e("flatmap","onNext:" + s);
                CLog("flatmap:" + "onNext:" + s);
            }
        });

        Log.e("flatmap","---flatmap后-----");
        CLog("flatmap:" + "---flatmap后-----");
        Observable observable2 = Observable.from(args).flatMap(new Func1<String, Observable<?>>() {
            @Override
            public Observable<?> call(String s) {
                return machiningDate(s);
            }
        });
        observable2.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.e("flatmap","onNext:" + s);
                CLog("flatmap:" + "onNext:" + s);
            }
        });

    }


    private Observable<?> machiningDate(String s){
        Observable observable = Observable.create(new Observable.OnSubscribe<Object>() {

            @Override
            public void call(Subscriber<? super Object> subscriber) {
                String newString = "@" + s ;// 变换动作
                subscriber.onNext(newString);
            }
        });

        return observable;

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (subscribe != null) {
            subscribe.unsubscribe();
        }
    }
}
