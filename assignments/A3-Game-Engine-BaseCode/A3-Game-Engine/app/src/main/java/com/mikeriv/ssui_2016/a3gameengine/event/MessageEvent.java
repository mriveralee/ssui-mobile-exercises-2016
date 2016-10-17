package com.mikeriv.ssui_2016.a3gameengine.event;


/**
 *
 */
public class MessageEvent extends FSMEvent {
	protected String mMessage = "";
	public String getMessage() {return mMessage;}
	
	public MessageEvent(String message) {
		super(FSMEventType.MESSAGE_ARRIVED);
		if (message == null) 
			message = "";
		mMessage = message;
	}
}
