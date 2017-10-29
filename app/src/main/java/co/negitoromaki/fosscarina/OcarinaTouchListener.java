package co.negitoromaki.fosscarina;

import android.media.AudioTrack;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.view.MotionEvent;
import android.view.View;
import in.excogitation.zentone.library.ToneStoppedListener;
import in.excogitation.zentone.library.ZenTone;

/**
 * Created by csculley on 10/28/17.
 */

public class OcarinaTouchListener implements View.OnTouchListener {

    private static boolean[] buttons = new boolean[12];
    private static String currentOcarina;

    OcarinaTouchListener(String c) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = false;
        }
        currentOcarina = c;
    }
// https://gist.github.com/slightfoot/6330866

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int button = getButtonId(v.getId());

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            setButtons(button, true);
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            setButtons(button, false);
        }
        Internal i = new Internal();
        i.getFreq(1000.0);
        i.start();
        return true;
    }

    public int getButtonId(int i) {
        switch (i) {
            case R.id.button1:
                return 1;
            case R.id.button2:
                return 2;
            case R.id.button3:
                return 3;
            case R.id.button4:
                return 4;
            case R.id.button5:
                return 5;
            case R.id.button6:
                return 6;
            case R.id.button7:
                return 7;
            case R.id.button8:
                return 8;
            case R.id.button11:
                return 11;
            case R.id.button12:
                return 12;
            default:
                return 0;
        }
    }


    public static boolean[] getButtons() {
        return buttons;
    }

    public void setButtons(int number, boolean b) {
        if (number != 0) {
            buttons[number - 1] = b;
        }
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
                return Note.B_3;
            }

            if (buttons.equals(new boolean[] {true, true, true, true, true, true, true, true, true, true, false, false})) {// no 11,12
                return Note.C_3 ;
            }

            if (buttons.equals(new boolean[] {true, true, true, true, true, true, true, false, true, true, false, false})) {// no 11,12,8
                return Note.D_3;
            }

            if (buttons.equals(new boolean[] {true, true, true, true, true, true, false, false, true, true, false, false})) {
                return Note.E_3;
            }

            if (buttons.equals(new boolean[] {true, true, true, true, true, false, false, false, true, true, false, false})) {
                return Note.F_3;
            }

            if (buttons.equals(new boolean[] {true, true, true, true, false, false, false, false, true, true, false, false})) {
                return Note.G_3;
            }

            if (buttons.equals(new boolean[] {true, true, false, true, false, false, false, false, true, true, false, false})) {
                return Note.A_4;
            }

            if (buttons.equals(new boolean[] {true, false, false, true, false, false, false, false, true, true, false, false})) {
                return Note.B_4;
            }

            if (buttons.equals(new boolean[] {false, false, false, true, false, false, false, false, true, true, false, false})) {
                return Note.C_4;
            }

            if (buttons.equals(new boolean[] {false, false, false, true, false, false, false, false, false, true, false, false})) {
                return Note.D_4;
            }

            if (buttons.equals(new boolean[] {false, false, false, true, false, false, false, false, false, false, false, false})) {
                return Note.E_4;
            }

            if (buttons.equals(new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false})) {
                return Note.NULL; //Should be F_3, but we don't have any control from baseline rn
            }

            if (buttons.equals(new boolean[] {true, true, true, true, true, true, true, true, true, true, true, false})) {
                return Note.A_3_SHARP;
            }

            if (buttons.equals(new boolean[] {true, true, true, true, true, true, true, false, true, true, false, true})) {
                return Note.C_3_SHARP;
            }

            if (buttons.equals(new boolean[] {true, true, true, true, true, true, false, false, true, true, false, true})) {
                return Note.D_3_SHARP;
            }

            if (buttons.equals(new boolean[] {true, true, true, true, false, false, true, false, true, true, false, false})) {
                return Note.F_3_SHARP;
            }

            if (buttons.equals(new boolean[] {true, true, false, true, false, false, true, false, true, true, false, false})) {
                return Note.G_3_SHARP;
            }

            if (buttons.equals(new boolean[] {true, false, false, true, false, false, true, false, true, true, false, false})) {
                return Note.A_4_SHARP;
            }

            if (buttons.equals(new boolean[] {false, false, false, true, false, false, true, false, true, true, false, false})) {
                return Note.C_4_SHARP;
            }

            if (buttons.equals(new boolean[] {false, false, false, true, false, false, true, false, false, false, false, false})) {
                return Note.D_4_SHARP;
            }

        }
        return Note.NULL;
    }

}
