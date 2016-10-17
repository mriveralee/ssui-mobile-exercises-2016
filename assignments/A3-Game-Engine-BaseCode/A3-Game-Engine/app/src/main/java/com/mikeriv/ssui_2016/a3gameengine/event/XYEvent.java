package com.mikeriv.ssui_2016.a3gameengine.event;


/**
 *
 */
public abstract class XYEvent extends FSMEvent {

	protected float mX = 0;
	protected float mY = 0;

	public float getX() {return mX;}
	
	public float getY() {return mY;}
	
	public void offset(float dx, float dy) {
		mX += dx;
		mY += dy;
	}

	public XYEvent(int evtType, float x, float y) {
		super(evtType);
		mX = x;
		mY = y;
	}
}
