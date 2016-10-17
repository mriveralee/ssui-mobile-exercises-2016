package com.mikeriv.ssui_2016.a3gameengine.event;



/**
 *
 */
public class TouchPressEvent extends XYEvent {

	/**
	 * @param x
	 * @param y
	 */
	public TouchPressEvent(float x, float y) {
		super(FSMEventType.TOUCH_PRESS, x, y);
	}

}
