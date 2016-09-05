package com.mikeriv.ssui_2016.puzzlegame.model;

import android.graphics.drawable.Drawable;

/**
 * Created by mlrivera on 9/4/16.
 */
public class PuzzleGameTile {

    public static final int INVALID_TILE_INDEX = -1;

    // A Unique Index that denotes the order of this tile in a puzzle
    private int mOrderIndex = INVALID_TILE_INDEX;
    private boolean mIsEmpty = false;
    private Drawable mDrawable = null;

    public PuzzleGameTile() {
        // do nothing
    }
    public PuzzleGameTile(int tileOrderIndex, Drawable drawable) {
       this(tileOrderIndex, drawable, false)
;    }

    public PuzzleGameTile(int tileOrderIndex, Drawable drawable, boolean isEmpty) {
        mOrderIndex = tileOrderIndex;
        mDrawable = drawable;
        mIsEmpty = isEmpty;
    }

    public int getOrderIndex() {
        return mOrderIndex;
    }

    public void setOrderIndex(int index) {
        mOrderIndex = index;
    }

    public void setIsEmpty(boolean isEmpty) {
        mIsEmpty = isEmpty;
    }

    public boolean isEmpty() {
        return mIsEmpty;
    }

    public void setDrawable(Drawable drawable) {
        mDrawable = drawable;
    }

    public Drawable getDrawable() {
        return mDrawable;
    }
}
