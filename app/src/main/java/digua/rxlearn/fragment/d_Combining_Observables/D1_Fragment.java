package digua.rxlearn.fragment.d_Combining_Observables;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
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
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.joins.Pattern2;
import rx.joins.Plan0;
import rx.observables.JoinObservable;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class D1_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d1, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.and_then_when})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.and_then_when:
                sample1();
                break;
        }
    }

    private void sample1() {

        List<Student> args = new ArrayList<Student>();
        args.add(new Student("jack"));
        args.add(new Student("tom"));
        args.add(new Student("jerry"));

        Observable<Student> obs_stu = Observable.from(args);
        Observable<Long> obs_time = Observable.interval(1, TimeUnit.SECONDS);

        Pattern2<Student, Long> pattern = JoinObservable.from(obs_stu).and(obs_time);
        Plan0<Student> plan = pattern.then(new Func2<Student, Long, Student>() {
            @Override
            public Student call(Student student, Long aLong) {
                Log.e("do:", student.getName() + aLong);
                return student;
            }
        });

        JoinObservable
                .when(plan)
                .toObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Student>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Student student) {
                        Log.e("JoinObservable:", student.getName());
                        CLog("JoinObservable:" + "onNext:" + student.getName());

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
