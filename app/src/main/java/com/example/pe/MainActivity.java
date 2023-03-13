package com.example.pe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pe.adapter.DataAdapter;

public class MainActivity extends AppCompatActivity {

    TextView dataList;
    TextView txtColumnName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataList = findViewById(R.id.txtData);
        txtColumnName = findViewById(R.id.txtColumnName);
        DataAdapter handler = new DataAdapter(this, null, null, 1);
        dataList.setText(handler.loadDataAdapter());
        if (!dataList.getText().toString().isEmpty()) {
            txtColumnName.setVisibility(View.VISIBLE);
        }
    }

    public void addProduct(View view) {
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }
    public void deleteProduct(View view) {
        dataList = findViewById(R.id.txtData);
        txtColumnName = findViewById(R.id.txtColumnName);
        DataAdapter handler = new DataAdapter(this, null, null, 1);
        dataList.setText(handler.loadDataAdapter());
        if (!dataList.getText().toString().isEmpty()) {
            Intent intent = new Intent(MainActivity.this, DeleteActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Doesn't have any car to delete!", Toast.LENGTH_SHORT).show();
        }
    }
    public void updateProduct(View view) {
        dataList = findViewById(R.id.txtData);
        txtColumnName = findViewById(R.id.txtColumnName);
        DataAdapter handler = new DataAdapter(this, null, null, 1);
        dataList.setText(handler.loadDataAdapter());
        if (!dataList.getText().toString().isEmpty()) {
            Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Doesn't have any car to update!", Toast.LENGTH_SHORT).show();
        }

    }
}