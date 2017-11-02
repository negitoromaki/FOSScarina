package co.negitoromaki.fosscarina;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by csculley on 10/28/17.
 */

public class Ocarina4HoleFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }

        return inflater.inflate(R.layout.ocarina_4_hole, container, false);
    }

    @Override

    public void onStart() {
        super.onStart();
        OcarinaButton b1 = (OcarinaButton) getActivity().findViewById(R.id.button1);
        OcarinaButton b2 = (OcarinaButton) getActivity().findViewById(R.id.button2);
        OcarinaButton b3 = (OcarinaButton) getActivity().findViewById(R.id.button3);
        OcarinaButton b4 = (OcarinaButton) getActivity().findViewById(R.id.button4);

        b1.setOnTouchListener(MainActivity.getTouchListener());
        b2.setOnTouchListener(MainActivity.getTouchListener());
        b3.setOnTouchListener(MainActivity.getTouchListener());
        b4.setOnTouchListener(MainActivity.getTouchListener());
    }

}