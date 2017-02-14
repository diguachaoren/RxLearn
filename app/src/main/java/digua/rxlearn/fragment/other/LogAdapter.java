package digua.rxlearn.fragment.other;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import digua.rxlearn.R;

/**
 * @author digua
 *         <p>
 *         on 2017/2/14.(^ ^)
 */

public class LogAdapter extends ArrayAdapter<String> {

    public LogAdapter(Context context, List<String> logs) {
        super(context, R.layout.item_log, R.id.item_log, logs);
    }
}
