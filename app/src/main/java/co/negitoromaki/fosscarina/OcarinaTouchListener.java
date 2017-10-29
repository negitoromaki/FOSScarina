package co.negitoromaki.fosscarina;

import android.view.MotionEvent;
import android.view.View;

import in.excogitation.zentone.library.ToneStoppedListener;
import in.excogitation.zentone.library.ZenTone;

/**
 * Created by csculley on 10/28/17.
 */

public class OcarinaTouchListener implements View.OnTouchListener {

    static boolean[] buttons = new boolean[12];

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.equals(MotionEvent.ACTION_DOWN)) {
            buttons[v.getId()] = true;
        } else if (event.equals(MotionEvent.ACTION_UP)) {
            buttons[v.getId()] = false;
        }

        return true;
    }


    public static boolean[] getButtons() {
        return buttons;
    }

    public void setButtons(int number, boolean b) {
        buttons[number - 1] = b;
    }

    static public Note getNote(String currentOcarina) {
    if (currentOcarina.equals("4Hole")) {

    } else if (currentOcarina.equals("12Hole")) {

        if (buttons.equals(new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true})) {
            return Note.A_3;
        }

    }
}
