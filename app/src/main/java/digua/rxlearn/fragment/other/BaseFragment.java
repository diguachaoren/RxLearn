package digua.rxlearn.fragment.other;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import digua.rxlearn.R;


/**
 * @author digua
 *         <p>
 *         on 2017/2/14.(^ ^)
 */

public abstract class BaseFragment extends Fragment {

    private List<String> _logs;

    public LogAdapter _adapter;

    private NoScrollListView _logsList;// listview

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // View view = inflater.inflate(R.layout.fragment_a1, container, false);
        View view = setupView(inflater,container,savedInstanceState);
        ButterKnife.bind(this, view);
        _setupLogger();
        return view;
    }


    private void _setupLogger() {
        _logs = new ArrayList<>();
        _adapter = new LogAdapter(getActivity(), new ArrayList<>());
        _logsList = setupListView();
        _logsList.setAdapter(_adapter);
    }

    // listview
    public abstract NoScrollListView  setupListView();

    // main view
    public abstract View setupView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState);


    public void CLog(String logMsg) {

        if (_isCurrentlyOnMainThread()) {
            _logs.add(0, logMsg + " (main thread) ");
            _adapter.clear();
            _adapter.addAll(_logs);
        } else {
            _logs.add(0, logMsg + " (NOT main thread) ");

            // You can only do below stuff on main thread.
            new Handler(Looper.getMainLooper()).post(() -> {
                _adapter.clear();
                _adapter.addAll(_logs);
            });
        }

    }

    private boolean _isCurrentlyOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }


    public void clear(){
        _adapter.clear();
        _logs.clear();
    }
}
