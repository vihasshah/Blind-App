package com.blindapp.Models;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Vihas on 08-03-2017.
 */

public class GestureFragment extends Fragment  implements GestureDetector.OnGestureListener {

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    GestureDetectorCompat detectorCompat;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("myapp","fragment loaded");
        // to detect gesture
        detectorCompat = new GestureDetectorCompat(getActivity(),this);

    }
//    @Override
//    public boolean onTouchEvent(MotionEvent event){
//        this.detectorCompat.onTouchEvent(event);
//
//        return super.onTouchEvent(event);
//    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
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
        Toast.makeText(getActivity(),"up swipe",Toast.LENGTH_SHORT).show();
    }

    private void onBottonSwipe(){
        Toast.makeText(getActivity(),"bottom swipe",Toast.LENGTH_SHORT).show();
    }

    private void onRightSwipe() {
        Toast.makeText(getActivity(),"right swipe",Toast.LENGTH_SHORT).show();
//        if(speakEnable) {
//            speakOut("right swipe");
//        }
    }

    private void onLeftSwipe() {
        Toast.makeText(getActivity(),"Left swipe",Toast.LENGTH_SHORT).show();
//        if(speakEnable) {
//            speakOut("left swipe");
//        }
    }


}
