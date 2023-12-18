package com.example.phonecallingsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void callNumber(View view) {
        EditText editText = (EditText) findViewById(R.id.editText_main);
        String phoneNumber = String.format("tel: %s",
                editText.getText().toString());

        Log.d(TAG, "Phone Status: DIALING: " + phoneNumber);
        Toast.makeText(this,
                "Phone Status: DIALING: " + phoneNumber,
                Toast.LENGTH_LONG).show();

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse(phoneNumber));

        if (callIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(callIntent);
        } else {
            Log.e(TAG, "Can't resolve app for ACTION_CALL Intent.");
        }
    }
}