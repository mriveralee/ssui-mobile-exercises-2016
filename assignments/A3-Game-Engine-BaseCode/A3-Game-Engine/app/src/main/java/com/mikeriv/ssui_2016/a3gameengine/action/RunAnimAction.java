package com.mikeriv.ssui_2016.a3gameengine.action;


/**
 */
public class RunAnimAction extends FSMAction {
	protected int mMovingCharacter = -1;
	public int getMovingCharacter() {return mMovingCharacter;}
	
	protected int mTargetCharacter = -1;
	public int getTargetCharacter() {return mTargetCharacter;}
	
	protected float mTargetOffsetX = 0.0f;
	public float getTargetOffsetX() {return mTargetOffsetX;}
	
	protected float mTargetOffsetY = 0.0f;
	public float getTargetOffsetY() {return mTargetOffsetY;}
	
	protected int mAnimDurationMSec = 0;
	public int getAnimDurationMSec() {return mAnimDurationMSec;}
	
	protected String mEndMessage = "";
	public String getEndMessage() {return mEndMessage;}
	
	protected String mPassOverMessage = "";
	public String getPassOverMessage() {return mPassOverMessage;}
	
	/**
	 */
	public RunAnimAction(
			int movingCharacter, 
			int targetCharacter, 
			int duration, 
			float targetOffsetX,
			float targetOffsetY,
			String endMessage,
			String passOverMessage) 
	{
		super(FSMActionType.RUN_ANIM);
		mMovingCharacter = movingCharacter;
		mTargetCharacter = targetCharacter;
		mTargetOffsetX = targetOffsetX;
		mTargetOffsetY = targetOffsetY;
		mAnimDurationMSec = duration;
		mEndMessage = endMessage;
		mPassOverMessage = passOverMessage;
	}

}
