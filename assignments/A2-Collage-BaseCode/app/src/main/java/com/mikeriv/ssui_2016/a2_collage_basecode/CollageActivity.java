package com.mikeriv.ssui_2016.a2_collage_basecode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.mikeriv.ssui_2016.a2_collage_basecode.drawing.VisualElement;
import com.mikeriv.ssui_2016.a2_collage_basecode.tests.CollageViewTestHelper;
import com.mikeriv.ssui_2016.a2_collage_basecode.views.CollageView;

public class CollageActivity extends AppCompatActivity {

    public static final String TAG = "SSUI-MOBILE-COLLAGE-TESTS";

    // The toolbar with the settings icon
    private Toolbar mSupportActionBar;
    // The container holding out collage view
    private FrameLayout mCollageFrame;
    // The host view that holds a reference to our custom view hierarchy
    private CollageView mCollageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Magic for creating the settings icon/choices
        setContentView(R.layout.activity_collage);
        mSupportActionBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mSupportActionBar);

        // Grab "Frame" then create basic view to hold the collage
        mCollageFrame = (FrameLayout) findViewById(R.id.frame_collage);
        if (mCollageFrame != null) {
            mCollageView = new CollageView(this);
            mCollageFrame.addView(mCollageView);
            // TODO create the root visual element of your collage view
            // using your created BaseVisualElement class and set it
            // mCollageView.setChildVisualElement(rootVisualElement);
            refreshViewHierarchy();
        }

    }

    /**
     * Gets called every time the user presses the menu button.
     * Use if your menu is dynamic.
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        // Adds out test options to the menu bar
        CollageViewTestHelper.createTestMenuItems(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        boolean didHandleAction = CollageViewTestHelper.onTestItemSelected(
                item,
                mCollageView,
                this);
        if (didHandleAction) {
            refreshViewHierarchy();
        }
        return didHandleAction;
    }

    /**
     * Function to put your custom collage into
     * You may create additional methods like this to test
     * functionality
     */
    private void initCustomCollage() {
        // TODO: Part 2: Implement a Custom Collage

        // Finish off by refreshing the view Hierarchy
        refreshViewHierarchy();
    }

    /**
     * Helper method to refresh the custom drawing hierarchy
     */
    private void refreshViewHierarchy() {
        if (mCollageView == null) {
            return;
        }
        mCollageView.requestLayout();
        mCollageView.invalidate();
    }

}
