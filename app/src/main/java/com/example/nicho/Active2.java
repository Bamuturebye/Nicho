package com.example.nicho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Active2 extends AppCompatActivity {

  TextView textView;
  private Object CharSequence;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_active2);
    textView=findViewById(R.id.cprog);
    String str ="";
    try {
      InputStream inputStream=getAssets().open("my_c.cpp");
      int size =inputStream.available();
      byte[] buffer =new byte[size];
      inputStream.read(buffer);
      inputStream.close();
      str =new String(buffer);

    }
    catch (IOException e){
      e.printStackTrace();
    }
    textView.setText((CharSequence)str);

  }
}