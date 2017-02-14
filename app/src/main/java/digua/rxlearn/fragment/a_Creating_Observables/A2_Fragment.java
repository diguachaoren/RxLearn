package digua.rxlearn.fragment.a_Creating_Observables;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import digua.rxlearn.R;
import digua.rxlearn.fragment.other.BaseFragment;
import digua.rxlearn.fragment.other.NoScrollListView;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.functions.Func0;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class A2_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a2, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.button1, R.id.button2})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.button1:
                clear();
                sample1();
                break;
            case R.id.button2:
                clear();
                sample2();
                break;
        }
    }

    private void sample1() {
        Observable<Long> now = Observable.just(System.currentTimeMillis());
        try {
            now.subscribe(new Observer<Long>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Long aLong) {
                    Log.e("just", "" + aLong);
                    CLog("just" + aLong);
                }
            });
            Thread.sleep(2000);
            now.subscribe(new Observer<Long>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Long aLong) {
                    Log.e("just", "" + aLong);
                    CLog("just" + aLong);
                }
            });
        } catch (Exception e) {

        }
    }

    private void sample2() {
        try {
            Observable<Long> now = Observable.defer(new Func0<Observable<Long>>() {
                @Override
                public Observable<Long> call() {
                    return Observable.just(System.currentTimeMillis());
                }
            });
            now.subscribe(new Observer<Long>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Long aLong) {
                    Log.e("defer", "" + aLong);
                    CLog("defer" + aLong);
                }
            });
            Thread.sleep(2000);
            now.subscribe(new Observer<Long>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Long aLong) {
                    Log.e("defer", "" + aLong);
                    CLog("defer" + aLong);
                }
            });
        } catch (Exception e) {

        }
    }

}
