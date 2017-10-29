package co.negitoromaki.fosscarina;

import android.app.Activity;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

/**
 * Created by patrick on 10/29/17.
 * https://stackoverflow.com/questions/6179392/audiotrack-in-streaming-mode-mode-streaming
 */

public class Internal extends Activity {
    double freq;
    public void getFreq(double freq){
        this.freq = freq;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPlayClicked(View v)
    {
        start();
    }

    public void onStopClicked(View v)
    {
        stop();
    }

    boolean m_stop = false;
    AudioTrack m_audioTrack;
    Thread m_noiseThread;

    Runnable m_noiseGenerator = new Runnable()
    {
        public void run()
        {
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

            // originally from http://marblemice.blogspot.com/2010/04/generate-and-play-tone-in-android.html
            // and modified by Steve Pomeroy <steve@staticfree.info>
             final int duration = 3; // seconds
             final int sampleRate = 8000;
             final int numSamples = duration * sampleRate;
             final double sample[] = new double[numSamples];
             final double freqOfTone = freq; // hz
            final byte generatedSnd[] = new byte[2 * numSamples];
            for (int i = 0; i < numSamples; ++i) {
                sample[i] = Math.sin(2 * Math.PI * i / (sampleRate/freqOfTone));
            }

            // convert to 16 bit pcm sound array
            // assumes the sample buffer is normalised.
            int idx = 0;
            for (final double dVal : sample) {
                // scale to maximum amplitude
                final short val = (short) ((dVal * 32767));
                // in 16 bit wav PCM, first byte is the low order byte
                generatedSnd[idx++] = (byte) (val & 0x00ff);
                generatedSnd[idx++] = (byte) ((val & 0xff00) >>> 8);
            }

            while(!m_stop)
            {
                m_audioTrack.write(generatedSnd, 0, generatedSnd.length);
            }
        }
    };

    void start()
    {
        m_stop = false;

        /* 8000 bytes per second*/
        m_audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 8000, AudioFormat.CHANNEL_OUT_MONO,
                AudioFormat.ENCODING_PCM_8BIT, 8000 /* 1 second buffer */,
                AudioTrack.MODE_STREAM);

        m_audioTrack.play();


        m_noiseThread = new Thread(m_noiseGenerator);
        m_noiseThread.start();
    }

    void stop()
    {
        m_stop = true;
        m_audioTrack.stop();
    }
}
