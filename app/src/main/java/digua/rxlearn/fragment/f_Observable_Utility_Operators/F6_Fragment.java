package digua.rxlearn.fragment.f_Observable_Utility_Operators;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import rx.functions.Action0;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class F6_Fragment extends BaseFragment {

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f6, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.subscribe})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.subscribe:
                sample1();
                break;
        }
    }

    private void sample1() {

        Observable observable = Observable.empty();
        observable.subscribe(new Observer() {// 通过subscribe完成订阅
            @Override
            public void onCompleted() {
                Log.e("empty", "onCompleted");
                CLog("empty:" + "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("empty", "onError");
                CLog("empty:" + "onError");
            }

            @Override
            public void onNext(Object o) {
                Log.e("empty", "onNext");
                CLog("empty:" + "onNext");
            }
        });



    }


}
