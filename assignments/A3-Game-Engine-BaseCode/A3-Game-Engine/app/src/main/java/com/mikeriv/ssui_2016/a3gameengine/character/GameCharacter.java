package com.mikeriv.ssui_2016.a3gameengine.character;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.mikeriv.ssui_2016.a3gameengine.engine.GameEnginePreBase;
import com.mikeriv.ssui_2016.a3gameengine.event.FSMEvent;

public interface GameCharacter {

	public static final int START_STATE = 0;

	public GameEnginePreBase getOwner();

	public int getCharacterIndex();

	public float getX();

	public void setX(float xv);

	public float getY();

	public void setY(float yv);

	public float getW();

	public void setW(float wv);

	public float getH();

	public void setH(float hv);

	public Bitmap getImage();

	public void setImage(Bitmap newImage);

	public int getCurrentState();

	public void resetState();

	// returns true if event was "consumed" (acted upon)
	public boolean deliverEvent(FSMEvent event);

	public void draw(Canvas canv);
	//xx local coordinates will have been set up prior to calling this 
	//   method, so the top left will be at 0,0 (not x,y)
}
