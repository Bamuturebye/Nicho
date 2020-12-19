package com.example.nicho;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Active1 extends AppCompatActivity {
  MediaPlayer mPlayer;

  Button buttonPlay;

  Button buttonPause;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_active1);
    buttonPlay= (Button)findViewById(R.id.button1);

    buttonPlay.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.davido_assurance);//Create MediaPlayer object with MP3 file under res/raw folder
        mPlayer.start();//Start playing the music
      }

    });
    buttonPause = (Button) findViewById(R.id.button2);
    buttonPause.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (mPlayer != null && mPlayer.isPlaying()) {//If music is playing already
          mPlayer.stop();//Stop playing the music

        }
      }
    });

  }
}