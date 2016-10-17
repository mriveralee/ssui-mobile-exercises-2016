package com.mikeriv.ssui_2016.a3gameengine.event;



/**
 *
 */
public class AnimMoveEvent extends XYEvent {

	public AnimMoveEvent(float x, float y) {
		super(FSMEventType.ANIM_MOVE, x,y);
	}

}
