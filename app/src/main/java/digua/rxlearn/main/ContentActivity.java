package digua.rxlearn.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import digua.rxlearn.R;
import digua.rxlearn.fragment.a_Creating_Observables.A10_Fragment;
import digua.rxlearn.fragment.a_Creating_Observables.A1_Fragment;
import digua.rxlearn.fragment.a_Creating_Observables.A2_Fragment;
import digua.rxlearn.fragment.a_Creating_Observables.A3_Fragment;
import digua.rxlearn.fragment.a_Creating_Observables.A4_Fragment;
import digua.rxlearn.fragment.a_Creating_Observables.A5_Fragment;
import digua.rxlearn.fragment.a_Creating_Observables.A6_Fragment;
import digua.rxlearn.fragment.a_Creating_Observables.A7_Fragment;
import digua.rxlearn.fragment.a_Creating_Observables.A8_Fragment;
import digua.rxlearn.fragment.a_Creating_Observables.A9_Fragment;
import digua.rxlearn.fragment.b_Transforming_Observables.B1_Fragment;
import digua.rxlearn.fragment.b_Transforming_Observables.B2_Fragment;
import digua.rxlearn.fragment.b_Transforming_Observables.B3_Fragment;
import digua.rxlearn.fragment.b_Transforming_Observables.B4_Fragment;
import digua.rxlearn.fragment.b_Transforming_Observables.B5_Fragment;
import digua.rxlearn.fragment.b_Transforming_Observables.B6_Fragment;
import digua.rxlearn.fragment.c_Filtering_Observables.C10_Fragment;
import digua.rxlearn.fragment.c_Filtering_Observables.C11_Fragment;
import digua.rxlearn.fragment.c_Filtering_Observables.C12_Fragment;
import digua.rxlearn.fragment.c_Filtering_Observables.C1_Fragment;
import digua.rxlearn.fragment.c_Filtering_Observables.C2_Fragment;
import digua.rxlearn.fragment.c_Filtering_Observables.C3_Fragment;
import digua.rxlearn.fragment.c_Filtering_Observables.C4_Fragment;
import digua.rxlearn.fragment.c_Filtering_Observables.C5_Fragment;
import digua.rxlearn.fragment.c_Filtering_Observables.C6_Fragment;
import digua.rxlearn.fragment.c_Filtering_Observables.C7_Fragment;
import digua.rxlearn.fragment.c_Filtering_Observables.C8_Fragment;
import digua.rxlearn.fragment.c_Filtering_Observables.C9_Fragment;
import digua.rxlearn.fragment.d_Combining_Observables.D1_Fragment;
import digua.rxlearn.fragment.d_Combining_Observables.D2_Fragment;
import digua.rxlearn.fragment.d_Combining_Observables.D3_Fragment;
import digua.rxlearn.fragment.d_Combining_Observables.D4_Fragment;
import digua.rxlearn.fragment.d_Combining_Observables.D5_Fragment;
import digua.rxlearn.fragment.d_Combining_Observables.D6_Fragment;
import digua.rxlearn.fragment.d_Combining_Observables.D7_Fragment;
import digua.rxlearn.fragment.e_Error_Handling_Operators.E1_Fragment;
import digua.rxlearn.fragment.e_Error_Handling_Operators.E2_Fragment;
import digua.rxlearn.fragment.f_Observable_Utility_Operators.F10_Fragment;
import digua.rxlearn.fragment.f_Observable_Utility_Operators.F11_Fragment;
import digua.rxlearn.fragment.f_Observable_Utility_Operators.F1_Fragment;
import digua.rxlearn.fragment.f_Observable_Utility_Operators.F2_Fragment;
import digua.rxlearn.fragment.f_Observable_Utility_Operators.F3_Fragment;
import digua.rxlearn.fragment.f_Observable_Utility_Operators.F4_Fragment;
import digua.rxlearn.fragment.f_Observable_Utility_Operators.F5_Fragment;
import digua.rxlearn.fragment.f_Observable_Utility_Operators.F6_Fragment;
import digua.rxlearn.fragment.f_Observable_Utility_Operators.F7_Fragment;
import digua.rxlearn.fragment.f_Observable_Utility_Operators.F8_Fragment;
import digua.rxlearn.fragment.f_Observable_Utility_Operators.F9_Fragment;
import digua.rxlearn.fragment.g_Conditional_and_Boolean_Operators.G1_Fragment;
import digua.rxlearn.fragment.g_Conditional_and_Boolean_Operators.G2_Fragment;
import digua.rxlearn.fragment.g_Conditional_and_Boolean_Operators.G3_Fragment;
import digua.rxlearn.fragment.g_Conditional_and_Boolean_Operators.G4_Fragment;
import digua.rxlearn.fragment.g_Conditional_and_Boolean_Operators.G5_Fragment;
import digua.rxlearn.fragment.g_Conditional_and_Boolean_Operators.G6_Fragment;
import digua.rxlearn.fragment.g_Conditional_and_Boolean_Operators.G7_Fragment;
import digua.rxlearn.fragment.g_Conditional_and_Boolean_Operators.G8_Fragment;
import digua.rxlearn.fragment.g_Conditional_and_Boolean_Operators.G9_Fragment;
import digua.rxlearn.fragment.h_Mathematical_and_Aggregate_Operators.H1_Fragment;
import digua.rxlearn.fragment.h_Mathematical_and_Aggregate_Operators.H2_Fragment;
import digua.rxlearn.fragment.h_Mathematical_and_Aggregate_Operators.H3_Fragment;
import digua.rxlearn.fragment.h_Mathematical_and_Aggregate_Operators.H4_Fragment;
import digua.rxlearn.fragment.h_Mathematical_and_Aggregate_Operators.H5_Fragment;
import digua.rxlearn.fragment.h_Mathematical_and_Aggregate_Operators.H6_Fragment;
import digua.rxlearn.fragment.h_Mathematical_and_Aggregate_Operators.H7_Fragment;
import digua.rxlearn.fragment.i_Connectable_Observable_Operators.I1_Fragment;
import digua.rxlearn.fragment.i_Connectable_Observable_Operators.I2_Fragment;
import digua.rxlearn.fragment.i_Connectable_Observable_Operators.I3_Fragment;
import digua.rxlearn.fragment.i_Connectable_Observable_Operators.I4_Fragment;
import digua.rxlearn.fragment.j_Operators_to_Convert_Observables.J1_Fragment;

