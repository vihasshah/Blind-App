package com.blindapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.blindapp.Adapters.CustomGridAdapter;
import com.blindapp.Models.GridModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    GridView catGrid;
    ArrayList<GridModel> arrayList;
    GestureDetectorCompat detectorCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // to detect gesture
        detectorCompat = new GestureDetectorCompat(this,this);

        setDefaultData();

        //category grid view
        catGrid = (GridView) findViewById(R.id.main_grid_view);
        CustomGridAdapter adapter = new CustomGridAdapter(this,arrayList);
        catGrid.setAdapter(adapter);
//        catGrid
//        catGrid.se
        catGrid.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // true will disable touch events
                // false will work normally
                return detectorCompat.onTouchEvent(event);
            }
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.detectorCompat.onTouchEvent(event);

        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        try {
//            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH){
//                return false;
//            }
//            if (Math.abs(e1.getX() - e2.getX()) > SWIPE_MAX_OFF_PATH){
//                return false;
//            }
            // right to left swipe
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                onLeftSwipe();
                return true;
            }
            // left to right swipe
            else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                onRightSwipe();
                return true;
            }

            // top to bottom swipe
            else if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                onUpSwipe();
                return true;
            }
            // bottom to top swipe
            else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                onBottonSwipe();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void onUpSwipe() {
        Toast.makeText(this,"up swipe",Toast.LENGTH_SHORT).show();
    }

    private void onBottonSwipe(){
        Toast.makeText(this,"bottom swipe",Toast.LENGTH_SHORT).show();
    }

    private void onRightSwipe() {
        Toast.makeText(this,"right swipe",Toast.LENGTH_SHORT).show();
//        if(speakEnable) {
//            speakOut("right swipe");
//        }
    }

    private void onLeftSwipe() {
        Toast.makeText(this,"Left swipe",Toast.LENGTH_SHORT).show();
//        if(speakEnable) {
//            speakOut("left swipe");
//        }
    }



    private void setDefaultData() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            GridModel model = new GridModel();
            model.setName("name "+i);
            model.setPath(R.mipmap.ic_launcher_round);
            arrayList.add(model);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
