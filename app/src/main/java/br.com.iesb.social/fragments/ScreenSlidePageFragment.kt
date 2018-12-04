package br.com.iesb.social.fragments

import android.content.Intent
import android.support.v4.app.Fragment
import br.com.iesb.social.R
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.iesb.social.activities.RegisterActivity
import kotlinx.android.synthetic.main.iesb_fragment.view.*

class ScreenSlidePageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.iesb_fragment, container, false)

        view.screen_title.setText(arguments?.getString("title") ?: "")
        view.screen_sub_title.setText(arguments?.getString("subTitle") ?: "")

        val position = arguments?.getInt("position")
        position.let {

            when (it) {
                0 -> view.page_image.setBackgroundResource(R.drawable.icon_pen)
                1 -> view.page_image.setBackgroundResource(R.drawable.icon_work)
                else -> view.page_image.setBackgroundResource(R.drawable.iesb_logo_branco)
            }

            view.page_image.setColorFilter(ContextCompat.getColor(context!!, R.color.colorAccent))

            if (it == 2) {
                view.enterButton.visibility = View.VISIBLE
                view.enterButton.setOnClickListener {
                    val intent = Intent(context, RegisterActivity::class.java)
                    startActivity(intent)
                }
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