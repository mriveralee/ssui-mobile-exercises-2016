package com.mikeriv.ssui_2016.a3gameengine;

import android.os.Handler;
import android.os.Message;

import com.mikeriv.ssui_2016.a3gameengine.engine.GameEnginePreBase;

/**
 *
 */
public class TickHandler extends Handler {

	protected GameEnginePreBase mNotifyObj;
	protected boolean mRunning = true;

	public GameEnginePreBase getNotifyObj() {return mNotifyObj;}



	public boolean getRunning() {return mRunning;}
	public void stop() {mRunning = false;}
	public void start() {mRunning = true;}
	
	public static final long TICK_INTERVAL_MSEC = 15;
	
	@Override 
	public void handleMessage(Message msg) {
		if (mNotifyObj != null) {
			mNotifyObj.doAnimationWork();
			if (getRunning()) 
				sendEmptyMessageDelayed(0, TICK_INTERVAL_MSEC);
		}
	}
	
	public TickHandler(GameEnginePreBase notifyObj) {
		super();
		mNotifyObj = notifyObj;
		sendEmptyMessageDelayed(0, TICK_INTERVAL_MSEC);
	}

}
