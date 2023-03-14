package com.example.pe_sample;

import static com.example.pe_sample.CarProvider.PROVIDER_URI;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText productId;
    EditText productModel;
    EditText productPrice;
    ContentValues contentValues;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        productId = (EditText) findViewById(R.id.edit_id);
        productModel = (EditText) findViewById(R.id.edit_name);
        productPrice = (EditText) findViewById(R.id.edit_price);
    }
    public void updateData(View view) {
        String id = productId.getText().toString();
        String model = productModel.getText().toString();
        String price = productPrice.getText().toString();
        if (!id.isEmpty()) {
            if (!model.isEmpty()) {
                if (!price.isEmpty() && Integer.parseInt(price) > 0) {
                    try {
                        uri = Uri.parse(PROVIDER_URI);

                        contentValues = new ContentValues();
                        contentValues.put("model", model);
                        contentValues.put("price", price);
                        int rowsDeleted = getContentResolver().update(uri, contentValues, "id = ?", new String[]{id} );
                        if (rowsDeleted > 0) {
                            productId.setText("");
                            productModel.setText("");
                            productPrice.setText("");
                            Toast.makeText(this, "Update successfully!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "Please fill correctly!", Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(this, "Car not found", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(this, "Car price is required and must be greater than 0", Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(this, "Car Model is required", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Car ID is required!", Toast.LENGTH_LONG).show();
        }
    }
    public void backToHome(View view) {
        Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
        startActivity(intent);
    }
}