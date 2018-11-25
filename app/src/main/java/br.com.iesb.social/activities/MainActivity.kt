package br.com.iesb.social.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.iesb.social.R
import android.content.Intent



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(object : Runnable {
            override fun run() {
                val intent = Intent(this@MainActivity, ScreenSlidePagerActivity::class.java)
                startActivity(intent)
            }
        }, 2000)
    }
}
