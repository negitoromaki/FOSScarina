package co.negitoromaki.fosscarina;

import android.view.MotionEvent;
import android.view.View;
import java.util.Arrays;

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

    static public Note getNote() {

        if (currentOcarina.equals("4Hole")) {
            if (Arrays.equals(buttons, new boolean[] {true, true, true, true, false, false, false, false, false, false, false, false})) {
                return Note.C_5;
            }

            if (Arrays.equals(buttons, new boolean[] {false, true, true, true, false, false, false, false, false, false, false, false})) {
                return Note.D_5;
            }

            if (Arrays.equals(buttons, new boolean[] {true, false, true, true, false, false, false, false, false, false, false, false})) {
                return Note.E_5;
            }

            if (Arrays.equals(buttons, new boolean[] {false, false, true, true, false, false, false, false, false, false, false, false})) {
                return Note.F_5;
            }

            if (Arrays.equals(buttons, new boolean[] {true, true, false, true, false, false, false, false, false, false, false, false})) {
                return Note.F_5_SHARP;
            }

            if (Arrays.equals(buttons, new boolean[] {false, true, false, true, false, false, false, false, false, false, false, false})) {
                return Note.G_5;
            }

            if (Arrays.equals(buttons, new boolean[] {true, false, false, true, false, false, false, false, false, false, false, false})) {
                return Note.G_5_SHARP;
            }

            if (Arrays.equals(buttons, new boolean[] {false, false, false, true, false, false, false, false, false, false, false, false})) {
                return Note.A_5;
            }

            if (Arrays.equals(buttons, new boolean[] {false, true, false, false, false, false, false, false, false, false, false, false})) {
                return Note.A_5_SHARP;
            }

            if (Arrays.equals(buttons, new boolean[] {true, false, false, false, false, false, false, false, false, false, false, false})) {
                return Note.B_5;
            }

            if (Arrays.equals(buttons, new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false})) {
                return Note.NULL; //Should be C_6, need to fall through without baseline
            }

        } else if (currentOcarina.equals("12Hole")) {

            if (Arrays.equals(buttons, new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true})) {
                return Note.A_4;
            }

            if (Arrays.equals(buttons, new boolean[] {true, true, true, true, true, true, true, true, true, true, false, true})) { // no 11
                return Note.B_4;
            }

            if (Arrays.equals(buttons, new boolean[] {true, true, true, true, true, true, true, true, true, true, false, false})) {// no 11,12
                return Note.C_5 ;
            }

            if (Arrays.equals(buttons, new boolean[] {true, true, true, true, true, true, true, false, true, true, false, false})) {// no 11,12,8
                return Note.D_5;
            }

            if (Arrays.equals(buttons, new boolean[] {true, true, true, true, true, true, false, false, true, true, false, false})) {
                return Note.E_5;
            }

            if (Arrays.equals(buttons, new boolean[] {true, true, true, true, true, false, false, false, true, true, false, false})) {
                return Note.F_5;
            }

            if (Arrays.equals(buttons, new boolean[] {true, true, true, true, false, false, false, false, true, true, false, false})) {
                return Note.G_5;
            }

            if (Arrays.equals(buttons, new boolean[] {true, true, false, true, false, false, false, false, true, true, false, false})) {
                return Note.A_5;
            }

            if (Arrays.equals(buttons, new boolean[] {true, false, false, true, false, false, false, false, true, true, false, false})) {
                return Note.B_5;
            }

            if (Arrays.equals(buttons, new boolean[] {false, false, false, true, false, false, false, false, true, true, false, false})) {
                return Note.C_6;
            }

            if (Arrays.equals(buttons, new boolean[] {false, false, false, true, false, false, false, false, false, true, false, false})) {
                return Note.D_6;
            }

            if (Arrays.equals(buttons, new boolean[] {false, false, false, true, false, false, false, false, false, false, false, false})) {
                return Note.E_6;
            }

            if (Arrays.equals(buttons, new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false})) {
                return Note.NULL; //Should be F_6, but we don't have any control from baseline rn
            }

            if (Arrays.equals(buttons, new boolean[] {true, true, true, true, true, true, true, true, true, true, true, false})) {
                return Note.A_4_SHARP;
            }

            if (Arrays.equals(buttons, new boolean[] {true, true, true, true, true, true, true, false, true, true, false, true})) {
                return Note.C_5_SHARP;
            }

            if (Arrays.equals(buttons, new boolean[] {true, true, true, true, true, true, false, false, true, true, false, true})) {
                return Note.D_5_SHARP;
            }

            if (Arrays.equals(buttons, new boolean[] {true, true, true, true, false, false, true, false, true, true, false, false})) {
                return Note.F_5_SHARP;
            }

            if (Arrays.equals(buttons, new boolean[] {true, true, false, true, false, false, true, false, true, true, false, false})) {
                return Note.G_5_SHARP;
            }

            if (Arrays.equals(buttons, new boolean[] {true, false, false, true, false, false, true, false, true, true, false, false})) {
                return Note.A_5_SHARP;
            }

            if (Arrays.equals(buttons, new boolean[] {false, false, false, true, false, false, true, false, true, true, false, false})) {
                return Note.C_6_SHARP;
            }

            if (Arrays.equals(buttons, new boolean[] {false, false, false, true, false, false, true, false, false, false, false, false})) {
                return Note.D_6_SHARP;
            }

        }
        return Note.NULL;
    }

}
