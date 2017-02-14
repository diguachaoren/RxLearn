package digua.rxlearn.fragment.a_Creating_Observables;


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

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class A4_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;


    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a4, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.from})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.from:
                sample1();
                break;
        }
    }

    private void sample1() {

        String[] args = {"jack", "tom", "petter"};

        Observable observable = Observable.from(args);
        observable.subscribe(new Observer() {
            @Override
            public void onCompleted() {
                Log.e("from", "onCompleted");
                CLog("from:" + "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("from", "onError");
                CLog("from:" + "onError");
            }

            @Override
            public void onNext(Object o) {
                Log.e("from", o.toString());
                CLog("from:" + o.toString());
            }
        });
    }
}
