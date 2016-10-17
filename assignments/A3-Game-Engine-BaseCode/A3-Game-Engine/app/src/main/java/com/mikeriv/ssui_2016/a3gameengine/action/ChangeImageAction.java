package com.mikeriv.ssui_2016.a3gameengine.action;

import android.graphics.Bitmap;

/**
 *
 */
public class ChangeImageAction extends FSMAction {
	
	protected Bitmap mImage = null;
	/**
	 * 
	 * @return the image that should be shown. If null, no image should be displayed
	 */
	public Bitmap getImage() {return mImage;}
	
	/**
	 * 
	 * @param image The image that should be shown
	 */
	public ChangeImageAction(Bitmap image) {
		super(FSMActionType.CHANGE_IMAGE);
		mImage = image;
	}

}
