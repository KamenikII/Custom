package ru.netology.customviews.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.netology.customviews.R

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view = findViewById<StatsView>(R.id.stats)
        view.postDelayed({
            view.data = listOf(
                500F,
                500F,
                500F,
                500F,
            )
        }, 50)
//
//        val textView = findViewById<TextView>(R.id.label)
//
//        val viewAnim = AnimationUtils.loadAnimation(
//            this, R.anim.animation
//        ).apply {
//            setAnimationListener(object : Animation.AnimationListener {
//                override fun onAnimationStart(animation: Animation?) {
//                    textView.text = "started"
//                }
//
//                override fun onAnimationEnd(animation: Animation?) {
//                    textView.text = "ended"
//                }
//
//                override fun onAnimationRepeat(animation: Animation?) {
//                    textView.text = "repeat"
//                }
//            })
//        }
//
//        view.startAnimation(viewAnim)

//        ObjectAnimator.ofFloat(view, "alpha", 0.25F, 1F).apply {
//            startDelay = 500
//            duration = 300
//            interpolator = BounceInterpolator()
//        }.start()

//        ObjectAnimator.ofFloat(view, View.ALPHA, 0.25F, 1F).apply {
//            startDelay = 500
//            duration = 300
//            interpolator = BounceInterpolator()
//        }.start()

//        val rotation = PropertyValuesHolder.ofFloat(View.ROTATION, 0F, 360F)
//        val alpha = PropertyValuesHolder.ofFloat(View.ALPHA, 0F, 1F)
//        ObjectAnimator.ofPropertyValuesHolder(view, rotation, alpha)
//            .apply {
//                startDelay = 500
//                duration = 500
//                interpolator = LinearInterpolator()
//            }.start()
//
//        view.animate()
//            .rotation(360F)
//            .scaleX(1.2F)
//            .scaleY(1.2F)
//            .setInterpolator(LinearInterpolator())
//            .setStartDelay(500)
//            .setDuration(500)
//            .start()

//        val alpha = ObjectAnimator.ofFloat(view, View.ALPHA, 0.25F, 1F).apply {
//            duration = 300
//            interpolator = LinearInterpolator()
//        }
//        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0F, 1F)
//        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0F, 1F)
//        val scale = ObjectAnimator.ofPropertyValuesHolder(view, scaleX, scaleY).apply {
//            duration = 300
//            interpolator = BounceInterpolator()
//        }
//        AnimatorSet().apply {
//            startDelay = 500
//            playSequentially(scale, alpha)
//        }.start()
    }
}