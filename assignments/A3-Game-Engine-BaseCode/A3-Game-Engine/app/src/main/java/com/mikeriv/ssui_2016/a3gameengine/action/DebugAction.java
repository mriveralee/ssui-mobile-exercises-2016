package com.mikeriv.ssui_2016.a3gameengine.action;


/**
 * 
 *
 */
public class DebugAction extends StringAction {
	
	public DebugAction(String message) {
		super(FSMActionType.DEBUG_MESSAGE, message);
		if (message == null) message = "";
		mMessage = message;
	}
	
	/**
	 * 
	 */
	public DebugAction() {
		this("Ping...");
	}

}
