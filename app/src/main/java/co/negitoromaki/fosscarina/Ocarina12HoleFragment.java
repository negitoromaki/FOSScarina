package co.negitoromaki.fosscarina;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ToggleButton;


/**
 * Created by csculley on 10/28/17.
 */

public class Ocarina12HoleFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }

        return inflater.inflate(R.layout.ocarina_12_hole, container, false);
    }
    public void onStart() {
        super.onStart();
        OcarinaButton b1 = (OcarinaButton) getActivity().findViewById(R.id.button1);
        OcarinaButton b2 = (OcarinaButton) getActivity().findViewById(R.id.button2);
        OcarinaButton b3 = (OcarinaButton) getActivity().findViewById(R.id.button3);
        OcarinaButton b4 = (OcarinaButton) getActivity().findViewById(R.id.button4);
        OcarinaButton b5 = (OcarinaButton) getActivity().findViewById(R.id.button5);
        OcarinaButton b6 = (OcarinaButton) getActivity().findViewById(R.id.button6);
        OcarinaButton b7 = (OcarinaButton) getActivity().findViewById(R.id.button7);
        OcarinaButton b8 = (OcarinaButton) getActivity().findViewById(R.id.button8);
        //Buttons 9 and 10 are volume buttons
        OcarinaButton b11 = (OcarinaButton) getActivity().findViewById(R.id.button11);
        OcarinaButton b12 = (OcarinaButton) getActivity().findViewById(R.id.button12);

        ToggleButton volLock = (ToggleButton) getActivity().findViewById(R.id.vol_lock);

        volLock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    MainActivity.setVolumeLock(true);
                } else {
                    MainActivity.setVolumeLock(false);
                }
            }
        });

        b1.setOnTouchListener(MainActivity.getTouchListener());
        b2.setOnTouchListener(MainActivity.getTouchListener());
        b3.setOnTouchListener(MainActivity.getTouchListener());
        b4.setOnTouchListener(MainActivity.getTouchListener());
        b5.setOnTouchListener(MainActivity.getTouchListener());
        b6.setOnTouchListener(MainActivity.getTouchListener());
        b7.setOnTouchListener(MainActivity.getTouchListener());
        b8.setOnTouchListener(MainActivity.getTouchListener());
        //Buttons 9 and 10 are volume buttons
        b11.setOnTouchListener(MainActivity.getTouchListener());
        b12.setOnTouchListener(MainActivity.getTouchListener());
    }
}