package com.mikeriv.ssui_2016.a3gameengine.event;



/**

 *
 */
public class DragMoveEvent extends XYEvent {
	/**
	 * @param x
	 * @param y
	 */
	public DragMoveEvent(float x, float y) {
		super(FSMEventType.DRAG_MOVE, x, y);
	}
}
