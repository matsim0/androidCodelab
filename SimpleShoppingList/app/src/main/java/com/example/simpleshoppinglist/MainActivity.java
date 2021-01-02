package com.example.simpleshoppinglist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView[] mTextViewItem;

    private int mCurrentItem;

    public static final String EXTRA_MESSAGE = "com.example.android.simpleshoppinglist.extra.MESSAGE";
    public static final int TEXT_REQUEST=1;
    public static final int MAX_ITEMS = 9;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==TEXT_REQUEST) {
            if (resultCode==RESULT_OK) {
                String result = data.getStringExtra(AddItemActivity.EXTRA_REPLY);
                mTextViewItem[mCurrentItem].setText(result);
                if (mCurrentItem < MAX_ITEMS - 1) {
                    mCurrentItem++;
                } else {
                    mCurrentItem = 0;
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewItem = new TextView[MAX_ITEMS];

        mCurrentItem = 0;
        mTextViewItem[0] = findViewById(R.id.item_1);
        mTextViewItem[1] = findViewById(R.id.item_2);
        mTextViewItem[2] = findViewById(R.id.item_3);
        mTextViewItem[3] = findViewById(R.id.item_4);
        mTextViewItem[4] = findViewById(R.id.item_5);
        mTextViewItem[5] = findViewById(R.id.item_6);
        mTextViewItem[6] = findViewById(R.id.item_7);
        mTextViewItem[7] = findViewById(R.id.item_8);
        mTextViewItem[8] = findViewById(R.id.item_9);

        if (savedInstanceState != null) {
            String [] items = savedInstanceState.getStringArray("items");
            for (int i=0; i < MAX_ITEMS; i++) {
                mTextViewItem[i].setText(items[i]);
            }
            mCurrentItem = savedInstanceState.getInt("item_pointer");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        String[] items = new String[MAX_ITEMS];

        for (int i=0; i < MAX_ITEMS; i++) {
            items[i] = mTextViewItem[i].getText().toString();
        }
        outState.putStringArray("items", items);
        outState.putInt("item_pointer", mCurrentItem);
    }

    public void addItem(View view) {
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }
}