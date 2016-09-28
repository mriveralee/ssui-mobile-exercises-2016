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
 * TODO: document your custom view class.
 */
public class CustomDrawingView extends View {

    private Paint mCirclePaint;
    private Paint mRectPaint;

    public CustomDrawingView(Context context) {
        super(context);
        init();
    }

    public CustomDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomDrawingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        Context context = getContext();
        int circleColor =  ContextCompat.getColor(context, android.R.color.holo_blue_light);
        int rectColor =  ContextCompat.getColor(context, android.R.color.holo_red_dark);

        mCirclePaint = new Paint();
        mCirclePaint.setColor(circleColor);

        mRectPaint = new Paint();
        mRectPaint.setColor(rectColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // If we had padding we would subtract it here
        int contentWidth = getWidth();
        int contentHeight = getHeight();

        // In this example, we are going to draw a view hierarchy with this
        // CustomDrawingView as the parent node, and it will contain child that is
        // a rectangle. That rectangle will have a child that is a circle.
        //       CustomDrawingView (Root Node)
        //                    \
        //                 Rectangle
        //                     \
        //                  Circle

        // For each visual element, we want to:
        // 1) Clip to its drawing bounds,
        // 2) Translate to element's origin such that it is at 0,0 when we draw
        // 3) Draw the element
        // 4) Repeat steps for children and their children etc.
        // 5) Back out of the clipping to reset drawing region
        // 6) Back out of the translation to reset the drawing location
        int rectStartX = 100;
        int rectStartY = 100;
        int rectWidth = 300;
        int rectHeight = 500;
        canvas.save();
        canvas.clipRect(
                rectStartX,
                rectStartY,
                rectStartX + rectWidth,
                rectStartY + rectHeight);
        canvas.translate(rectStartX, rectStartY);

        // Draw the visual element
        canvas.drawRect(0, 0, rectWidth, rectHeight, mRectPaint);

        // Save state to be at the rectangle's clipping and translation state
        canvas.save();

        // Draw the children of the visual element
        int circleRadius = 30;
        int circleStartX = 40;
        int circleStartY = 40;

        // Clip to bound of child
        canvas.clipRect(
                circleStartX,
                circleStartY,
                circleStartX + 2 * circleRadius,
                circleStartY + 2 * circleRadius); // Bounding box around circle
        // Translate to coords of child (the circle)
        canvas.translate(circleStartX, circleStartY);
        // We don't need to save the circle's state, if the circle doesn't have children
        // Draw
        canvas.drawCircle(circleRadius, circleRadius, circleRadius, mCirclePaint);
        // We are done with the circle, so let's go back to it's parent's state (the rectangle)
        // Canvas.restore() resets the canvas's state to when the *last*  canvas.save() operation
        // was called. In our example, this is the equivalent of doing
        // canvas.translate(-circleStartX, -circleStartY);
        // canvas.clipRect(
        //      rectStartX,
        //      rectStartY,
        //      rectStartX + rectWidth,
        //      rectStartY + rectHeight,
        //      Region.Op.REPLACE);
        canvas.restore();

        // We have nothing left to draw that is a child of rectangle
        // Restore to the root node
        canvas.restore();

        // We're done - yay!
    }

}
