package com.mikeriv.ssui_2016.activityfun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Views
    private Button mButton;
    private TextView mTapCountView;

    //Models
    private int mButtonTapCount = 0;


    private final View.OnClickListener mClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            if (view == mButton) {
                mButtonTapCount += 1;
            }
            updateTapButtonCount();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.btn_tap_count);
        mButton.setOnClickListener(mClickListener);


        mTapCountView = (TextView) findViewById(R.id.text_tap_counter);


        updateTapButtonCount();
    }





    private void updateTapButtonCount() {
        if (mTapCountView == null) {
            return;
        }

        mTapCountView.setText(getString(R.string.tap_count, mButtonTapCount));
    }


}
