package com.mikeriv.ssui_2016.a3gameengine.character;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.mikeriv.ssui_2016.a3gameengine.engine.GameEnginePreBase;
import com.mikeriv.ssui_2016.a3gameengine.event.FSMEvent;
import com.mikeriv.ssui_2016.a3gameengine.fsm.FSMState;
import com.mikeriv.ssui_2016.a3gameengine.fsm.FSMTransition;

public class GameCharacterBase extends GameCharacterPreBase {

    public GameCharacterBase(
            GameEnginePreBase owner,
            int index,
            int x, int y,
            int w, int h,
            FSMState[] states,
            Bitmap img) {

    }

	@Override
	public boolean deliverEvent(FSMEvent event) {
		return false;
	}

	@Override
	protected void makeFSMTransition(FSMTransition transition, FSMEvent evt) {
		
	}

	@Override
	public void draw(Canvas canv) {
		
	}

}
