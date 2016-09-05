package com.mikeriv.ssui_2016.puzzlegame.view;

import android.content.Context;
import android.widget.ImageView;

import com.mikeriv.ssui_2016.puzzlegame.model.PuzzleGameTile;

/**
 * Created by mlrivera on 9/3/16.
 */
public class PuzzleGameTileView extends ImageView {

    // A Unique Index that identifies this view in its grid
    // This is helpful if you need to know this view is in the gride
    private int mTileId = -1;


    public PuzzleGameTileView(Context context) {
        super(context);
    }

    public PuzzleGameTileView(Context context, int tileId, int minWidth, int minHeight) {
        super(context);
        mTileId = tileId;
        init(minWidth, minHeight);
    }
    private void init(int minWidth, int minHeight) {
        setMinimumWidth(minWidth);
        setMinimumHeight(minHeight);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public int getTileId() {
        return mTileId;
    }

    public void setTileId(int id) {
        mTileId = id;
    }

    public void updateWithTile(PuzzleGameTile tile) {
        setImageDrawable(tile.getDrawable());
    }


}
