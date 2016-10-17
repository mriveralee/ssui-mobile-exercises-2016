package com.mikeriv.ssui_2016.a3gameengine.event;



/**
 *
 */
public class AnimEndEvent extends XYEvent {

	public AnimEndEvent(float x, float y) {
		super(FSMEventType.ANIM_END, x,y);
	}

}
