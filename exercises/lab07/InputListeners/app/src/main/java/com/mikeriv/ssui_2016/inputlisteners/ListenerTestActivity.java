package com.mikeriv.ssui_2016.inputlisteners;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class ListenerTestActivity extends AppCompatActivity {

    private ImageView mPupperImageView;
    private TextView mPetsCountTextView;
    private int mPettingCount = 0;
    private Toast mLongPressToast;

    private final View.OnClickListener mPetClickListener =  new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPettingCount += 1;
            refreshPetsCountText();
        }
    };

    private final View.OnLongClickListener mLongPetClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            if (v != mPupperImageView) {
                return false;
            }
            showLongPressToast();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener_test);

        mPupperImageView = (ImageView) findViewById(R.id.img_pupper);
        if (mPupperImageView != null) {
            mPupperImageView.setOnClickListener(mPetClickListener);
            mPupperImageView.setOnLongClickListener(mLongPetClickListener);
        }

        mPetsCountTextView = (TextView) findViewById(R.id.text_pets);
        refreshPetsCountText();
    }


    private void refreshPetsCountText() {
        if (mPetsCountTextView == null) {
            return;
        }
        mPetsCountTextView.setText(getString(R.string.label_petting_count, mPettingCount));
    }

    private void showLongPressToast() {
        if (mLongPressToast == null) {
            mLongPressToast = Toast.makeText(
                    this,
                    getString(R.string.label_long_press),
                    Toast.LENGTH_SHORT);
        }
        // Cancel any previously showing events
        // mLongPressToast.cancel();
        // Show the new event
        mLongPressToast.show();
    }

}
