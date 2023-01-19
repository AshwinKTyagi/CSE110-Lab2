package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {

    @Test
    public void test_one_plus_one_equals_two() {
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {
            Button but_1 = (Button)activity.findViewById(R.id.btn_one);
            Button but_plus = (Button)activity.findViewById(R.id.btn_plus);
            Button but_eq = (Button)activity.findViewById(R.id.btn_equals);
            TextView display = (TextView)activity.findViewById(R.id.display);

            but_1.performClick();
            but_plus.performClick();
            but_1.performClick();
            but_eq.performClick();

            assertEquals(display.getText(), "2");
        });
    }

}
