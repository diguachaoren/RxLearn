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
import rx.Subscriber;
import rx.Subscription;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class C12_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;


    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c12, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.takelast})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.takelast:
                sample1();
                break;
        }
    }

    private void sample1() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
                .takeLast(2)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.e("takelast", "onCompleted");
                        CLog("takelast:" + "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("takelast", "onError");
                        CLog("takelast:" + "onError");
                    }

                    @Override
                    public void onNext(Integer o) {
                        Log.e("takelast", "onNext" + o);
                        CLog("takelast:" + "onNext" + o);
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
