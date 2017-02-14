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

public class I4_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_i4, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.replay})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.replay:
                sample1();
                break;
        }
    }

    private void sample1() {
        //创建一个可连接的Observable
        ConnectableObservable<Long> connectableObservable = Observable.interval(1, TimeUnit.SECONDS).take(5)
                .publish();
        //如果不调用connect方法，connectableObservable则不会发射数据
        connectableObservable.connect();
        connectableObservable.delaySubscription(3, TimeUnit.SECONDS)//延时订阅
                .subscribe(new Subscriber<Long>() {
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

        //创建一个可连接的Observable
        ConnectableObservable<Long> connectableObservable2 = Observable.interval(1, TimeUnit.SECONDS).take(6)
                .replay(1);//这里不在使用publish，replay(1)缓存1个数据

        //如果不调用connect方法，connectableObservable则不会发射数据
        connectableObservable2.connect();
        connectableObservable2.delaySubscription(3, TimeUnit.SECONDS)//延时订阅
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
                        CLog("onNext2: " + along);
                    }
                });

        //创建一个可连接的Observable
        ConnectableObservable<Long> connectableObservable3 = Observable.interval(1, TimeUnit.SECONDS).take(6)
                .replay(3, TimeUnit.SECONDS);//这里不在使用publish，replay(3, TimeUnit.SECONDS)缓存3s内的数据

        //如果不调用connect方法，connectableObservable则不会发射数据
        connectableObservable3.connect();
        connectableObservable3.delaySubscription(3, TimeUnit.SECONDS)//延时订阅
                .subscribe(new Subscriber<Long>() {
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
    }

}
