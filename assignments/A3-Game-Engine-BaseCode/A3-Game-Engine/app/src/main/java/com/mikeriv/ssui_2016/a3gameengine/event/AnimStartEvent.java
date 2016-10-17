package com.mikeriv.ssui_2016.a3gameengine.event;



/**
 *
 */
public class AnimStartEvent extends XYEvent {
	
	/**
	 */
	public AnimStartEvent(float x, float y) {
		super(FSMEventType.ANIM_START, x,y);
	}

}
