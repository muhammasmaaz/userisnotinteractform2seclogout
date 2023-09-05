package com.example.userisnotactivelogout

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import java.util.TimerTask


class profileActivity : AppCompatActivity() {


    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable
    private var mTime: Long = 2000
    //    private var timer: Timer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mHandler = Handler(Looper.getMainLooper())
        mRunnable = Runnable {
            Toast.makeText(
                applicationContext,
                "User inactive for ${mTime / 1000} secs! Now Logout",
                Toast.LENGTH_SHORT
            ).show()
                val intent = Intent(this@profileActivity, MainActivity::class.java)
            startActivity(intent)
        }

        startHandler()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        stopHandler()
        startHandler()
        return super.onTouchEvent(event)
    }

    private fun startHandler() {
        mHandler.postDelayed(mRunnable, mTime)
    }

    private fun stopHandler() {
        mHandler.removeCallbacks(mRunnable)
    }
//    override fun onPause() {
//        super.onPause()
//        timer = Timer()
//        val timerTask = object : TimerTask() {
//            override fun run() {
//                val intent = Intent(this@profileActivity, MainActivity::class.java)
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent)
//                finish()
//            }
//        }
//        timer!!.schedule(timerTask, 1000)
//
//    }
//
//    override fun onResume() {
//        super.onResume()
//        if (timer != null) {
//            timer!!.cancel()
//            timer = null
//        }
//
//    }
}