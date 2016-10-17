package com.mikeriv.ssui_2016.a3gameengine.eventmatch;


import com.mikeriv.ssui_2016.a3gameengine.event.ButtonPressedEvent;
import com.mikeriv.ssui_2016.a3gameengine.event.FSMEvent;
import com.mikeriv.ssui_2016.a3gameengine.event.FSMEventType;

/**
 *
 */
public class ButtonMatch extends TypeMatch {

	protected int mButtonToMatch = -1; /* matches nothing */
	public int getButtonToMatch() {return mButtonToMatch;}
	
	@Override
	public boolean match(FSMEvent evt) {
		if(evt != null && super.match(evt) && evt instanceof ButtonPressedEvent){
			ButtonPressedEvent bpe = (ButtonPressedEvent) evt;
			return bpe.getButtonNumber() == mButtonToMatch;
		}
		
		return false;
	}
	
	public ButtonMatch(int buttonToMatch) {
		super(FSMEventType.BUTTON_PRESSED);
		mButtonToMatch = buttonToMatch;
	}
	
	public ButtonMatch() {
		this(-1/* matches nothing */);
	}

}
