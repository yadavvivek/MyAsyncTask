package com.hfda.myasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    private final static String TEXT_VALUE = "currentText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);

        if(savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(TEXT_VALUE));
        }
    }

    public void startTaskMethod(View view) {

        mTextView.setText("Sleeping...");

        //Going to start in background..
        new SimpleAsyncTask(mTextView).execute();
    }

    @Override
    public void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);

        bundle.putString(TEXT_VALUE, mTextView.getText().toString());
    }
}
