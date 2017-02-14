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
import rx.schedulers.Schedulers;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class B1_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b1, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.buffer1, R.id.buffer2, R.id.buffer3, R.id.buffer4})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.buffer1:
                sample1();
                break;
            case R.id.buffer2:
                sample2();
                break;
            case R.id.buffer3:
                sample3();
                break;
            case R.id.buffer4:
                sample4();
                break;
        }
    }

    private void sample1() {
        Observable.range(1, 5).buffer(2).subscribe(new Observer<List<Integer>>() {
            @Override
            public void onCompleted() {
                Log.e("buffer1", "onCompleted");
                CLog("buffer1:" + "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("buffer1", "onError");
                CLog("buffer1:" + "onError");
            }

            @Override
            public void onNext(List<Integer> strings) {
                Log.e("buffer1", "onNext:" + strings.toString());
                CLog("buffer1:" + "onNext:" + strings.toString());
            }
        });
    }

    private void sample2() {
        Observable.range(1, 5).buffer(5).subscribe(new Observer<List<Integer>>() {
            @Override
            public void onCompleted() {
                Log.e("buffer2", "onCompleted");
                CLog("buffer2:" + "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("buffer2", "onError");
                CLog("buffer2:" + "onError");
            }

            @Override
            public void onNext(List<Integer> strings) {
                Log.e("buffer2", "onNext:" + strings.toString());
                CLog("buffer2:" + "onNext:" + strings.toString());
            }
        });
    }

    private void sample3() {
        Observable.range(1, 5).buffer(5, 1).subscribe(new Observer<List<Integer>>() {
            @Override
            public void onCompleted() {
                Log.e("buffer3", "onCompleted");
                CLog("buffer3:" + "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("buffer3", "onError");
                CLog("buffer3:" + "onError");
            }

            @Override
            public void onNext(List<Integer> strings) {
                Log.e("buffer3", "onNext:" + strings.toString());
                CLog("buffer3:" + "onNext:" + strings.toString());
            }
        });
    }

    private void sample4() {
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (subscriber.isUnsubscribed()) return;
                while (true) {
                    subscriber.onNext("消息" + SystemClock.elapsedRealtime());
                    SystemClock.sleep(2000);//每隔2s发送消息
                }

            }
        });

        subscribe = observable.subscribeOn(Schedulers.io())
                .buffer(3, TimeUnit.SECONDS)//每隔3秒 取出消息
                .subscribe(new Observer<List<String>>() {
                    @Override
                    public void onCompleted() {
                        Log.e("buffer4", "onCompleted");
                        CLog("buffer4:" + "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("buffer4", "onError");
                        CLog("buffer4:" + "onError");
                    }

                    @Override
                    public void onNext(List<String> strings) {
                        Log.e("buffer4", "onNext:" + strings.toString());
                        CLog("buffer4:" + "onNext:" + strings.toString());
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
