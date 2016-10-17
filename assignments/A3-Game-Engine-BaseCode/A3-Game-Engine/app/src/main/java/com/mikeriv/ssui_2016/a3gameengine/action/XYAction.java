package com.mikeriv.ssui_2016.a3gameengine.action;


/**
 *
 */
public abstract class XYAction extends FSMAction {
	protected float mX = 0.0f;
	public float getX() {return mX;}
	
	protected float mY = 0.0f;
	public float getY() {return mY;}
	
	/**
	 */
	public XYAction(int type, float x, float y) {
		super(type);
		mX = x;
		mY = y;
	}

}
