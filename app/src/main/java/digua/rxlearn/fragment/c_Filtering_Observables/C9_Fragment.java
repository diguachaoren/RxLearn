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
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class C9_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c9, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.skip})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.skip:
                sample1();
                break;
        }
    }

    private void sample1() {
        Integer[] args = {1, 2, 3, 4, 5, 6};
        Observable observable = Observable.from(args).skip(3);
        observable.subscribe(new Observer() {
            @Override
            public void onCompleted() {
                Log.e("skip", "onCompleted");
                CLog("skip:" + "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("skip", "onError");
                CLog("skip:" + "onError");
            }

            @Override
            public void onNext(Object o) {
                Log.e("skip", "onNext" + o);
                CLog("skip:" + "onNext" + o);
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
