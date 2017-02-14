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
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.schedulers.TimeInterval;

import static android.content.ContentValues.TAG;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class F8_Fragment extends BaseFragment {

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f7, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.subscribeon})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.subscribeon:
                sample1();
                break;
        }
    }

    private void sample1() {
        Observable.interval(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).
                timeInterval().subscribe(new Action1<TimeInterval<Long>>() {
            @Override
            public void call(TimeInterval<Long> longTimeInterval) {
                Log.d(TAG,"value = "+longTimeInterval.getIntervalInMilliseconds());//
                CLog("value = "+longTimeInterval.getIntervalInMilliseconds());
            }
        });


    }


}
