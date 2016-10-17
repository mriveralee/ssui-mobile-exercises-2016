package com.mikeriv.ssui_2016.a3gameengine.event;



/**
 *
 */
public class TouchMoveEvent extends XYEvent {

	/**
	 * @param x
	 * @param y
	 */
	public TouchMoveEvent(float x, float y) {
		super(FSMEventType.TOUCH_MOVE, x, y);
	}
}
