package co.negitoromaki.fosscarina;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.KeyEvent;
import android.app.Activity;

/**
 * Created by csculley on 10/28/17.
 */

public class Ocarina12HoleFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }

        Button volLock = (Button) container.findViewById(R.id.vol_lock);
        Button b1 = (Button) container.findViewById(R.id.button1);
        Button b2 = (Button) container.findViewById(R.id.button2);
        Button b3 = (Button) container.findViewById(R.id.button3);
        Button b4 = (Button) container.findViewById(R.id.button4);
        Button b5 = (Button) container.findViewById(R.id.button5);
        Button b6 = (Button) container.findViewById(R.id.button6);
        Button b7 = (Button) container.findViewById(R.id.button7);
        Button b8 = (Button) container.findViewById(R.id.button8);
        //Buttons 9 and 10 are volume buttons
        Button b11 = (Button) container.findViewById(R.id.button11);
        Button b12 = (Button) container.findViewById(R.id.button12);


        TouchListener12 touchListener = new TouchListener12();
        volLock.setOnTouchListener(touchListener);
        b1.setOnTouchListener(touchListener);
        b2.setOnTouchListener(touchListener);
        b3.setOnTouchListener(touchListener);
        b4.setOnTouchListener(touchListener);
        b5.setOnTouchListener(touchListener);
        b6.setOnTouchListener(touchListener);
        b7.setOnTouchListener(touchListener);
        b8.setOnTouchListener(touchListener);
        //Buttons 9 and 10 are volume buttons
        b11.setOnTouchListener(touchListener);
        b12.setOnTouchListener(touchListener);

        return inflater.inflate(R.layout.ocarina_12_hole, container, false);
    }
}

class TouchListener12 implements OnTouchListener {

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case 1:
                SoundGenerator sg = new SoundGenerator();
                sg.spawn();
                sg.play();
                break;
            case 2:
                //do stuff for button 2
                break;
            case 3:
                //do stuff for button 3
                break;
            case 4:
                //do stuff for button 4
                break;
            case 5:
                //do stuff for button 5
                break;
            case 6:
                //do stuff for button 6
                break;
            case 7:
                //do stuff for button 7
                break;
            case 8:
                //do stuff for button 8
                break;
            case 11:
                //do stuff for button 11
                break;
            case 12:
                //do stuff for button 12
                break;
        }
        return true;
    }

}

class TouchListenerVol extends Activity {

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    //TODO
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    //TODO
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

}