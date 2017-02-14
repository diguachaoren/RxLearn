package digua.rxlearn.fragment.j_Operators_to_Convert_Observables;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import rx.observables.ConnectableObservable;
import rx.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class J1_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;


    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_j1, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.to})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.to:
                sample1();
                break;
        }
    }

    private void sample1() {
        Iterator<Student> iterator  = Observable.from(getListOfStudent())
                .subscribeOn(Schedulers.io())
                .toBlocking()
                .getIterator();

        while (iterator.hasNext()) {
            Log.i(TAG, iterator.next().toString());
            CLog(iterator.next().toString());
        }
    }


    private List<Student> getListOfStudent(){
        List<Student> args = new ArrayList<Student>();
        args.add(new Student("jack - 1"));
        args.add(new Student("jack - 2"));
        args.add(new Student("jack - 3"));
        args.add(new Student("jack - 4"));
        return args;
    }

}
