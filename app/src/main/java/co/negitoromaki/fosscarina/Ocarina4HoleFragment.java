package co.negitoromaki.fosscarina;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.widget.Button;

/**
 * Created by csculley on 10/28/17.
 */

public class Ocarina4HoleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }

        /*
        assert container != null;
        Button b1;
        b1 = (Button) container.findViewById(R.id.button1);
        Button b2;
        b2 = (Button) container.findViewById(R.id.button2);
        Button b3;
        b3 = (Button) container.findViewById(R.id.button3);
        Button b4;
        b4 = (Button) container.findViewById(R.id.button4);

        TouchListener4 touchListener = new TouchListener4();
        b1.setOnTouchListener(touchListener);
        b2.setOnTouchListener(touchListener);
        b3.setOnTouchListener(touchListener);
        b4.setOnTouchListener(touchListener);

        */

        return inflater.inflate(R.layout.ocarina_4_hole, container, false);
    }

}

/*
class TouchListener4 implements OnTouchListener {

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(v.getId()){
            case 1:
                //do stuff for button 1
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
        }
        return true;
    }

}
*/