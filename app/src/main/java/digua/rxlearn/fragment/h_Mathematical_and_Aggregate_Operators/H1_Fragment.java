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
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.MathObservable;

import static android.content.ContentValues.TAG;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class H1_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_h1, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.average})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.average:
                sample1();
                break;
        }
    }

    private void sample1() {

        MathObservable.averageInteger(Observable.just(1, 2, 3, 4))//  10/4=2
                .subscribe(new Action1<Integer>() {

                    @Override
                    public void call(Integer value) {
                        System.out.println("onSuccess value = " + value);
                        CLog("onSuccess value = " + value);
                    }
                });

    }

}
