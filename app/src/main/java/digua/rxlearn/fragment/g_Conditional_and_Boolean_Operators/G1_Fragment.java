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
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.functions.Func2;

import static android.content.ContentValues.TAG;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class G1_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    Subscription subscribe;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_g1, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.all})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.all:
                sample1();
                break;
        }
    }

    private void sample1() {
        Observable.just(1, 2, 3, 4)
                .all(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        Log.e(TAG, "" + integer);
                        return integer < 3;    //判断是不是发射的所有数据都小于3
                    }
                }).subscribe(new Subscriber<Boolean>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted");
                CLog("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError:" + e.getMessage());
                CLog("onError:" + e.getMessage());
            }

            @Override
            public void onNext(Boolean aBoolean) {
                Log.e(TAG, "onNext:" + aBoolean);
                CLog("onNext:" + aBoolean);
            }
        });


    }

}
