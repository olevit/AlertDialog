package com.example.alertdialog

import android.annotation.SuppressLint
import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import java.lang.Math.abs

internal open class OnTouchListenerPager(context: Context?) : View.OnTouchListener {
    private val gestureDetector: GestureDetector
    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(motionEvent)
    }
    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
        private val SWIPE_THRESHOLD: Int = 50
        //private val SWIPE_VELOCITY_THRESHOLD: Int = 100
        override fun onDown(e: MotionEvent): Boolean {
            return true
        }
        /*override fun onSingleTapUp(e: MotionEvent): Boolean {
            onClick()
            return super.onSingleTapUp(e)
        }
        override fun onDoubleTap(e: MotionEvent): Boolean {
            onDoubleClick()
            return super.onDoubleTap(e)
        }
        override fun onLongPress(e: MotionEvent) {
            onLongClick()
            super.onLongPress(e)
        }*/
        override fun onFling(
                e1: MotionEvent,
                e2: MotionEvent,
                velocityX: Float,
                velocityY: Float
        ): Boolean {
            try {
                val diffY = e2.y - e1.y
                //val diffX = e2.x - e1.x

                    if (diffY > SWIPE_THRESHOLD
                            //&& abs(velocityY) > SWIPE_VELOCITY_THRESHOLD
                    ) {

                        onSwipeDown()

                    }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
            return false
        }
    }
   // open fun onSwipeRight() {}
   // open fun onSwipeLeft() {}
    //open fun onSwipeUp() {}
    open fun onSwipeDown() {}
    //private fun onClick() {}
    //private fun onDoubleClick() {}
    //private fun onLongClick() {}
    init {
        gestureDetector = GestureDetector(context, GestureListener())
    }

}