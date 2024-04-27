package com.example.androidprojectcollection.GenshinCrush;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;


/**
 * OnSwipeListener is a custom implementation of View.OnTouchListener
 * that detects swipe gestures on a view and triggers corresponding callback methods.
 * It utilizes GestureDetector to detect swipe gestures.
 */
public class OnSwipeListener implements View.OnTouchListener {

    /** The GestureDetector instance for detecting gestures */
    public GestureDetector gestureDetector;

    /**
     * Constructs a new OnSwipeListener with the specified Context.
     * @param context The context in which the listener operates.
     */
    public OnSwipeListener(android.content.Context context) {
        gestureDetector = new GestureDetector(context, new GestureListener());
    }
    /**
     * Called when a touch event is dispatched to a view.
     * @param v The view the touch event has been dispatched to.
     * @param event The MotionEvent object containing full information about the event.
     * @return True if the listener has consumed the event, false otherwise.
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
    /**
     * The GestureListener class extends GestureDetector.SimpleOnGestureListener
     * and implements the logic for detecting swipe gestures.
     */
    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        /** The threshold distance for a swipe to be considered valid */
        public static final int SWIPE_THRESHOLD = 100;
        /** The threshold velocity for a swipe to be considered valid */
        public static final int SWIPE_VELOCITY_THRESHOLD = 100;
        /**
         * Called when the user first touches the screen where the touch event begins.
         * @param e The MotionEvent object containing full information about the event.
         * @return True to indicate that the event was handled, false otherwise.
         */
        @Override
        public boolean onDown( MotionEvent e) {
            // Indicates that the event was handled
            return true;
        }
        /**
         * Called when a fling gesture (quick swipe) is detected.
         * @param e1 The first MotionEvent that started the fling.
         * @param e2 The MotionEvent that triggered the current event.
         * @param velocityX The velocity of this fling measured in pixels per second along the x axis.
         * @param velocityY The velocity of this fling measured in pixels per second along the y axis.
         * @return True if the event is consumed, false otherwise.
         */
        @Override
        public boolean onFling(MotionEvent e1,  MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            // Calculate the differences in x and y coordinates
            assert e1 != null;
            float yDiff = e2.getY() - e1.getY();
            float xDiff = e2.getX() - e1.getX();

            // Check if the swipe is primarily horizontal or vertical
            if(Math.abs(xDiff) > Math.abs(yDiff)){
                // Horizontal swipe
                if(Math.abs(xDiff) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD){
                    if(xDiff > 0) onSwipeRight();
                        // Swipe to the right
                    else onSwipeLeft();
                        // Swipe to the Left
                    result = true;
                }
            } else {
                // Vertical swipe
                if (Math.abs(yDiff) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if(yDiff > 0) onSwipeBottom();
                        // Swipe to the bottom
                    else onSwipeTop();
                        // Swipe to the top
                    result = true;
                }
            }
            return result;
        }
    }
    void onSwipeLeft () {

    }
    void onSwipeRight () {

    }
    void onSwipeTop () {

    }
    void onSwipeBottom () {

    }
    // Comment indicating the coordinate system
    // Note: The first tap is considered as the 0,0 coordinate.
    // When the x coordinate of the swipe is > 0, it indicates a swipe to the right,
    // and when it is < 0, it indicates a swipe to the left.
    // Similarly, for vertical swipes, when the y coordinate is > 0, it indicates a swipe to the bottom,
    // and when it is < 0, it indicates a swipe to the top.
}
