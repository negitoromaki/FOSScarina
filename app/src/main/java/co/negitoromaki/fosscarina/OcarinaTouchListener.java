package co.negitoromaki.fosscarina;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by csculley on 10/28/17.
 */

public class OcarinaTouchListener implements View.OnTouchListener {
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
