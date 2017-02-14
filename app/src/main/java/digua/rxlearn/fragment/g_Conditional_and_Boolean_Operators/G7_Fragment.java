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
import digua.rxlearn.fragment.other.Student;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class G7_Fragment extends BaseFragment {

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
        View view = inflater.inflate(R.layout.fragment_g7, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.skipwhile})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.skipwhile:
                sample1();
                break;
        }
    }

    private void sample1() {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(6)
                .skipWhile(new Func1<Long, Boolean>() {
                    @Override
                    public Boolean call(Long aLong) {
                        return aLong < 3;   //舍弃原Observable发射的数据，直到发射的数据>=3，才继续发射
                    }
                })
                .subscribe(aBoolean -> CLog(TAG + "SkipWhile:" + aBoolean));

    }


}
