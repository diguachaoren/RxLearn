package digua.rxlearn.fragment.c_Filtering_Observables;


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
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class C5_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c5, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.first})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.first:
                sample1();
                break;
        }
    }

    private void sample1() {

        Observable.just(1, 2, 3)
                .first()
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onNext(Integer item) {
                        Log.e("first", "" + item);
                        CLog("first:" + "" + item);
                    }

                    @Override
                    public void onError(Throwable error) {
                        Log.e("first", "" + "onError");
                        CLog("first:" + "onError" );
                    }

                    @Override
                    public void onCompleted() {
                        Log.e("first", "" + "onCompleted");
                        CLog("first:" + "onCompleted" );
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
