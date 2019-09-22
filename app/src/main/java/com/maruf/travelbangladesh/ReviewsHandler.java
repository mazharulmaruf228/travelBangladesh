package com.maruf.travelbangladesh;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ReviewsHandler extends AppCompatActivity {
    TextView tvTitle,tvWriter,tvDate,tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews_handler);


        String title = getIntent().getStringExtra("title");
        String writer = getIntent().getStringExtra("writer");
        String date = getIntent().getStringExtra("date");
        String fullText = getIntent().getStringExtra("description");

        tvTitle = findViewById(R.id.tvtitle);
        tvWriter = findViewById(R.id.tvwriter);
        tvDate = findViewById(R.id.tvdate);
        tvDescription = (TextView) findViewById(R.id.tvtext);

        tvTitle.setText(title);
        tvWriter.setText(writer);
        tvDate.setText(date);
        tvDescription.setText(fullText);


    }
}
