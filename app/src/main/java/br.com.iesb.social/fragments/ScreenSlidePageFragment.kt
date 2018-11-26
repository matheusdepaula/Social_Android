package br.com.iesb.social.fragments

import android.support.v4.app.Fragment
import br.com.iesb.social.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.iesb_fragment.view.*

class ScreenSlidePageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.iesb_fragment, container, false)

        view.screen_title.setText(arguments?.getString("title") ?: "")
        view.screen_sub_title.setText(arguments?.getString("subTitle") ?: "")

        val position = arguments?.getInt("position")
        position.let {
            if (it == 3) {
                view.enterButton.visibility = View.VISIBLE
            }
        }

        return view
    }

    companion object {
        fun instance(position: Int, title: String, subTitle: String): ScreenSlidePageFragment {
            val fragment = ScreenSlidePageFragment()
            val args = Bundle()
            args.putInt("position", position)
            args.putString("title", title)
            args.putString("subTitle", subTitle)
            fragment.setArguments(args)

            return fragment
        }
    }
}