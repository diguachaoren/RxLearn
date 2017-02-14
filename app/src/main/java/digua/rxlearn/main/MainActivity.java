package digua.rxlearn.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import butterknife.ButterKnife;
import butterknife.OnClick;
import digua.rxlearn.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.create,
            R.id.defer,
            R.id.empty,
            R.id.from,
            R.id.interval,
            R.id.just,
            R.id.range,
            R.id.repeat,
            R.id.start,
            R.id.timer,
            R.id.buffer,
            R.id.flatmap,
            R.id.groupby,
            R.id.map,
            R.id.scan,
            R.id.window,
            R.id.debounce,
            R.id.distinct,
            R.id.elementat,
            R.id.filter,
            R.id.first,
            R.id.ignoreelements,
            R.id.last,
            R.id.sample,
            R.id.skip,
            R.id.skiplast,
            R.id.take,
            R.id.takelast,
            R.id.and,
            R.id.combinelatest,
            R.id.join,
            R.id.merge,
            R.id.startwith,
            R.id.switch_,
            R.id.zip,
            R.id.catch_,
            R.id.retry,
            R.id.delay,
            R.id.do_,
            R.id.m_d,
            R.id.observe_on,
            R.id.serialize,
            R.id.subscribe,
            R.id.subscribe_on,
            R.id.timeinterval,
            R.id.timeout,
            R.id.timestamp,
            R.id.using,
            R.id.all,
            R.id.amb,
            R.id.contains,
            R.id.defaultifempty,
            R.id.sequenceequal,
            R.id.skipuntil,
            R.id.skipwhile,
            R.id.takeuntil,
            R.id.takewhile,
            R.id.average,
            R.id.concat,
            R.id.count,
            R.id.max,
            R.id.min,
            R.id.reduce,
            R.id.sum,
            R.id.connect,
            R.id.publish,
            R.id.refcount,
            R.id.replay,
            R.id.to

    })
    public void clickEvent(View view) {
        switch (view.getId()) {
            //-------Creating Observables-----
            case R.id.create:
                jumpActivity(R.id.create);
                break;
            case R.id.defer:
                jumpActivity(R.id.defer);
                break;
            case R.id.empty:
                jumpActivity(R.id.empty);
                break;
            case R.id.from:
                jumpActivity(R.id.from);
                break;
            case R.id.interval:
                jumpActivity(R.id.interval);
                break;
            case R.id.just:
                jumpActivity(R.id.just);
                break;
            case R.id.range:
                jumpActivity(R.id.range);
                break;
            case R.id.repeat:
                jumpActivity(R.id.repeat);
                break;
            case R.id.start:
                jumpActivity(R.id.start);
                break;
            case R.id.timer:
                jumpActivity(R.id.timer);
                break;
            //-------Transforming Observables-----
            case R.id.buffer:
                jumpActivity(R.id.buffer);
                break;
            case R.id.flatmap:
                jumpActivity(R.id.flatmap);
                break;
            case R.id.groupby:
                jumpActivity(R.id.groupby);
                break;
            case R.id.map:
                jumpActivity(R.id.map);
                break;
            case R.id.scan:
                jumpActivity(R.id.scan);
                break;
            case R.id.window:
                jumpActivity(R.id.window);
                break;
            //-------Filtering Observables-----
            case R.id.debounce:
                jumpActivity(R.id.debounce);
                break;
            case R.id.distinct:
                jumpActivity(R.id.distinct);
                break;
            case R.id.elementat:
                jumpActivity(R.id.elementat);
                break;
            case R.id.filter:
                jumpActivity(R.id.filter);
                break;
            case R.id.first:
                jumpActivity(R.id.first);
                break;
            case R.id.ignoreelements:
                jumpActivity(R.id.ignoreelements);
                break;
            case R.id.last:
                jumpActivity(R.id.last);
                break;
            case R.id.sample:
                jumpActivity(R.id.sample);
                break;
            case R.id.skip:
                jumpActivity(R.id.skip);
                break;
            case R.id.skiplast:
                jumpActivity(R.id.skiplast);
                break;
            case R.id.take:
                jumpActivity(R.id.take);
                break;
            case R.id.takelast:
                jumpActivity(R.id.takelast);
                break;
            //-------Combining Observables-----
            case R.id.and:
                jumpActivity(R.id.and);
                break;
            case R.id.combinelatest:
                jumpActivity(R.id.combinelatest);
                break;
            case R.id.join:
                jumpActivity(R.id.join);
                break;
            case R.id.merge:
                jumpActivity(R.id.merge);
                break;
            case R.id.startwith:
                jumpActivity(R.id.startwith);
                break;
            case R.id.switch_:
                jumpActivity(R.id.switch_);
                break;
            case R.id.zip:
                jumpActivity(R.id.zip);
                break;
            //-------Error Handling Operators-----
            case R.id.catch_:
                jumpActivity(R.id.catch_);
                break;
            case R.id.retry:
                jumpActivity(R.id.retry);
                break;
            //-------Observable Utility Operators-----
            case R.id.delay:
                jumpActivity(R.id.delay);
                break;
            case R.id.do_:
                jumpActivity(R.id.do_);
                break;
            case R.id.m_d:
                jumpActivity(R.id.m_d);
                break;
            case R.id.observe_on:
                jumpActivity(R.id.observe_on);
                break;
            case R.id.serialize:
                jumpActivity(R.id.serialize);
                break;
            case R.id.subscribe:
                jumpActivity(R.id.subscribe);
                break;
            case R.id.subscribe_on:
                jumpActivity(R.id.subscribe_on);
                break;
            case R.id.timeinterval:
                jumpActivity(R.id.timeinterval);
                break;
            case R.id.timeout:
                jumpActivity(R.id.timeout);
                break;
            case R.id.timestamp:
                jumpActivity(R.id.timestamp);
                break;
            case R.id.using:
                jumpActivity(R.id.using);
                break;
            //-------Conditional and Boolean Operators-----
            case R.id.all:
                jumpActivity(R.id.all);
                break;
            case R.id.amb:
                jumpActivity(R.id.amb);
                break;
            case R.id.contains:
                jumpActivity(R.id.contains);
                break;
            case R.id.defaultifempty:
                jumpActivity(R.id.defaultifempty);
                break;
            case R.id.sequenceequal:
                jumpActivity(R.id.sequenceequal);
                break;
            case R.id.skipuntil:
                jumpActivity(R.id.skipuntil);
                break;
            case R.id.skipwhile:
                jumpActivity(R.id.skipwhile);
                break;
            case R.id.takeuntil:
                jumpActivity(R.id.takeuntil);
                break;
            case R.id.takewhile:
                jumpActivity(R.id.takewhile);
                break;
            //-------Mathematical and Aggregate Operators-----
            case R.id.average:
                jumpActivity(R.id.average);
                break;
            case R.id.concat:
                jumpActivity(R.id.concat);
                break;
            case R.id.count:
                jumpActivity(R.id.count);
                break;
            case R.id.max:
                jumpActivity(R.id.max);
                break;
            case R.id.min:
                jumpActivity(R.id.min);
                break;
            case R.id.reduce:
                jumpActivity(R.id.reduce);
                break;
            case R.id.sum:
                jumpActivity(R.id.sum);
                break;
            //-------Connectable Observable Operators-----
            case R.id.connect:
                jumpActivity(R.id.connect);
                break;
            case R.id.publish:
                jumpActivity(R.id.publish);
                break;
            case R.id.refcount:
                jumpActivity(R.id.refcount);
                break;
            case R.id.replay:
                jumpActivity(R.id.replay);
                break;
            //-------Operators to Convert Observables-----
            case R.id.to:
                jumpActivity(R.id.to);
                break;

        }
    }

    /**
     * 跳转页面
     */
    private void jumpActivity(int target) {
        Intent intent = new Intent(this, ContentActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("target", target);
        intent.putExtra("bundle", bundle);
        startActivity(intent);
    }


}
