package digua.rxlearn.fragment.g_Conditional_and_Boolean_Operators;


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
import rx.Subscription;
import rx.functions.Func1;

import static android.content.ContentValues.TAG;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class G9_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    boolean tag = false;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_g9, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.takewhile})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.takewhile:
                sample1();
                break;
        }
    }

    private void sample1() {
        Observable.interval(1, TimeUnit.SECONDS).takeWhile(aLong -> aLong < 5).subscribe(new Observer<Long>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.e("takeWhile", "onNext: " + aLong);
                CLog("takeWhile" + "onNext: " + aLong);
            }
        });


    }


}
