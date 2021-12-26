package com.example.lesson4.adapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson4.OnClick;
import com.example.lesson4.R;
import com.example.lesson4.model.BookModel;

import java.util.ArrayList;
import java.util.List;

public class AdapterBooks extends RecyclerView.Adapter<AdapterBooks.HolderBooks> {


    List<BookModel> list; // оннолгия массива

    private OnClick onClick;


    public AdapterBooks(ArrayList<BookModel> list) {
        this.list = list;
    }

    public void setOnClick(OnClick onClick){
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public HolderBooks onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_for_books, parent, false);
        return new HolderBooks(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderBooks holder, int position) {
        holder.onBind(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class HolderBooks extends RecyclerView.ViewHolder {
        TextView tvBooks;

        public HolderBooks(@NonNull View itemView) {
            super(itemView);
            tvBooks = itemView.findViewById(R.id.tv_books);
        }

        public void onBind(BookModel bookModel) {
            tvBooks.setText(bookModel.getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.clickPosition(getAdapterPosition(), bookModel);
                }
            });
        }
    }


}
