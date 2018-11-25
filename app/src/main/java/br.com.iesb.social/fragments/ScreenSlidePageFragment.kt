package br.com.iesb.social.fragments

import android.support.v4.app.Fragment
import br.com.iesb.social.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ScreenSlidePageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? = inflater!!.inflate(R.layout.iesb_fragment, container, false)
}