
package com.mikeriv.ssui_2016.a3gameengine.action;

/**
 * 
 *
 */
public abstract class FSMAction {
	protected int mType = FSMActionType.NO_ACTION;
	public int getType() {return mType;}
	
	public FSMAction(int typ) {
		mType = typ;
	}
	
	public FSMAction(){
		this(FSMActionType.NO_ACTION);
	}
}
