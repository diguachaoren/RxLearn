package digua.rxlearn.fragment.c_Filtering_Observables;


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
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class C2_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c2, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.distinct})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.distinct:
                sample1();
                break;
        }
    }

    private void sample1() {

        Integer[] integer = {1, 2, 3, 4, 4, 5, 5};

        Observable observable = Observable.from(integer).distinct();

        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                Log.e("distinct", "onCompleted");
                CLog("distinct:" + "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("distinct", "onError");
                CLog("distinct:" + "onError");
            }

            @Override
            public void onNext(Integer o) {
                Log.e("distinct", "onNext:" + o);
                CLog("distinct:" + "onNext:" + o);
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
