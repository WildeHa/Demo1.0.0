package com.example.oshao.demo100;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech textToSpeech;

    private final String FLUSH = "flush";
    private final String ADD = "add";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GlobalVariable.setContext(this);

        textToSpeech = new TextToSpeech(GlobalVariable.getContext(), MainActivity.this);

        MyReceiver myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(FLUSH);
        intentFilter.addAction(ADD);

        registerReceiver(myReceiver,intentFilter);


        Intent intent = new Intent(this,IntentService.class);
        startService(intent);



    }

    @Override
    public void onInit(int i) {

    }

    public class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {

                case FLUSH:
                    Log.v("MainActivity","Receiving Intent");
                    textToSpeech.speak(intent.getStringExtra("Flush"),TextToSpeech.QUEUE_ADD,null);
                    break;
                case ADD:
                    break;
            }
        }
    }
}
