package digua.rxlearn.fragment.d_Combining_Observables;


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
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class D5_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d5, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.startwith})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.startwith:
                sample1();
                break;
        }
    }

    /**
     * startWith操作符是在源Observable提交结果之前，插入指定的某些数据
     */
    private void sample1() {
        Observable.just(10, 20, 30).startWith(2, 3, 4).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(Integer value) {
                Log.e("startwith:", "onNext " + value);
                CLog("startwith:" + "onNext:" + value);
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
