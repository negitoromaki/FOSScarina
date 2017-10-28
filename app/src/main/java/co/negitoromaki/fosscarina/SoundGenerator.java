package co.negitoromaki.fosscarina;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.autofill.AutofillId;

import java.util.ArrayList;

/**
 * logic from https://stackoverflow.com/questions/2413426/playing-an-arbitrary-tone-with-android
 * make an enum for tones?
 *
 */


public class SoundGenerator extends AppCompatActivity {

    private int toneTime = 1; // make it onHold();
    private int rate = 8000;
    private int samples = toneTime * rate;
    private double sampleSet[] = new double[samples];
    private double freq = 440; // make this a conditional to assign different tones
    private byte sound[] = new byte[2 * samples];

    Handler h = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onResume(){
        super.onResume();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
               spawn();
               h.post(new Runnable() {
                   @Override
                   public void run() {
                       play();
                   }
               });
            }
        });
        t.start();
    }

    void spawn(){
        for(int i=0; i < samples; i++){
            sampleSet[i] = Math.sin(2*Math.PI * i / (rate/freq));

        }
        int dx = 0;
        for(double diff: sampleSet){

            short value = (short)((diff * 32767));
            sound[dx++] = (byte) (value & 0x00ff);
            sound[dx++] =  (byte) ((value & 0xff00) >>> 8);
        }

    }

    void play(){
        AudioTrack at = new AudioTrack(AudioManager.STREAM_MUSIC,rate, AudioFormat.CHANNEL_OUT_MONO,AudioFormat.ENCODING_PCM_16BIT, sound.length, AudioTrack.MODE_STATIC);

        at.write(sound,0,sound.length);
        at.play();
    }

}


