package com.example.pargibaycalvo.animationmonkeyisland


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 */
class BlankFragment : Fragment() {

    var m2: String=""

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_blank, container, false)

    }

    companion object {
        fun newInstance():Main2Activity{
            var main2=Main2Activity()
            return main2
        }
    }

    override fun onResume(){
        super.onResume()
        m2 = arguments.getString("23", "Error")

    }


}// Required empty public constructor
