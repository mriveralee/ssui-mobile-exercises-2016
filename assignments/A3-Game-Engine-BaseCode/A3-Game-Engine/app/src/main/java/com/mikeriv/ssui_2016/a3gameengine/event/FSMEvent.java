package com.mikeriv.ssui_2016.a3gameengine.event;


/**
 *
 */
public class FSMEvent implements Cloneable {

	protected int mType = FSMEventType.NO_EVENT;

	public FSMEvent(int typ) {
		mType = typ;
	}


	public int getType() {return mType;}

	public FSMEvent copy() {
		try {
			return (FSMEvent)clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
