package com.example.simpleshoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddItemActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }

    public void addItem(View view) {
        Intent replyIntent = new Intent();
        String item = ((Button) view).getText().toString();
        replyIntent.putExtra(EXTRA_REPLY, item);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}