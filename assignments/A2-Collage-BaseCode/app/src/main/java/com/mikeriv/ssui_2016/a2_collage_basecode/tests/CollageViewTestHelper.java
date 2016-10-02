package com.mikeriv.ssui_2016.a2_collage_basecode.tests;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.mikeriv.ssui_2016.a2_collage_basecode.R;
import com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement;
import com.mikeriv.ssui_2016.a2_collage_basecode.views.CollageView;

/**
 * Simple Collage view test helper class that creates menu items and runs tests
 * for the CollageView while you are running the app
 * Created by mlrivera on 10/2/16.
 */
public abstract class CollageViewTestHelper {

    // Identifer for this class
    public static final String TAG = "SSUI_A2_TESTS";
    // Starting Index for putting menu items
    private static final int sMenuItemStartIndex = Menu.FIRST;

    // TODO Increase if you add tests
    private static final int sNumTestItems = 3;

    /**
     * Runs a test based on the associated menu item passed in
     * If you add a test case in this file, you need to tie it to the assocaited option here
     * @param item - the item that was selected
     * @return true if the test item was handled
     */
    public static boolean onTestItemSelected(
            MenuItem item,
            CollageView collageView,
            Context context) {
        if (collageView == null) {
            Log.e(TAG, "CollageView can't be null for testing");
            return false;
        }
        if (context == null) {
            Log.e(TAG, "Context can't be null for testing");
            return false;
        }
        if (item == null || sNumTestItems <= 0) {
            Log.e(TAG, "Null Item or 0 tests declared!");
            return false;
        }

        int itemId = item.getItemId();
        switch (itemId) {
            case 1:
                runTest1(collageView, context);
                break;
            case 2:
                runTest2(collageView, context);
                break;
            case 3:
                runTest3(collageView, context);
                break;
            // TODO add more test cases
            default:
                throw new IllegalArgumentException("Test Item selected has no action to perform!");
        }
        return true;
    }

    /**
     * Adds a number of test options to particular menu
     * @param menu - the menu to add test options to
     */
    public static void createTestMenuItems(Menu menu) {
        if (menu == null) {
            return;
        }
        // Normally the strings below would be in the strings.xml file
        // We don't care about these not being there since is a simple
        // testing framework for your eyes only  :)
        for (int i = 0; i < sNumTestItems; i++) {
            int itemId = sMenuItemStartIndex + i;
            String itemLabel = String.format("Test %d", itemId);
            menu.add(0, itemId, Menu.NONE, itemLabel);
        }
    }

    private static final void updateCollageViewWithRoot(CollageView collageView, VisualElement root) {
        if (collageView == null) {
            Log.e(TAG, "CollageView can't be null for testing");
        }
        collageView.setChildVisualElement(root);
    }

