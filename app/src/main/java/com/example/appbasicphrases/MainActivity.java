package com.example.appbasicphrases;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    MediaPlayer mplayer;
    //int i = 0,j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonTapped (View view){

        int id = view.getId();
        String ourId = "", tempId;

        ourId = view.getResources().getResourceEntryName(id);
        tempId = ourId;
        Log.i("button tapped", ourId);

        int resourceId = getResources().getIdentifier(ourId, "raw", "com.example.appbasicphrases");
        mplayer = MediaPlayer.create(this, resourceId);

        mplayer.start();

        //Apabila command dihilangkan maka music akan langsung berhenti, dikarenakan saya belum dapat
        //mencari solusi untuk membuat parameter agar apaliba button lainnya diklik maka otomatis musik akan berhenti
        //maka saya command terlebih dahulu

        //Dan apabila tidak ada function untuk menghentikan mplayer maka musik akan terus memutar dan saling bertabrakan

        //i =+ 1;

        //if(mplayer.isPlaying() && i != j){
        //    realeaseMediaPlayer();
        //    i = 0;
        //}
    }

    public void realeaseMediaPlayer(){
        try {
            if(mplayer != null){
                if(mplayer.isPlaying())
                    mplayer.stop();
                mplayer.release();
                mplayer = null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}