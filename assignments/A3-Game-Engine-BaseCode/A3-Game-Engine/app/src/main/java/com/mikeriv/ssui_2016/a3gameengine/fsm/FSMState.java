package com.mikeriv.ssui_2016.a3gameengine.fsm;

/**
 * This class holds information that describes a single finite state machine
 * state.
 *
 */
public class FSMState {
	protected int mStateNum = 0;
	protected String mName = "$UNNAMED$";
	protected FSMTransition[] mTransitions = null;


	public FSMState(int stNum, String stName, FSMTransition[] trans) {
		mStateNum = stNum;
		if (stName != null) mName = stName;
		mTransitions = trans;
	}

	public int getStateNum() {return mStateNum;}

	public FSMTransition[] getTransitions() {return mTransitions;}


	public boolean isStartState() {return mStateNum == 0;}
	
	public String getName() {return mName;}
	
	public FSMTransition getTransitionAt(int indx) {
		if (mTransitions == null || indx < 0 || indx >= mTransitions.length)
			throw new IndexOutOfBoundsException("Index of " + indx + 
					" passed to FSMState.getTransitionAt() is out of bounds");
		return mTransitions[indx];
	}


}