    // TODO: Below are a series of commented out testing coding - once you implement the requirements
    // you can use these to test your view hierarchy and the expected output
    private static void putSamplesInElement(
            VisualElement rootVisualElement,
            boolean placeElementsAtOrigin,
            Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context should not be null!");
        }
        if (rootVisualElement == null) {
            throw new IllegalArgumentException("rootVisualElement should not be null");
        }
        // TODO uncomment once you have implemented:
        // SimpleFrame, SolidBackDrop, IconImage, NinePartImage, TextVisualElement

//        Resources res = context.getResources();
//        if(placeElementsAtOrigin){
//            rootVisualElement.addChild(new SimpleFrame(0, 0, 20, 20));
//            rootVisualElement.addChild(new SolidBackDrop(0, 0, 20, 20, Color.BLUE));
//            rootVisualElement.addChild(new IconImage(0, 0, BitmapFactory.decodeResource(res, R.drawable.ic_noun_cat)));
//            Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.bluebutton);
//            NinePatch patches = new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
//            rootVisualElement.addChild(new NinePartImage(0, 0, 200, 20, patches));
//            rootVisualElement.addChild(new TextVisualElement(0, 0, "SSUI RoCkS!!!!", Typeface.DEFAULT_BOLD, 50f));
//        }
//        else{
//            rootVisualElement.addChild(new SimpleFrame(5, 5, 20, 20));
//            rootVisualElement.addChild(new SolidBackDrop(5, 30, 20, 20, Color.BLUE));
//            rootVisualElement.addChild(new IconImage(5, 55, BitmapFactory.decodeResource(res, R.drawable.ic_noun_robot2)));
//            Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.bluebutton);
//            NinePatch patches = new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
//            rootVisualElement.addChild(new NinePartImage(30, 5, 200, 20, patches));
//            rootVisualElement.addChild(new TextVisualElement(30, 30, "SSUI RoCkS!!!!", Typeface.DEFAULT_BOLD, 50f));
//        }
    }

    private static final void runTest1(CollageView collageView, Context context) {
        Log.d(TAG, "Running test 1!");
        /**
         * TODO uncomment when you have implemented the following:
         * SolidBackDrop, PileLayout, RowLayout, ColumnLayout
         **/
//        SolidBackDrop rootVisualElement = new SolidBackDrop(0, 0, 400, 800, Color.WHITE);
//        putSamplesInElement(rootVisualElement, false, context);
//        PileLayout p = new PileLayout(5, 200, 100, 100);
//        p.addChild(new SolidBackDrop(0, 0, 900, 900, Color.GRAY));
//        p.addChild(new SimpleFrame(0, 0, 100, 100));
//        rootVisualElement.addChild(p);
//        putSamplesInElement(p, false);
//        p.addChild(new SolidBackDrop(0, 0, 20, 20, Color.GRAY));
//        RowLayout r = new RowLayout(5, 310, 350, 50);
//        rootVisualElement.addChild(r);
//        putSamplesInElement(r, false, context);
//        ColumnLayout col = new ColumnLayout(5, 370, 50, 200);
//        rootVisualElement.addChild(col);
//        putSamplesInElement(o, false, context);
//        updateCollageViewWithRoot(collageView, o);
    }


    private static final void runTest2(CollageView collageView, Context context) {
        Log.d(TAG, "Running test 2!");
        /**
         * TODO uncomment when you have implemented the following:
         * SolidBackDrop, CircleLayout, OvalClip
         **/
//       SolidBackDrop rootVisualElement = new SolidBackDrop(0, 0, 400, 800, Color.WHITE);
//       SolidBackDrop s = new SolidBackDrop(0, 0, 50, 50, Color.GREEN);
//       rootVisualElement.addChild(s);
//       s.setPosition(-40, -40);
//       SolidBackDrop s2 = new SolidBackDrop(0, 0, 50, 50, Color.BLUE);
//       rootVisualElement.addChild(s2);
//       SolidBackDrop s3 = new SolidBackDrop(0, 0, 50, 50, Color.RED);
//       rootVisualElement.addChild(s3);
//       rootVisualElement.moveChildLast(s);
//       rootVisualElement.removeChild(s3);
//
//       CircleLayout c = new CircleLayout(100, 100, 300, 400, 150, 200, 100);
//       rootVisualElement.addChild(c);
//       for(int i = 0; i<8; i++){
//          c.addChild(new SolidBackDrop(0, 0, 20, 20, Color.BLUE));
//       }
//       SolidBackDrop s4 = new SolidBackDrop(100, 100, 50, 50, Color.MAGENTA);
//       c.addChild(s4);
//       rootVisualElement.addChild(s4);
//
//       OvalClip o = new OvalClip(5, 200, 50, 50);
//       rootVisualElement.addChild(o);
//       o.addChild(new SolidBackDrop(0, 0, 50, 50, Color.BLUE));
//       putSamplesInElement(o, true, context);
//       updateCollageViewWithRoot(collageView, o);
    }


    private static final void runTest3(CollageView collageView, Context context) {
        // TODO uncomment when you have implemented SolidBackDrop
//        SolidBackDrop rootVisualElement = new SolidBackDrop(0, 0, 400, 800, Color.WHITE);
//        SolidBackDrop fakeChild = new SolidBackDrop(0, 0, 400, 800, Color.WHITE);
//        try{
//            rootVisualElement.addChild(null);
//            Log.d(TAG, "Add null child:PASS");
//        } catch (Exception e){
//            Log.d(TAG, "Add null Child:FAIL");
//        }
//
//        try{
//            if(rootVisualElement.getChildAt(-1) == null) {
//                Log.d(TAG, "Get bad Child:PASS");
//            }
//            else {
//                Log.d(TAG, "Get bad Child:FAIL");
//            }
//        } catch (Exception e){
//            Log.d(TAG, "Get bad Child:FAIL");
//        }
//
//        try{
//            if(rootVisualElement.findChild(fakeChild) == -1
//                    && rootVisualElement.findChild(null) == -1) {
//                Log.d(TAG, "Find bad Child:PASS");
//            } else {
//                Log.d(TAG, "Find bad Child:FAIL");
//            }
//        } catch (Exception e){
//            Log.d(TAG, "Find bad Child:FAIL");
//        }
//
//
//        try{
//            rootVisualElement.moveChildLater(fakeChild);
//            rootVisualElement.moveChildLater(null);
//            Log.d(TAG, "Move bad Child:PASS");
//        } catch (Exception e){
//            Log.d(TAG, "Move bad Child:FAIL");
//        }
//
//        try{
//            SolidBackDrop s = new SolidBackDrop(0, 0, 50, 50, Color.GREEN);
//            s.setPosition(null);
//            s.setSize(null);
//            Log.d(TAG, "Set position/size null:PASS");
//        } catch (Exception e){
//            Log.d(TAG, "Set position/size null:FAIL");
//        }
    }


    // TODO add more test cases below, if necessary
//    private static final void runTest4(CollageView collageView, Context context)
//        Log.d(TAG, "running test 3!");
//        updateCollageViewWithRoot(collageView, o);
//    }

}
