package digua.rxlearn.fragment.e_Error_Handling_Operators;


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

public class E1_Fragment extends BaseFragment {

    @BindView(R.id.textview) TextView textview;

    Subscription subscribe;

    private List<Student> mAdaStudent = new ArrayList<Student>();

    @BindView(R.id.list_threading_log) NoScrollListView _logsList;

    @Override
    public NoScrollListView setupListView() {
        return _logsList;
    }

    @Override
    public View setupView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_e1, container, false);
        return view;
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.catch_})
    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.catch_:
                sample1();
                break;
        }
    }

    private void sample1() {
        Observable.create(new Observable.OnSubscribe<Student>() {
            @Override
            public void call(Subscriber<? super Student> subscriber) {
                subscriber.onNext(getListOfStudent().get(0));
                subscriber.onNext(getListOfStudent().get(1));
                subscriber.onNext(getListOfStudent().get(2));
                subscriber.onError(new Throwable("do onError"));
                subscriber.onNext(getListOfStudent().get(3));
                subscriber.onNext(getListOfStudent().get(4));
                subscriber.onNext(getListOfStudent().get(5));
            }
        }).subscribeOn(Schedulers.io())
                .onErrorReturn(new Func1<Throwable, Student>() {
                    @Override
                    public Student call(Throwable throwable) {
                        return new Student("tom - 1");
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Student>() {

                    @Override
                    public void onStart() {
                        super.onStart();
                        mAdaStudent.clear();
                    }

                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "do onCompleted");
                        CLog("do onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "do onError");
                        CLog("do onError");
                    }

                    @Override
                    public void onNext(Student student) {
                        Log.i(TAG, "do onNext");
                        mAdaStudent.add(student);
                        CLog("do onNext");
                    }
                });
    }



    private List<Student> getListOfStudent(){
        mAdaStudent.add(new Student("jack - 1"));
        mAdaStudent.add(new Student("jack - 2"));
        mAdaStudent.add(new Student("jack - 3"));
        mAdaStudent.add(new Student("jack - 4"));
        return mAdaStudent;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (subscribe != null) {
            subscribe.unsubscribe();
        }
    }
}
