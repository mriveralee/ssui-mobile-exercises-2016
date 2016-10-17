package com.mikeriv.ssui_2016.a3gameengine.action;

import java.util.HashMap;

/**
 *
 */
public class FSMActionType {
	public static final int NO_ACTION             = 0;
	public static final int CHANGE_IMAGE          = 1;
	public static final int MOVE_TO               = 2;
	public static final int MOVE_INC              = 3;
	public static final int FOLLOW_EVENT_POSITION = 4;
	public static final int RUN_ANIM              = 5;
	public static final int GET_DRAG_FOCUS        = 6;
	public static final int DROP_DRAG_FOCUS       = 7;
	public static final int SEND_MESSAGE          = 8;
	public static final int DEBUG_MESSAGE         = 9;
	
	protected static String[] mTypeNames = {
		"NO_ACTION", "CHANGE_IMAGE", 
		"MOVE_TO", "MOVE_INC", "FOLLOW_EVENT_POSITION", 
		"RUN_ANIM", "GET_DRAG_FOCUS", "DROP_DRAG_FOCUS",
		"SEND_MESSAGE", "DEBUG_MESSAGE" };
	
	protected static HashMap<String, Integer> mNameDict =
		new HashMap<String, Integer>(mTypeNames.length);
	
	static { 
		for (int i = 0; i< mTypeNames.length; i++) {
			mNameDict.put(mTypeNames[i], i);
		}
	}
	
	public static int indexFromName(String typeName) {
		if (typeName == null) return -1;
		Integer result = mNameDict.get(typeName);
		if (result == null) return -1;
		return result;
	}
	
	public static String nameFromIndex(int indx) {
		if (!isValid(indx)) return null;
		else return mTypeNames[indx];
	}
	
	public static boolean isValid(int indx) {
		return indx < 0 || indx >= mTypeNames.length;
	} 
}
