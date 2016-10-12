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

    // TODO implement onclick listener
    private final View.OnClickListener mPetClickListener =  null;

    // TODO implement long click listener
    private final View.OnLongClickListener mLongPetClickListener = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener_test);

        mPetsCountTextView = (TextView) findViewById(R.id.text_pets);
        mPupperImageView = (ImageView) findViewById(R.id.img_pupper);
        // TODO set up images

        refreshPetsCountText();
    }


    private void refreshPetsCountText() {
        // TODO
    }

    private void showLongPressToast() {
        // TODO
    }

}
