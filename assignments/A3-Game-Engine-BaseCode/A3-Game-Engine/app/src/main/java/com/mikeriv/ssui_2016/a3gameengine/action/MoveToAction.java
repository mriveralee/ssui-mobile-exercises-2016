package com.mikeriv.ssui_2016.a3gameengine.action;


/**
 *
 */
public class MoveToAction extends XYAction {
	/**
	 * @param x
	 * @param y
	 */
	public MoveToAction(float x, float y) {
		super(FSMActionType.MOVE_TO, x, y);
	}

}
