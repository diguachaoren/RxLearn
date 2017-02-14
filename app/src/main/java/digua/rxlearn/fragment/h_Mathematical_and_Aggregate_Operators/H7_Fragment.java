package digua.rxlearn.fragment.h_Mathematical_and_Aggregate_Operators;


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
import rx.Subscription;
import rx.functions.Action1;
import rx.observables.MathObservable;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class H7_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_h7, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.sum})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.sum:
                sample1();
                break;
        }
    }

    private void sample1() {

        MathObservable.sumInteger(Observable.just(1, 2, 3, 4))//  10
                .subscribe(new Action1<Integer>() {

                    @Override
                    public void call(Integer value) {
                        System.out.println("sum = " + value);
                        CLog("sum = " + value);
                    }
                });

    }





}
