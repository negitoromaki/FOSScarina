package co.negitoromaki.fosscarina;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by csculley on 10/28/17.
 */

public class OcarinaTouchListener implements View.OnTouchListener {

    Boolean[] buttons = new Boolean[12];

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.equals(MotionEvent.ACTION_DOWN)) {
            buttons[v.getId()] = true;
        } else if (event.equals(MotionEvent.ACTION_UP)) {
            buttons[v.getId()] = false;
        }
        return true;
    }

    public Boolean[] getButtons() { return buttons; }

    public void setButtons(int number, Boolean b) {
        buttons[number - 1] = b;
    }

}
