package digua.rxlearn.fragment.h_Mathematical_and_Aggregate_Operators;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import digua.rxlearn.R;
import digua.rxlearn.fragment.other.BaseFragment;
import digua.rxlearn.fragment.other.NoScrollListView;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Func1;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class H3_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_h3, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.count})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.count:
                sample1();
                break;
        }
    }

    private void sample1() {
        conuntObserver().subscribe(i -> CLog("count" + "conunt:" + i));
    }


    private Observable<Integer> conuntObserver() {
        return Observable.just(1, 2, 3).count();
    }


}
