package com.mikeriv.ssui_2016.networkactivitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mNetworkTestButton;
    TextView mNetworkDescText;

    private View.OnClickListener mNetworkTestButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v != mNetworkTestButton) {
                return;
            }
            openNetworkTestActivity();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNetworkDescText = (TextView) findViewById(R.id.text_network_descripton);
        mNetworkTestButton = (Button) findViewById(R.id.btn_network_test);
        if (mNetworkTestButton != null) {
            mNetworkTestButton.setOnClickListener(mNetworkTestButtonListener);
        }
    }

    private void openNetworkTestActivity() {
        // TODO use an intent to start the NetworkTestActicity
    }

}
