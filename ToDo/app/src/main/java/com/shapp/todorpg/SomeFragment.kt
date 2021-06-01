package com.shapp.todorpg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment, container, false)

        val tvValue = view.findViewById<TextView>(R.id.tv_value)?.apply {
            text = arguments?.getString("tv_value")
        }

        val tvValue2 = view.findViewById<TextView>(R.id.tv_value2)?.apply {
            text = arguments?.getString("tv_value2")
        }

        return view

    }

    companion object {
        fun newInstance(tv_value: String, tv_value2: String): SomeFragment {
            val args = Bundle()
            args.putString("tv_value", tv_value)
            args.putString("tv_value2", tv_value2)
            val fragment = SomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

}