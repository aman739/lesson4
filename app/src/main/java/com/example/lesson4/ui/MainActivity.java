package com.example.lesson4.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.example.lesson4.OnClick;
import com.example.lesson4.R;

import com.example.lesson4.adapter.adapter.AdapterBooks;
import com.example.lesson4.data.BookClient;
import com.example.lesson4.model.BookModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterBooks adapterBooks ;
    ArrayList<BookModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        clickItem();
    }

    private void clickItem() {
        adapterBooks.setOnClick(new OnClick() {
            @Override
            public void clickPosition(int position, BookModel bookModel) {
                Intent intent  = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("books", bookModel);
                startActivity(intent);
            }
        });
    }

    private void initialization() {
        recyclerView = findViewById(R.id.recycler_view);
        list = BookClient.getBook();
        adapterBooks = new AdapterBooks(list);
        recyclerView.setAdapter(adapterBooks);
    }
}