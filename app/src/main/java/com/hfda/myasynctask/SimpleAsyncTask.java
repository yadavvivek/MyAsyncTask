package com.hfda.myasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by vivekyadv on 02-04-2018.
 */

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {

    private TextView textView;

    public SimpleAsyncTask(TextView mTextView) {
        textView = mTextView;
    }

    @Override
    public String doInBackground(Void... voids) {

        Random random = new Random();
        int number = random.nextInt(21);
        int time = number*200;

        try {
            Thread.sleep(time);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "Awake after " + time + " milliseconds.";
    }

    protected void onPostExecute(String result){
        textView.setText(result);
    }
}
