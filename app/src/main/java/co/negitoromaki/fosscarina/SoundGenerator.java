package co.negitoromaki.fosscarina;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * logic from https://stackoverflow.com/questions/2413426/playing-an-arbitrary-tone-with-android
 */

public class SoundGenerator extends AppCompatActivity {

    private int toneTime = 1; // make it onHold();
    private int rate = 8000;
    private int samples = toneTime * rate;
    private double sampleSet[] = new double[samples];
    private double freq = 440; // make this a conditional to assign different tones
    private byte sound[] = new byte[2 * samples];

    Handler h = new Handler();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
