package com.example.getjobapi;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class DetailActivity extends AppCompatActivity {
    TextView type;
    TextView name;
    TextView description;
    ApiInterface api;
    private CompositeDisposable disposables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        type = findViewById(R.id.type);
        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        api = ApiConfiguration.getApi();
        disposables = new CompositeDisposable();
        if (getIntent().getExtras() != null) {
            disposables.add(
                    api.product(getIntent().getStringExtra("ocpc"))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    (q) -> {
                                        type.setText("Type: " + q.type);
                                        name.setText(q.name);
                                        description.setText("Description: " + q.description);
                                    },
                                    (error) -> {
                                        error.printStackTrace();
                                        Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show();
                                    }));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposables.isDisposed()) {
            disposables.dispose();
        }
    }
}
