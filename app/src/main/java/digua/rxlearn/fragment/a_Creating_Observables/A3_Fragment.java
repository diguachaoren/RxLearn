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
import rx.functions.Func0;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class A3_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a3, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.empty,R.id.never,R.id.throw_2})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.empty:
                sample1();
                break;
            case R.id.never:
                sample2();
                break;
            case R.id.throw_2:
                sample3();
                break;
        }
    }

    private void sample1() {
        Observable observable = Observable.empty();
        observable.subscribe(new Observer() {
            @Override
            public void onCompleted() {
                Log.e("empty", "onCompleted");
                CLog("empty:"+"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("empty", "onError");
                CLog("empty:"+"onError");
            }

            @Override
            public void onNext(Object o) {
                Log.e("empty", "onNext");
                CLog("empty:"+"onNext");
            }
        });
    }

    private void sample2() {
        Observable observable = Observable.never();
        observable.subscribe(new Observer() {
            @Override
            public void onCompleted() {
                Log.e("never", "onCompleted");
                CLog("never:"+"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("never", "onError");
                CLog("never:"+"onError");
            }

            @Override
            public void onNext(Object o) {
                Log.e("never", "onNext");
                CLog("never:"+"onNext");
            }
        });
    }

    private void sample3() {
        Observable observable = Observable.error(new Exception("error!!"));
        observable.subscribe(new Observer() {
            @Override
            public void onCompleted() {
                Log.e("throw", "onCompleted");
                CLog("throw:"+"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("throw", "onError");
                CLog("throw:"+"onError");
            }

            @Override
            public void onNext(Object o) {
                Log.e("throw", "onNext");
                CLog("throw:"+"onNext");
            }
        });


    }
}
