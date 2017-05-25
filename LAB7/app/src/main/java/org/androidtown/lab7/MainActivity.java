package org.androidtown.lab7;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;
    LinearLayout layout2;
    int id_audio;
    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (LinearLayout) findViewById(R.id.linearLayout);
        layout2 = (LinearLayout) findViewById(R.id.linearLayout2);


        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tag = (String) layout.getTag(); // get a tag in layout
                if(mediaPlayer2!=null) // if sample music2 is playing, pause the music2
                    mediaPlayer2.pause();
                layout.setBackgroundColor(Color.GRAY); // set background color
                layout2.setBackgroundColor(Color.WHITE); // set background color
                id_audio = getResources().getIdentifier(tag, "raw", getPackageName()); //get a mp3 file id
                mediaPlayer=MediaPlayer.create(MainActivity.this, id_audio); // make a media player
                mediaPlayer.start(); // media player start
            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tag = (String) layout2.getTag();// get a tag in layout
                if(mediaPlayer!=null)// if sample music  is playing, pause the music
                    mediaPlayer.pause();
                layout2.setBackgroundColor(Color.GRAY);// set background color
                layout.setBackgroundColor(Color.WHITE);// set background color
                id_audio = getResources().getIdentifier(tag, "raw", getPackageName());//get a mp3 file id
                mediaPlayer2=MediaPlayer.create(MainActivity.this,id_audio); // make a media player
                mediaPlayer2.start();// media player start

            }
        });

    }
}
