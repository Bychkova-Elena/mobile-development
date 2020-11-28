package com.example.getjobapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ListAdapter adapter;
    List<Product> list;
    ApiInterface api;
    private CompositeDisposable disposables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        adapter = new ListAdapter(this, list);
        recyclerView = findViewById(R.id.list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        api = ApiConfiguration.getApi();
        disposables = new CompositeDisposable();
        this.onClick(this.recyclerView);
    }

    public void onClick(View view){
        disposables.add(api.products()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((List) -> {
                    list.clear();
                    list.addAll(List.products);
                    adapter.notifyDataSetChanged();
                }, (error) -> Toast.makeText(this, "При поиске возникла ошибка:\n" + error.getMessage(),
                        Toast.LENGTH_LONG).show()));
    }
}
