package com.mikeriv.helloworld;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int DEFAULT_SUM_VALUE = 0;

    private static int[] sNumbersToSum = {1, 10, 20, 30, 30, 9};

    private TextView mMainTextView;
    private TextView mSumTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // We want to do any initialization work here
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainTextView = (TextView) findViewById(R.id.main_text_view);
        mSumTextView = (TextView) findViewById(R.id.sum_text_view);

    }

    @Override   // This is a method thhat the superclass c
    protected void onStart() {
        // Always call super for android methods or you will have a really bad time
        super.onStart();

        if (mSumTextView != null) {
            String sumString = getSummationText(sNumbersToSum);
            mSumTextView.setText(sumString);
        }

    }

    private String getSummationText(int[] numbers) {
        int sum = sum(numbers);
        String sumString = getSummationText(sum);
        return sumString;
    }

    private static int sum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            // Error case
            return DEFAULT_SUM_VALUE;
        }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    private String getSummationText(int sum) {
        // Resources let's us access all of our apps resources (images, strings, dimensions)
        final Resources res = getResources();
        // res.getString(id, args...) - we can parametrize strings in the strings.xml and fill them
        // in using a format argument (let's you take care of unknown values)
        // Note: We can also do quantity-specific strings
        // Singular: Bob has 1 dog
        // vs.
        // Plural: Bob has 2 dogs
        String sumString = res.getString(R.string.summation_text, sum);
        return sumString;
    }

}



