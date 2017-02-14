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
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.GroupedObservable;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class B3_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;


    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b3, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.groupby})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.groupby:
                sample1();
                break;
        }
    }

    private void sample1() {
        Integer[] args = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Log.e("groupby", "---分组前-----");
        CLog("groupby:" + "---分组前-----");
        Observable observable = Observable.from(args);
        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer s) {
                Log.e("groupby", "onNext:" + s);
                CLog("groupby:" + "onNext:" + s);
            }
        });


        Log.e("groupby", "---分组后-----");
        CLog("groupby:" + "---分组后-----");
        Observable observable2 = Observable.from(args);
        observable2.groupBy(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                return integer % 3;////分成0，1，2 三个小组
            }
        }).subscribe(new Observer<GroupedObservable<Integer, Integer>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(final GroupedObservable<Integer, Integer> integerIntegerGroupedObservable) {
                integerIntegerGroupedObservable.subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("groupby", "onNext:" + integerIntegerGroupedObservable.getKey() + "  value:" + integer);
                        CLog("groupby:" + "onNext:" + integerIntegerGroupedObservable.getKey() + "  value:" + integer);
                    }
                });
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
