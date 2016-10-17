package com.mikeriv.ssui_2016.a3gameengine.eventmatch;


import com.mikeriv.ssui_2016.a3gameengine.event.FSMEvent;
import com.mikeriv.ssui_2016.a3gameengine.event.FSMEventType;
import com.mikeriv.ssui_2016.a3gameengine.event.MessageEvent;

/**
 *
 */
public class MessageMatch extends TypeMatch {

	protected String mMessageToMatch = "";


	public String getMessageToMatch() {return mMessageToMatch;}
	
	@Override
	public boolean match(FSMEvent evt) {
		return super.match(evt) && evt instanceof MessageEvent &&
		((MessageEvent)evt).getMessage().equals(getMessageToMatch());
	}
	
	public MessageMatch(String msg) {
		super(FSMEventType.MESSAGE_ARRIVED);
		if (msg == null) msg="";
		mMessageToMatch = msg;
	}

}
