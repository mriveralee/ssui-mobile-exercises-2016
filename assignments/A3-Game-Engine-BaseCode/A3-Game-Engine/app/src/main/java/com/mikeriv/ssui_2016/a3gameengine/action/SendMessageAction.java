package com.mikeriv.ssui_2016.a3gameengine.action;


/**
 *
 */
public class SendMessageAction extends StringAction {

	protected int mTargetCharacter = -1;
	public int getTargetCharacter() {return mTargetCharacter;}
	
	/**
	 * @param message
	 */
	public SendMessageAction(int targetCharacter, String message) {
		super(FSMActionType.SEND_MESSAGE, message);
		mTargetCharacter = targetCharacter;
	}

}
