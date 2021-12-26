package com.example.lesson4.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lesson4.R;
import com.example.lesson4.data.BookClient;
import com.example.lesson4.model.BookModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DetailActivity extends AppCompatActivity {
    BookModel bookModel;
    ArrayList<BookModel> list =  new ArrayList<>();
    TextView tvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvDetail = findViewById(R.id.tv_detail);
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        bookModel = (BookModel) intent.getSerializableExtra("books");
        tvDetail.setText(bookModel.getDescription());
    }
}