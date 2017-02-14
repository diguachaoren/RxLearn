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
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;

import static android.content.ContentValues.TAG;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class G2_Fragment extends BaseFragment {

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
        View view = inflater.inflate(R.layout.fragment_g2, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.amb})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.amb:
                sample1();
                break;
        }
    }

    private void sample1() {
        ambObserver().subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.e("amb","onNext: "+integer);
                CLog("amb:" + "onNext: "+integer);
            }
        });
    }





    private Observable<Boolean> allObserver() {
        Observable<Integer> just;
        if (tag) {
            just = Observable.just(1, 2, 3, 4, 5);
        } else {
            just = Observable.just(1, 2, 3, 4, 5, 6);
        }
        tag = true;
        return just.all(integer -> integer < 6);
    }

    private Observable<Integer> ambObserver() {
        Observable<Integer> delay3 = Observable.just(1, 2, 3).delay(3000, TimeUnit.MILLISECONDS);
        Observable<Integer> delay2 = Observable.just(4, 5, 6).delay(2000, TimeUnit.MILLISECONDS);
        Observable<Integer> delay1 = Observable.just(7, 8, 9).delay(1000, TimeUnit.MILLISECONDS);
        return Observable.amb(delay1, delay2, delay3);
    }



}
