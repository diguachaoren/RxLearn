package digua.rxlearn.fragment.f_Observable_Utility_Operators;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import rx.functions.Action1;
import rx.schedulers.Timestamped;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class F10_Fragment extends BaseFragment {

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;


    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f10, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.timestamp})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.timestamp:
                sample1();
                break;
        }
    }

    private void sample1() {
        Observable.just(1, 2, 3)
                .timestamp()
                .subscribe(new Action1<Timestamped<Integer>>() {
                    @Override
                    public void call(Timestamped<Integer> timestamped) {
                        Log.d("JG", timestamped.getTimestampMillis() + " " + timestamped.getValue());
                        CLog("JG" + timestamped.getTimestampMillis() + " " + timestamped.getValue());
                        //1472627510548 1
                        //1472627510549 2
                        //1472627510549 3
                    }
                });
    }


}
