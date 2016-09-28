package com.mikeriv.ssui_2016.customdrawing;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Custom view class to drawing on a canvas
 */
public class CustomDrawingView extends View {

    public CustomDrawingView(Context context) {
        super(context);
    }

    public CustomDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomDrawingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int contentWidth = getWidth();
        int contentHeight = getHeight();
        /* TODO implement drawing a *red* circle at (500, 500) with radius 300 relative to the main view's reference frame
         * then draw a *blue* rectangle at (150, 150) with width: 100, height 150 relative to the circle's reference frame
         */

        // For each visual element, we want to:
        // 1) Clip to the elements drawing bounds,
        // 2) Translate to element's frame of reference such that drawing it puts it at 0,0
        // 3) Draw the element
        // 4) Repeat steps for children, and children's children, etc..
        // 5) Back out of the clipping to reset drawing region of current child
        // 6) Back out of the translation to reset the drawing location of current child to reference of the parent

    }

}
