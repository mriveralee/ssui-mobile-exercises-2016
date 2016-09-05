package com.mikeriv.ssui_2016.puzzlegame.util;

import android.graphics.Bitmap;

/**
 * Helper functions for dealing with Bitmaps in the Puzzle Game
 * Created by mlrivera on 9/3/16.
 */
public class PuzzleImageUtil {

    /**
     * Takes a bitmap and details about a subdivision within that bitmap, returns a bitmap
     * whose pixels are of that subdivision (section) of the original image
     * associated.
     * @param bitmap - the bitmap to get a subsection from
     * @param subdivisionWidth - the width of the subsection
     * @param subdivisionHeight - the height of the subsection
     * @param subdivisionRowIndex - the row of the subsection in the image (assuming the image
     *                            has been subdivided already)
     * @param subdivisionColumnIndex - the column of the subsection in the image (assuming the image
     *                               has been subdivided already)
     * @return a bitmap containing the specific subsection of the original bitmap image if it exists
     * null otherwise
     * @throws IllegalArgumentException if the desired subimage is out of bounds of the image
     */

    public static final Bitmap getSubdivisionOfBitmap(
            Bitmap bitmap,
            int subdivisionWidth,
            int subdivisionHeight,
            int subdivisionRowIndex,
            int subdivisionColumnIndex) throws IllegalArgumentException {

        // The original bitmap dimensions
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        int[] pixels = new int[subdivisionHeight * subdivisionWidth];
        int yStart = subdivisionRowIndex * (subdivisionHeight - 1);
        int xStart = subdivisionColumnIndex * (subdivisionWidth - 1);

        if (xStart + subdivisionWidth > bitmapWidth
                || yStart + subdivisionHeight > bitmapHeight) {
            throw new IllegalArgumentException(
                    "Cannot get subdivision outside bounds of the image width and height");
        }
        bitmap.getPixels(
                pixels,
                0,                  // Offset in pixels array
                subdivisionWidth,   // Stride
                xStart,
                yStart,
                subdivisionWidth,
                subdivisionHeight);
        return Bitmap.createBitmap(
                pixels,
                subdivisionWidth,
                subdivisionHeight,
                Bitmap.Config.ARGB_8888);
    }

}
