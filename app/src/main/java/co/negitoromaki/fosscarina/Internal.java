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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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

            /* 8000 bytes per second, 1000 bytes = 125 ms */
            byte [] noiseData = new byte[1000];
            Random rnd = new Random();

            while(!m_stop)
            {
                rnd.nextBytes(noiseData);
                m_audioTrack.write(noiseData, 0, noiseData.length);
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
