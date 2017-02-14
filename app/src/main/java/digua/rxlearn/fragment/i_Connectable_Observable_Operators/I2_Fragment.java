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

public class I2_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_i2, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.publish})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.publish:
                sample1();
                break;
        }
    }

    private void sample1() {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        //使用publish操作符将普通Observable转换为可连接的Observable
        ConnectableObservable<Long> connectableObservable = observable.publish();

        //第一个订阅者订阅，不会开始发射数据
        connectableObservable.subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                System.out.println("1.onCompleted");
                CLog("1.onCompleted");
            }
            @Override
            public void onError(Throwable e) {
                System.out.println("1.onError");
                CLog("1.onError");
            }
            @Override
            public void onNext(Long value) {
                System.out.println("1.onNext value :"+ value);
                CLog("1.onNext value :"+ value);
            }
        });

        //如果不调用connect方法，connectableObservable则不会发射数据
        connectableObservable.connect();
        //第二个订阅者延迟2s订阅，这将导致丢失前面2s内发射的数据
        connectableObservable
                .delaySubscription(2, TimeUnit.SECONDS)// 0、1数据丢失
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("2.onCompleted");
                        CLog("2.onCompleted");
                    }
                    @Override
                    public void onError(Throwable e) {
                        System.out.println("2.onError");
                        CLog("2.onError");
                    }
                    @Override
                    public void onNext(Long value) {
                        System.out.println("2.onNext value :"+ value);
                        CLog("2.onNext value :"+ value);
                    }
                });

    }

}
