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

public class I3_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_i3, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.refcount})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.refcount:
                sample1();
                break;
        }
    }

    private void sample1() {
        //创建一个可连接的Observable
        ConnectableObservable<Long> connectableObservable = Observable.interval(1, TimeUnit.SECONDS).take(6)
                .publish();

        connectableObservable.subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted1.");
                CLog("onCompleted1.");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError1: " + e.getMessage());
                CLog("onError1.");
            }

            @Override
            public void onNext(Long along) {
                System.out.println("onNext1: " + along);
                CLog("onNext1: " + along);
            }
        });

        connectableObservable.delaySubscription(3, TimeUnit.SECONDS)
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted2.");
                        CLog("onCompleted2.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError2: " + e.getMessage());
                        CLog("onError2.");
                    }

                    @Override
                    public void onNext(Long along) {
                        System.out.println("onNext2: " + along);
                        CLog("onNext2.");
                    }
                });

        //如果不调用connect方法，connectableObservable则不会发射数据
        connectableObservable.connect();

        System.out.println("------after refCount()------");
        CLog("------after refCount()------");

        Observable<Long> observable = connectableObservable.refCount();

        observable.subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted3.");
                CLog("onCompleted3.");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError3: " + e.getMessage());
                CLog("onError3: " + e.getMessage());
            }

            @Override
            public void onNext(Long along) {
                System.out.println("onNext3: " + along);
                CLog("onNext3: " + along);
            }
        });

        observable.delaySubscription(3, TimeUnit.SECONDS)
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted4.");
                        CLog("onCompleted4.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError4: " + e.getMessage());
                        CLog("onError4: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Long along) {
                        System.out.println("onNext4: " + along);
                        CLog("onNext4: " + along);
                    }
                });

    }

}
