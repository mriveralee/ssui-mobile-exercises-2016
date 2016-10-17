package com.mikeriv.ssui_2016.a3gameengine.eventmatch;


import com.mikeriv.ssui_2016.a3gameengine.event.FSMEvent;

/**
 *
 */
public class TypeMatch implements FSMEventMatcher {

	protected int mTypeToMatch = -1/* matches nothing */;
	public int getTypeToMatch() {return mTypeToMatch;}
	
	@Override
	public boolean match(FSMEvent evt) {
		return evt != null && evt.getType() == mTypeToMatch;
	}
	
	public TypeMatch(int typeToMatch) {
		mTypeToMatch = typeToMatch;
	}
	
	public TypeMatch() {
		this(-1/* matches nothing */);
	}

}
