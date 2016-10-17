package com.mikeriv.ssui_2016.a3gameengine.character;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.mikeriv.ssui_2016.a3gameengine.engine.GameEnginePreBase;
import com.mikeriv.ssui_2016.a3gameengine.event.FSMEvent;
import com.mikeriv.ssui_2016.a3gameengine.fsm.FSMState;
import com.mikeriv.ssui_2016.a3gameengine.fsm.FSMTransition;

/**
 * This abstract class represents a character in the game engine. It has 
 * methods to handle the finite state machine for this character. Students
 * should implement the abstract methods from this class.
 * @author sauvik
 *
 */
public abstract class GameCharacterPreBase implements GameCharacter {
	
	protected GameEnginePreBase mOwner = null;
	@Override
	public GameEnginePreBase getOwner() {return mOwner;}
	
	protected int mCharacterIndex = -1;
	@Override 
	public int getCharacterIndex() {return mCharacterIndex;}
	
	protected float mX = 0;
	@Override
	public float getX() {return mX;}
	@Override
	public void setX(float xv) {mX = xv; /*xx add damage here */}
	
	protected float mY = 0;
	@Override
	public float getY() {return mY;}
	@Override
	public void setY(float yv) {mY = yv;}
	
	protected float mWidth = 13;
	@Override
	public float getW() {return mWidth;}
	@Override
	public void setW(float wv) {mWidth = wv;}
	
	protected float mHeight = 17;
	@Override
	public float getH() {return mHeight;}
	@Override
	public void setH(float hv) {mHeight = hv;}
	
	protected Bitmap mImage = null;
	@Override

	/**
	 * 
	 * @return the image that should be shown. If null, no image should be displayed
	 */
	public Bitmap getImage() {return mImage;}
	
	/**
	 * @param newImage the image that is set, which could be null if it is not supposed to be visible
	 */
	@Override
	public void setImage(Bitmap newImage) {mImage = newImage;}
	
	public static final int START_STATE = 0;
	protected int mCurrentState = START_STATE;
	@Override
	public int getCurrentState() {return mCurrentState;}
	@Override
	public void resetState() {mCurrentState = START_STATE;}
	
	protected FSMState[] mFSMStateTable = null;
	
	/**
	 * This method is called when there is an event that this character might
	 * be able to consume. The method should check to see if there are any
	 * transitions from the character's current state that match this event,
	 * If there are, that transition should be taken and the method should 
	 * return true.
	 * @param event the event that can be consumed
	 * return whether or not this character consumed this event
	 */
	@Override
	public abstract boolean deliverEvent(FSMEvent event);
	  // returns true if event was "consumed" (acted upon)
	
	/**
	 * This method causes the character to take the specified transition, which
	 * was triggered by the included event. The method should make sure to 
	 * complete any actions that are associated with the transition and ensure 
	 * that the character moves to the target state
	 * @param transition the transition that is to be taken
	 * @param evt the event that matched this transition
	 */
	protected abstract void makeFSMTransition(
			FSMTransition transition, FSMEvent evt);
	
	/**
	 * Draws the character on the canvas
	 * @param canv the canvas on which the character should be drawn
	 */
	@Override
	public abstract void draw(Canvas canv);
	
	public GameCharacterPreBase(
			GameEnginePreBase owner,
			int index,
			int x, int y, 
			int w, int h, 
			FSMState[] states,
			Bitmap img) 
	{
		mOwner = owner;
		mCharacterIndex = index;
		mX = x; mY = y; mWidth = w; mHeight = h;
		mFSMStateTable = states;
		mCurrentState = START_STATE;
		mImage = img;
	}
	
	public GameCharacterPreBase(
		GameEnginePreBase owner,
		int index,
		int x, int y, 
		int w, int h, 
		FSMState[] states) 
	{
		this(owner,index,x,y,w,h,states,null);
	}

	public GameCharacterPreBase() {
		this(null,-1,0,0,13,17,null);
	}
}
