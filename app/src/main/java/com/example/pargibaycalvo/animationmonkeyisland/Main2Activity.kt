package com.example.pargibaycalvo.animationmonkeyisland

import android.animation.ObjectAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext


class Main2Activity : AppCompatActivity() {

    private val uiContext: CoroutineContext = UI


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        tarea1_segundo_plano().start()

        //funcion del boton para que nos muestre el contenido del blackfragment
        button2.setOnClickListener{
            val fragment = BlankFragment()
            val args = Bundle()
            args.putString("23", "Hi")
            fragment.arguments = args
            addFragment(fragment)
        }
    }

    var j: Int = 1

    //metodo que nos movera el gif animado
    fun tarea1_segundo_plano() = launch(uiContext) {

        val objectAnimator = ObjectAnimator.ofFloat(gifImageView4, "translationX", 500f * j)
        objectAnimator.duration = 3000L
        objectAnimator.interpolator
        objectAnimator.start()
    }
    //este metodo nos modificara el main 2 par aañadirnos el contenido del blankfragment
    fun addFragment(fragment: BlankFragment){
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                .replace(R.id.lala, fragment, fragment.javaClass.getSimpleName())
                .addToBackStack(fragment.javaClass.getSimpleName())
                .commit()
    }

}
