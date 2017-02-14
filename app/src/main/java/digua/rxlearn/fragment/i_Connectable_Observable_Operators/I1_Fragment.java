package digua.rxlearn.fragment.i_Connectable_Observable_Operators;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;
import rx.observables.MathObservable;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class I1_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;


    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_i1, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.connect})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.connect:
                sample1();
                break;
        }
    }

    private void sample1() {

        ConnectableObservable observable = Observable.range(1, 1000000).sample(10, TimeUnit.MILLISECONDS).publish();

        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted1.");
                CLog("onCompleted1");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError1: " + e.getMessage());
                CLog("onError1");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext1: " + integer);
                CLog("onNext1");
            }
        });

        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted2.");
                CLog("onCompleted2");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError2: " + e.getMessage());
                CLog("onError2");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext2: " + integer);
                CLog("onNext2");
            }
        });

        observable.connect();

    }

}
