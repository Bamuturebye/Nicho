package com.example.nicho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view){

        EditText message;
        message = (EditText)findViewById(R.id.textView);
        Toast.makeText(this, "Sending message" + message.getText().toString(),
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);

        message.setText("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuname,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId1 = item.getItemId();
        switch (itemId1) {
            case R.id.web:
                startActivity(new Intent(this, Active1.class));
                return true;
                //Intent i = new Intent(this, Active1.class);
                // Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse(nam1));

            case R.id.gmail:
                startActivity(new Intent(this, Active2.class));
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }}
