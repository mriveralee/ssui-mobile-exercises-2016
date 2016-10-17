package com.mikeriv.ssui_2016.a3gameengine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mikeriv.ssui_2016.a3gameengine.engine.GameEngineBase;

public class MainGameEngineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameEngineBase gb = new GameEngineBase(R.raw.basic_fsmspec, this);
        setContentView(gb.finalInit());
    }
}
