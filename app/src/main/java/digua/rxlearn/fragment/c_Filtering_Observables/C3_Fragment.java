package digua.rxlearn.fragment.c_Filtering_Observables;


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

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class C3_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c3, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.elementat})
    public void clickEvent(View view) {
        clear();
        switch (view.getId()) {
            case R.id.elementat:
                sample1();
                break;
        }
    }

    private void sample1() {

        Integer[] integer = {1, 2, 3, 4, 5, 6};

        Observable observable = Observable.from(integer).elementAtOrDefault(1, 2);

        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                Log.e("elementAt", "onCompleted");
                CLog("elementAt:" + "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("elementAt", "onError");
                CLog("elementAt:" + "onError");
            }

            @Override
            public void onNext(Integer o) {
                Log.e("elementAt", "onNext:" + o);
                CLog("elementAt:" + "onNext:" + o);
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
