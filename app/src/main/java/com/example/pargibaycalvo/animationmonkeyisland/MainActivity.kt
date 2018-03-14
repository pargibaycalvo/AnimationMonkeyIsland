package com.example.pargibaycalvo.animationmonkeyisland

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import java.util.*
import android.content.Intent
import android.view.View
import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.CoroutineContext
import kotlinx.coroutines.experimental.android.UI


class MainActivity : AppCompatActivity() {

    private val uiContext: CoroutineContext = UI
    private val bgContext: CoroutineContext = CommonPool
    var MAX_VOLUME = 100
    var soundVolume = 50
    var volume = (1 - Math.log((MAX_VOLUME - soundVolume).toDouble()) / Math.log(MAX_VOLUME.toDouble())).toFloat()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var musicafondo = MediaPlayer.create(this, R.raw.intro)
        musicafondo.setLooping(true)
        musicafondo.setVolume(volume, volume)
        Timer().schedule(object : TimerTask() {
            override fun run() {
                musicafondo.start()
            }
        }, 1000)
    }

    fun onClick(v: View) {
        when (v.getId()) {
            R.id.button -> {
                val intent = Intent(this, Main2Activity::class.java)
                startActivity(intent)
            }
        }
    }
}


