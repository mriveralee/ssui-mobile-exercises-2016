
package com.mikeriv.ssui_2016.a3gameengine;

/**
 * This class holds all of the information about a particular animation that is 
 * occurring in the system.
 */
public class AnimationRecord {
	protected int mCharacterToMove = 0;
	public int getCharacterToMove() {return mCharacterToMove;}
	public void setCharacterToMove(int ch) {mCharacterToMove = ch;}
	
	protected int mCharacterToNotify = 0;
	public int getCharacterToNotify() {return mCharacterToNotify;}
	public void setCharacterToNotify(int ch) {mCharacterToNotify = ch;}
	
	protected String mNotifyMessage = "";
	public String getNotifyMessage() {return mNotifyMessage;}
	public void getNotifyMessage(String msg) {mNotifyMessage = msg;}
	
	protected String mPassOverMessage = "";
	public String getPassOverMessage() {return mPassOverMessage;}
	public void getPassOverMessage(String msg) {mPassOverMessage = msg;}
	
	protected float mCurrentX = 0;
	public float getCurrentX() {return mCurrentX;}
	public void setCurrentX(float x) {mCurrentX = x;}
	
	protected float mCurrentY = 0;
	public float getCurrentY() {return mCurrentY;}
	public void setCurrentY(float y) {mCurrentY = y;}
	
	protected float mVelocityX = 0; // in pixels per msec
	public float getXVelocity() {return mVelocityX;}
	public void setXVelocity(float xv) {mVelocityX = xv;}
	
	protected float mVelocityY = 0;
	public float getYVelocity() {return mVelocityY;}
	public void setYVelocity(float yv) {mVelocityY = yv;}
	
	protected int   mMSecondsLeft = 0;
	public int getMSecLeft() {return mMSecondsLeft;}
	public void setMSecLeft(int msec) {
		if (msec < 0) msec = 0;
		mMSecondsLeft = msec;
	}
	
	public boolean advanceMSec(int numMSec) {
		
		// don't advance if we are already done
		if (mMSecondsLeft == 0) return true;
		
		// don't go past the end time
		if (numMSec > mMSecondsLeft) numMSec = mMSecondsLeft;
		
		// move the point
		mCurrentX += mVelocityX*(float)numMSec;
		mCurrentY += mVelocityY*(float)numMSec;
		
		// count off the time and return whether we are done
		mMSecondsLeft -= numMSec;
		if (mMSecondsLeft < 0) mMSecondsLeft = 0;
		return mMSecondsLeft == 0;
	}
	
	public AnimationRecord(
			int charToMove, int charToNotif,
			String notifMsg,
			String passOverMsg,
			float startX, float startY,
			float endX, float endY,
			int durationMSec) 
	{
		mCurrentX = startX; 
		mCurrentY = startY;
		if (durationMSec < 0) durationMSec = 0;
		mMSecondsLeft = durationMSec;
		if (mMSecondsLeft == 0) {
			mVelocityX = mVelocityY = 0;
		} else {
			mVelocityX = (endX-startX)/(float)durationMSec;
			mVelocityY = (endY-startY)/(float)durationMSec;
		}
		mCharacterToMove = charToMove;
		mCharacterToNotify = charToNotif;
		mNotifyMessage = notifMsg;
		mPassOverMessage = passOverMsg;
	}
}
