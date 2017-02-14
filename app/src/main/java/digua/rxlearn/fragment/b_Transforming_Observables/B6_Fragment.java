package digua.rxlearn.fragment.b_Transforming_Observables;


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
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class B6_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b6, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.window})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.window:
                sample1();
                break;
        }
    }

    private void sample1() {

        Observable.interval(1, TimeUnit.SECONDS).take(10).window(3, TimeUnit.SECONDS).subscribe(new Observer<Observable<Long>>() {
            @Override
            public void onCompleted() {
                Log.e("window", "onCompleted");
                CLog("window:" + "onCompleted:");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("window", "onError");
                CLog("window:" + "onError:");
            }

            @Override
            public void onNext(Observable<Long> integerObservable) {
                integerObservable.subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long integer) {
                        Log.e("window", "onNext" + integer);
                        CLog("window:" + "onNext:" + integer);

                    }
                });
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
