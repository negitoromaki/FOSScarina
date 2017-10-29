package co.negitoromaki.fosscarina;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

// https://stackoverflow.com/questions/2413426/playing-an-arbitrary-tone-with-android
public class PlayAudio {

    static Thread t;
    static int sr = 44100;
    static boolean isRunning = false;

    static public void start() {

        if (isRunning) {
            isRunning = false;
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t = null;
        }

        // start a new thread to synthesise audio
        t = new Thread() {
            public void run() {
                // set process priority
                setPriority(Thread.MAX_PRIORITY);
                // set the buffer size
                int buffsize = AudioTrack.getMinBufferSize(sr,
                        AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
                // create an audiotrack object
                AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
                        sr, AudioFormat.CHANNEL_OUT_MONO,
                        AudioFormat.ENCODING_PCM_16BIT, buffsize,
                        AudioTrack.MODE_STREAM);

                short samples[] = new short[buffsize];
                int amp = 10000;
                double twopi = 8.*Math.atan(1.);
                double ph = 0.0;
                isRunning = true;

                // start audio
                audioTrack.play();

                // synthesis loop
                while(isRunning){
                    double fr =  OcarinaTouchListener.getNote().freq();
                    for(int i=0; i < buffsize; i++){
                        samples[i] = (short) (amp*Math.sin(ph));
                        ph += twopi*fr/sr;
                    }
                    audioTrack.write(samples, 0, buffsize);
                }
                audioTrack.stop();
                audioTrack.release();
            }
        };
        t.start();
    }
}
