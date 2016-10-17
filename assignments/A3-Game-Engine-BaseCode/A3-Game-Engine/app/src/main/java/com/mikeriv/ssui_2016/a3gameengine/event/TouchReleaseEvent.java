package com.mikeriv.ssui_2016.a3gameengine.event;



/**
 *
 */
public class TouchReleaseEvent extends XYEvent {
	/**
	 * @param x
	 * @param y
	 */
	public TouchReleaseEvent(float x, float y) {
		super(FSMEventType.TOUCH_RELEASE, x, y);
	}
}
