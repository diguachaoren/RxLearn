package digua.rxlearn.fragment.g_Conditional_and_Boolean_Operators;


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
import rx.functions.Action1;

import static android.content.ContentValues.TAG;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class G5_Fragment extends BaseFragment {

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
        View view = inflater.inflate(R.layout.fragment_g5, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.sequenceequal})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.sequenceequal:
                sample1();
                break;
        }
    }

    private void sample1() {
        equalObserver().subscribe(i -> CLog("sequenceequal"+"equal:" + i));
        notEqualObserver().subscribe(i -> CLog("sequenceequal"+"notequal:" + i));
    }




    private Observable<Boolean> equalObserver() {
        return Observable.sequenceEqual(Observable.just(1, 2, 3), Observable.just(1, 2, 3));
    }

    private Observable<Boolean> notEqualObserver() {
        return Observable.sequenceEqual(Observable.just(1, 2, 3), Observable.just(1, 2));
    }











}
