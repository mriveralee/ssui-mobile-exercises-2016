package com.mikeriv.ssui_2016.a3gameengine.event;


/**

 *
 */
public class ButtonPressedEvent extends FSMEvent {

	protected int mButtonNumber = -1;
	public int getButtonNumber() {return mButtonNumber;}
	
	/**
	 * 
	 */
	public ButtonPressedEvent(int whichButton) {
		super(FSMEventType.BUTTON_PRESSED);
		mButtonNumber = whichButton;
	}
}
