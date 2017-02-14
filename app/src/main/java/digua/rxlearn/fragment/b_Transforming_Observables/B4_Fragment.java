package digua.rxlearn.fragment.b_Transforming_Observables;


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
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.observables.GroupedObservable;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class B4_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b4, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.map})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.map:
                sample1();
                break;
        }
    }

    private void sample1() {

        String[] args = {"a", "b", "c", "d", "e", "f"};

        Log.e("map", "---处理前-----");
        CLog("map:" + "---处理前-----");
        Observable observable = Observable.from(args);
        observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.e("map", "onNext:" + s);
                CLog("map:" + "onNext:" + s);
            }
        });


        Log.e("map", "---处理后-----");
        CLog("map:" + "---处理后-----");
        Observable observable2 = Observable.from(args);
        observable2.map(new Func1() {
            @Override
            public Object call(Object o) {
                return "$"+o;
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.e("map", "onNext:" + s);
                CLog("map:" + "onNext:" + s);
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
