package co.negitoromaki.fosscarina;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.os.SystemClock;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected static OcarinaTouchListener touchListener;
    protected static boolean volumeLockEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setFragment(new Ocarina12HoleFragment());
        touchListener = new OcarinaTouchListener("12Hole");

    }

    @Override
     public boolean dispatchKeyEvent(KeyEvent event) {
        if (volumeLockEnabled) {
            int action = event.getAction();
            int keyCode = event.getKeyCode();

            switch (keyCode) {
                case KeyEvent.KEYCODE_VOLUME_UP:
                    if (action == KeyEvent.ACTION_DOWN) {
                        touchListener.setButtons(9, true);
                        dispatchTouchEvent(MotionEvent.obtain((long) SystemClock.uptimeMillis(),(long) SystemClock.uptimeMillis() + 10,MotionEvent.ACTION_DOWN, 500.0f, 500.0f, 0));
                    } else if (action == KeyEvent.ACTION_UP) {
                        touchListener.setButtons(9, false);
                        dispatchTouchEvent(MotionEvent.obtain((long) SystemClock.uptimeMillis(),(long) SystemClock.uptimeMillis() + 10,MotionEvent.ACTION_UP, 500.0f, 500.0f, 0));
                    }
                    return true;
                case KeyEvent.KEYCODE_VOLUME_DOWN:
                    if (action == KeyEvent.ACTION_DOWN) {
                        touchListener.setButtons(10, true);
                        dispatchTouchEvent(MotionEvent.obtain((long) SystemClock.uptimeMillis(),(long) SystemClock.uptimeMillis() + 10,MotionEvent.ACTION_DOWN, 500.0f, 500.0f, 0));
                    } else if (action == KeyEvent.ACTION_UP) {
                        touchListener.setButtons(10, false);
                        dispatchTouchEvent(MotionEvent.obtain((long) SystemClock.uptimeMillis(),(long) SystemClock.uptimeMillis() + 10,MotionEvent.ACTION_UP, 500.0f, 500.0f, 0));
                    }
                    return true;
                default:
                    return super.dispatchKeyEvent(event);
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_item_ocarina_12_hole) {
            setFragment(new Ocarina12HoleFragment());
            touchListener = new OcarinaTouchListener("12Hole");
        } else if (id == R.id.nav_item_ocarina_4_hole) {
            setFragment(new Ocarina4HoleFragment());
            touchListener = new OcarinaTouchListener("4Hole");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void setFragment(Fragment fragment) {
        android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.content_frame, fragment);
        t.commit();
    }

    static public void setVolumeLock(boolean b) {
        volumeLockEnabled = b;
    }

    static public boolean getVolumeLock() {
        return volumeLockEnabled;
    }

    static OcarinaTouchListener getTouchListener() {
        return touchListener;
    }

}