package com.mikeriv.ssui_2016.networkactivitytest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class NetworkTestActivity extends AppCompatActivity {
    private static final String TAG = NetworkTestActivity.class.getName();

    private static final int MIN_RANDOM_IMAGE_DIMENSION = 80;
    private static final int MAX_RANDOM_IMAGE_DIMENSION = 700;

    private Random mRandomIntGenerator = new Random(System.currentTimeMillis());
    private ImageDownloadTask mImageDownloadTask;

    private ImageView mCatImageView;
    private TextView mStatusTextView;

    private final View.OnClickListener mCatImageClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v != mCatImageView) {
                return;
            }
            // TODO trigger a network request when clicking on the image
            triggerNetworkRequest();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mCatImageView = (ImageView) findViewById(R.id.img_rand_cat);
        if (mCatImageView != null) {
            mCatImageView.setOnClickListener(mCatImageClickListener);
        }

        mStatusTextView = (TextView) findViewById(R.id.text_network_status);
        if (mStatusTextView != null) {
            mStatusTextView.setText(getString(R.string.text_downloading));
        }
        // TODO Trigger the first request!
        triggerNetworkRequest();
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Don't do any requests when we are leaving
        cancelNetworkRequest();
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Don't do any requests when we are leaving
        cancelNetworkRequest();
    }

    // Triggers Async requests
    private void triggerNetworkRequest() {
        // Cancel any current requests so we don't get weird stuff happening
        cancelNetworkRequest();

        // Create a random url that gets an image of a random dimension
        String catUrl = getRandomCatImageUrl();

        // TODO get the connectivity manage and then network info to check if network isConnected
        // TODO if it is connected, create a new imageDownload task and execute it with the catURL
        // TODO otherwise set the status test to no_connection

        // This manager tells us the state of our network
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            // Update status text to say downloading
            mStatusTextView.setText(getString(R.string.text_downloading));

            // Now create an AsyncTask to fire the request
            mImageDownloadTask = new ImageDownloadTask();
            // And.. fire the request!
            mImageDownloadTask.execute(catUrl);
        } else {
            // Update status text to say no connection
            mStatusTextView.setText(getString(R.string.text_no_connection));
        }

    }

    // Used to cancel any requests that are currently running
    private void cancelNetworkRequest() {
        if (mImageDownloadTask != null) {
            mImageDownloadTask.cancel(true);
            mImageDownloadTask = null;
        }
    }

    // Gets a random dimension int in the range [MIN, MAX]
    private int getRandomIntDimension() {
        return mRandomIntGenerator.nextInt(
                MAX_RANDOM_IMAGE_DIMENSION - MIN_RANDOM_IMAGE_DIMENSION)
                + MIN_RANDOM_IMAGE_DIMENSION;
    }

    // Creates an random cat image url using the random dimensions
    private String getRandomCatImageUrl() {
        int randDimA = getRandomIntDimension();
        int randDimB = getRandomIntDimension();
        String randCatUrl = getString(R.string.url_rand_cat, randDimA, randDimB);
        return randCatUrl;
    }

    private class ImageDownloadTask extends AsyncTask<String, Void, Bitmap> {

        private static final int CONNECTION_TIME_OUT_MSEC = 15000;
        private static final int CONNECTION_TIME_READ_MSEC = 10000;

        private boolean mFailedWithException = false;

        // This runs when the
        @Override
        protected Bitmap doInBackground(String... urls) {
            if (urls == null || urls.length == 0) {
                return null;
            }

            // TODO use download Image with a url to get a bitmap result
            Bitmap result = downloadImage(urls[0]);
            return result;
        }

        // Runs after the task has finished executing
        @Override
        protected void onPostExecute(Bitmap result) {
            // Update the bitmap - but do it on the main thread!
            final Bitmap img = result;

            // TODO set a runnable to execute on UI thread to update the imageview using img
            // TODO include updating the status text to either ERROR or SUCCESS using
            //  getString(R.string.text_error) && getString(R.string.text_success);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mCatImageView != null) {
                        mCatImageView.setImageBitmap(img);
                    }
                    if (mStatusTextView != null) {
                        String statusText = (mFailedWithException)
                                ? getString(R.string.text_error)
                                : getString(R.string.text_success);
                        mStatusTextView.setText(statusText);
                    }
                }
            });
        }

        // Downloads an image based on a provided URL
        private Bitmap downloadImage(String urlStr) {
            InputStream is = null;
            try {
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(CONNECTION_TIME_OUT_MSEC);
                conn.setConnectTimeout(CONNECTION_TIME_READ_MSEC);
                conn.setDoInput(true);
                // Starts the query
                conn.connect();
                int response = conn.getResponseCode();
                Log.d(TAG, "The response is: " + response);
                is = conn.getInputStream();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap bitmap = BitmapFactory.decodeStream(is, null, options);
                return bitmap;
            } catch (Exception e) {
                // Nothing to do here but set an error
                mFailedWithException = true;
                return null;
            } finally {
                // Makes sure that the InputStream is closed after the app is
                // finished using it.
                closeQuietly(is);
            }

        }

        protected void closeQuietly(InputStream is) {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {
                mFailedWithException = true;
            }
        }
    }

}
