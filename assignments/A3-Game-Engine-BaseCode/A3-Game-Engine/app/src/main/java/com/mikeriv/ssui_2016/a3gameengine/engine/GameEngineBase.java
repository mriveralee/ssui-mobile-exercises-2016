package com.mikeriv.ssui_2016.a3gameengine.engine;


import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;

import com.mikeriv.ssui_2016.a3gameengine.character.GameCharacter;
import com.mikeriv.ssui_2016.a3gameengine.event.FSMEvent;
import com.mikeriv.ssui_2016.a3gameengine.event.XYEvent;

public class GameEngineBase extends GameEnginePreBase {

	public GameEngineBase(int xmlFileID, Context ctx){
		super(xmlFileID, ctx);
		sendInitMessages();
	}

	@Override
	protected List<GameCharacter> charactersUnder(RectF area) {
		return null;
	}


	@Override
	protected boolean dispatchPositionally(XYEvent evt) {
		return false;
	}

	@Override
	protected boolean dispatchPositionally(RectF inArea, FSMEvent evt) {
		return false;
	}

	@Override
	protected boolean dispatchDirect(int toChar, FSMEvent evt) {
		return false;
	}

	@Override
	protected boolean dispatchToAll(FSMEvent evt) {
		return false;
	}

	@Override
	protected boolean dispatchTryAll(FSMEvent evt) {
		return false;
	}


	@Override
	protected boolean dispatchDragFocus(FSMEvent evt) {
		return false;
	}

	@Override
	protected void onDraw(Canvas canv) {

	}

	@Override
	protected void buttonHit(int buttonNum) {

	}

	@Override
	public boolean onTouchEvent(MotionEvent evt) {
		// Skeleton code provided below. Your job is to
		// implement the empty code blocks in the if/else
		// tree. Hint: you need to dispatch the correct
		// event using one of the dispatch methods you
		// implemented above, and by instantiating the
		// appropriate FSMEvent (e.g., TouchReleaseEvent).

		/*float x = evt.getX();
		float y = evt.getY();

		if (evt.getAction() == MotionEvent.ACTION_DOWN) {


		} else if (evt.getAction() == MotionEvent.ACTION_MOVE) {


		} else if (evt.getAction() == MotionEvent.ACTION_UP) {

		} else {
			// not an event we understand...
			return false;
		}*/
		return false;
	}
}
