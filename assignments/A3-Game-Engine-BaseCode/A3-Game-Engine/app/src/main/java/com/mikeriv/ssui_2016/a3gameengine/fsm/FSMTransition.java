package com.mikeriv.ssui_2016.a3gameengine.fsm;

import com.mikeriv.ssui_2016.a3gameengine.action.FSMAction;
import com.mikeriv.ssui_2016.a3gameengine.event.FSMEvent;
import com.mikeriv.ssui_2016.a3gameengine.eventmatch.FSMEventMatcher;

/**
 * This class holds information describing one transition in a finite state
 * machine.
 *
 */
public class FSMTransition {

	protected FSMEventMatcher mMatcher = null;
	protected FSMAction[] mActions = null;
	protected int mTargetState = 0;

	public FSMTransition(
			FSMEventMatcher matcher,
			FSMAction[] act,
			int targetSt) {
		mMatcher = matcher;
		mActions = act;
		mTargetState = targetSt;
	}

	public boolean match(FSMEvent evt) {
		return mMatcher != null && mMatcher.match(evt);
	}
	
	public FSMAction[] getAction() {return mActions;}
	
	public int getTargetState() {return mTargetState;}

}
