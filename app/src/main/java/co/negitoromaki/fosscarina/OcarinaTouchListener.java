package co.negitoromaki.fosscarina;

import android.view.MotionEvent;
import android.view.View;

import in.excogitation.zentone.library.ToneStoppedListener;
import in.excogitation.zentone.library.ZenTone;

/**
 * Created by csculley on 10/28/17.
 */

public class OcarinaTouchListener implements View.OnTouchListener {

    private static boolean[] buttons = new boolean[12];

    OcarinaTouchListener() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = false;
        }
    }

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

            if (buttons.equals(new boolean[] {true, true, true, true, false, false, false, false, false, false, false, false})) {
                return Note.C_3;
            }

            if (buttons.equals(new boolean[] {false, true, true, true, false, false, false, false, false, false, false, false})) {
                return Note.D_3;
            }

            if (buttons.equals(new boolean[] {true, false, true, true, false, false, false, false, false, false, false, false})) {
                return Note.E_3;
            }

            if (buttons.equals(new boolean[] {false, false, true, true, false, false, false, false, false, false, false, false})) {
                return Note.F_3;
            }

            if (buttons.equals(new boolean[] {true, true, false, true, false, false, false, false, false, false, false, false})) {
                return Note.F_3_SHARP;
            }

            if (buttons.equals(new boolean[] {false, true, false, true, false, false, false, false, false, false, false, false})) {
                return Note.G_3;
            }

            if (buttons.equals(new boolean[] {true, false, false, true, false, false, false, false, false, false, false, false})) {
                return Note.G_3_SHARP;
            }

            if (buttons.equals(new boolean[] {false, false, false, true, false, false, false, false, false, false, false, false})) {
                return Note.A_4;
            }

            if (buttons.equals(new boolean[] {false, true, false, false, false, false, false, false, false, false, false, false})) {
                return Note.A_4_SHARP;
            }

            if (buttons.equals(new boolean[] {true, false, false, false, false, false, false, false, false, false, false, false})) {
                return Note.B_4;
            }

            if (buttons.equals(new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false})) {
                return Note.NULL; //Should be C_4, but we don't have any control for baseline right now.
            }

        } else if (currentOcarina.equals("12Hole")) {


            if (buttons.equals(new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true})) {
                return Note.A_3;
            }
            if (buttons.equals(new boolean[] {true, true, true, true, true, true, true, true, true, true, false, true})) { // no 11
                return Note.B_4;
            }
            if (buttons.equals(new boolean[] {true, true, true, true, true, true, true, true, true, true, false, false})) {// no 11,12
                return ;
            }
            if (buttons.equals(new boolean[] {true, true, true, true, true, true, true, false, true, true, false, false})) {// no 11,12,8
                return ;
            }
            if (buttons.equals(new boolean[] {true, true, true, true, true, true, false, false, true, true, false, false})) {
                return ;
            }

            if (buttons.equals(new boolean[] {true, true, true, true, true, false, false, false, true, true, false, false})) {
                return ;
            }

            if (buttons.equals(new boolean[] {true, true, true, true, false, false, false, false, true, true, false, false})) {
                return ;
            }

            if (buttons.equals(new boolean[] {true, true, false, true, false, false, false, false, true, true, false, false})) {
                return ;
            }

            if (buttons.equals(new boolean[] {true, false, false, true, false, false, false, false, true, true, false, false})) {
                return ;
            }

            if (buttons.equals(new boolean[] {false, false, false, true, false, false, false, false, true, true, false, false})) {
                return ;
            }

            if (buttons.equals(new boolean[] {false, false, false, true, false, false, false, false, false, true, false, false})) {
                return ;
            }

            if (buttons.equals(new boolean[] {false, false, false, true, false, false, false, false, false, false, false, false})) {
                return ;
            }

            if (buttons.equals(new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false})) {
                return Note.NULL; //Should be F_3, but we don't have any control from baseline rn
            }

            if (buttons.equals(new boolean[] {true, true, true, true, true, true, true, true, true, true, true, false})) {
                return ;
            }
            if (buttons.equals(new boolean[] {true, true, true, true, true, true, true, false, true, true, false, true})) {
                return ;
            }

            if (buttons.equals(new boolean[] {true, true, true, true, true, true, false, false, true, true, false, true})) {
                return ;
            }
            if (buttons.equals(new boolean[] {true, true, true, true, false, false, true, false, true, true, false, false})) {
                return ;
            }

            if (buttons.equals(new boolean[] {true, true, false, true, false, false, true, false, true, true, false, false})) {
                return ;
            }

            if (buttons.equals(new boolean[] {true, false, false, true, false, false, true, false, true, true, false, false})) {
                return ;
            }
            if (buttons.equals(new boolean[] {false, false, false, true, false, false, true, false, true, true, false, false})) {
                return ;
            }

            if (buttons.equals(new boolean[] {false, false, false, true, false, false, true, false, false, false, false, false})) {
                return ;
            }

        } else {
            return Note.NULL;
        }
    }
}