/**
 * @author digua
 *         <p>
 *         on 2017/2/7.(^ ^)
 */

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        int target = getIntent().getBundleExtra("bundle").getInt("target");
        changePage(target);
    }

    /**
     * 切换页面
     */
    private void changePage(int target) {
        switch (target) {
            //-------Creating Observables-----
            case R.id.create:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new A1_Fragment()).commit();
                break;
            case R.id.defer:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new A2_Fragment()).commit();
                break;
            case R.id.empty:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new A3_Fragment()).commit();
                break;
            case R.id.from:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new A4_Fragment()).commit();
                break;
            case R.id.interval:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new A5_Fragment()).commit();
                break;
            case R.id.just:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new A6_Fragment()).commit();
                break;
            case R.id.range:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new A7_Fragment()).commit();
                break;
            case R.id.repeat:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new A8_Fragment()).commit();
                break;
            case R.id.start:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new A9_Fragment()).commit();
                break;
            case R.id.timer:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new A10_Fragment()).commit();
                break;
            //-------Transforming Observables-----
            case R.id.buffer:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new B1_Fragment()).commit();
                break;
            case R.id.flatmap:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new B2_Fragment()).commit();
                break;
            case R.id.groupby:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new B3_Fragment()).commit();
                break;
            case R.id.map:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new B4_Fragment()).commit();
                break;
            case R.id.scan:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new B5_Fragment()).commit();
                break;
            case R.id.window:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new B6_Fragment()).commit();
                break;
            //-------Filtering Observables-----
            case R.id.debounce:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new C1_Fragment()).commit();
                break;
            case R.id.distinct:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new C2_Fragment()).commit();
                break;
            case R.id.elementat:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new C3_Fragment()).commit();
                break;
            case R.id.filter:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new C4_Fragment()).commit();
                break;
            case R.id.first:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new C5_Fragment()).commit();
                break;
            case R.id.ignoreelements:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new C6_Fragment()).commit();
                break;
            case R.id.last:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new C7_Fragment()).commit();
                break;
            case R.id.sample:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new C8_Fragment()).commit();
                break;
            case R.id.skip:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new C9_Fragment()).commit();
                break;
            case R.id.skiplast:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new C10_Fragment()).commit();
                break;
            case R.id.take:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new C11_Fragment()).commit();
                break;
            case R.id.takelast:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new C12_Fragment()).commit();
                break;
            //-------Combining Observables-----
            case R.id.and:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new D1_Fragment()).commit();
                break;
            case R.id.combinelatest:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new D2_Fragment()).commit();
                break;
            case R.id.join:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new D3_Fragment()).commit();
                break;
            case R.id.merge:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new D4_Fragment()).commit();
                break;
            case R.id.startwith:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new D5_Fragment()).commit();
                break;
            case R.id.switch_:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new D6_Fragment()).commit();
                break;
            case R.id.zip:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new D7_Fragment()).commit();
                break;
            //-------Error Handling Operators-----
            case R.id.catch_:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new E1_Fragment()).commit();
                break;
            case R.id.retry:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new E2_Fragment()).commit();
                break;
            //-------Observable Utility Operators-----
            case R.id.delay:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new F1_Fragment()).commit();
                break;
            case R.id.do_:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new F2_Fragment()).commit();
                break;
            case R.id.m_d:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new F3_Fragment()).commit();
                break;
            case R.id.observe_on:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new F4_Fragment()).commit();
                break;
            case R.id.serialize:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new F5_Fragment()).commit();
                break;
            case R.id.subscribe:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new F6_Fragment()).commit();
                break;
            case R.id.subscribe_on:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new F7_Fragment()).commit();
                break;
            case R.id.timeinterval:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new F8_Fragment()).commit();
                break;
            case R.id.timeout:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new F9_Fragment()).commit();
                break;
            case R.id.timestamp:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new F10_Fragment()).commit();
                break;
            case R.id.using:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new F11_Fragment()).commit();
                break;
            //-------Conditional and Boolean Operators-----
            case R.id.all:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new G1_Fragment()).commit();
                break;
            case R.id.amb:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new G2_Fragment()).commit();
                break;
            case R.id.contains:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new G3_Fragment()).commit();
                break;

            case R.id.defaultifempty:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new G4_Fragment()).commit();
                break;
            case R.id.sequenceequal:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new G5_Fragment()).commit();
                break;
            case R.id.skipuntil:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new G6_Fragment()).commit();
                break;
            case R.id.skipwhile:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new G7_Fragment()).commit();
                break;
            case R.id.takeuntil:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new G8_Fragment()).commit();
                break;
            case R.id.takewhile:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new G9_Fragment()).commit();
                break;
            //-------Mathematical and Aggregate Operators-----
            case R.id.average:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new H1_Fragment()).commit();
                break;
            case R.id.concat:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new H2_Fragment()).commit();
                break;
            case R.id.count:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new H3_Fragment()).commit();
                break;
            case R.id.max:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new H4_Fragment()).commit();
                break;
            case R.id.min:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new H5_Fragment()).commit();
                break;
            case R.id.reduce:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new H6_Fragment()).commit();
                break;
            case R.id.sum:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new H7_Fragment()).commit();
                break;
            //-------Connectable Observable Operators-----
            case R.id.connect:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new I1_Fragment()).commit();
                break;
            case R.id.publish:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new I2_Fragment()).commit();
                break;
            case R.id.refcount:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new I3_Fragment()).commit();
                break;
            case R.id.replay:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new I4_Fragment()).commit();
                break;
            //-------Operators to Convert Observables-----
            case R.id.to:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment, new J1_Fragment()).commit();
                break;


        }
    }

}
