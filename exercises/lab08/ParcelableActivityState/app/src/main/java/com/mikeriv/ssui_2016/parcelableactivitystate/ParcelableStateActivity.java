package com.mikeriv.ssui_2016.parcelableactivitystate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class ParcelableStateActivity extends AppCompatActivity {

    // Keys for our bundle
    private static final String PERSON_MODEL_KEY = "PERSON_MODEL_KEY";

    // The person's data
    private PersonModel mPersonModel;

    // The Views
    private EditText mPersonNameInput;
    private EditText mPersonFavoriteFoodInput;
    private EditText mPersonAgeInput;

    // The TextWatcher Listener
    /**
     * TextWatcher is a nifty listener in Android that lets you see when EditTexts are updated, or
     * have text changed in them. In this example below, we use a single TextWatcher to keep track
     * of EditText changes that should be reflected in our underlying data model (the PersonModel)
     */
    private TextWatcher mTextInputListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // Do nothing
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // Do nothing
        }

        @Override
        public void afterTextChanged(Editable s) {
            // Here we want to check EditText was changed and update the model accordingly
            if (mPersonModel == null) {
                // We shouldn't be trying to update a null model
                return;
            }
            String text = s.toString();
            // Otherwise check which EditText was changed, and update the model
            if (s == mPersonNameInput.getEditableText()) {
                mPersonModel.setName(text);
            } else if (s == mPersonAgeInput.getEditableText()) {
                mPersonModel.setAge(Integer.parseInt(text));
            } else if (s == mPersonFavoriteFoodInput.getEditableText()) {
                mPersonModel.setFavoriteFood(text);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable_state);

        // Here's how we restore the activity's state to what it was before android destroyed it
        if (savedInstanceState != null) {
            mPersonModel = savedInstanceState.getParcelable(PERSON_MODEL_KEY);
        }

        // Error handling in case our saveInstanceState parcelable is null or we were just created
        if (mPersonModel == null) {
            mPersonModel = new PersonModel();
        }

        mPersonNameInput = (EditText) findViewById(R.id.edit_name);
        mPersonNameInput.addTextChangedListener(mTextInputListener);

        mPersonAgeInput = (EditText) findViewById(R.id.edit_age);
        mPersonAgeInput.addTextChangedListener(mTextInputListener);


        mPersonFavoriteFoodInput = (EditText) findViewById(R.id.edit_favorite_food);
        mPersonFavoriteFoodInput.addTextChangedListener(mTextInputListener);

        // Update method takes care of error checking for null views
        updateEditableTextFields();
    }

    // Could instead put the instance state code in onRestoreInstanceState()...
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        mPersonModel = savedInstanceState.getParcelable(PERSON_MODEL_KEY);
//        // Error handling in case our saveInstanceState parcelable is null
//        if (mPersonModel == null) {
//            mPersonModel = new PersonModel();
//        }
//    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Here is how we save the state
        // Comment this out and try to rotate your phone, what happens to all of
        // the entered content?
        outState.putParcelable(PERSON_MODEL_KEY, mPersonModel);
    }

    private void updateEditableTextFields() {
        if (mPersonNameInput != null) {
            mPersonNameInput.setText(mPersonModel.getName());
        }
        if (mPersonAgeInput != null) {
            mPersonAgeInput.setText(Integer.toString(mPersonModel.getAge()));
        }
        if (mPersonFavoriteFoodInput != null) {
            mPersonFavoriteFoodInput.setText(mPersonModel.getFavoriteFood());
        }
    }

}
