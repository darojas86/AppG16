package com.example.appg16.ui.utiles;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {
    private TextView mTextView;
    @Override
    protected String doInBackground(Void... voids) {
        // Generate a random number between 0 and 10
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running
        int s = n * 200;

        // Sleep for the random amount of time
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return a String result
        return "m " + s + " milliseconds!";
    }
    protected void onPostExecute(String result) {
        mTextView.setText(result);
    }
    public SimpleAsyncTask(TextView mTextView) {
        this.mTextView = mTextView;
    }
}
