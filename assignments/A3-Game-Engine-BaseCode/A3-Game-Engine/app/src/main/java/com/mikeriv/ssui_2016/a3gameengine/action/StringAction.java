package com.mikeriv.ssui_2016.a3gameengine.action;


public abstract class StringAction extends FSMAction {
	protected String mMessage = "";
	public String getMessage() {return mMessage;}
	
	public StringAction(int type, String message) {
		super(type);
		if (message == null) message = "";
		mMessage = message;
	}
}
