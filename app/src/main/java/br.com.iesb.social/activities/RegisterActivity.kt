package br.com.iesb.social.activities

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import br.com.iesb.social.R
import br.com.iesb.social.beans.User
import br.com.iesb.social.constants.PersistenceType
import br.com.iesb.social.dao.PersistenceFactory
import kotlinx.android.synthetic.main.register_screen.*

class RegisterActivity: FragmentActivity() {

    private lateinit var mName: String
    private lateinit var mEmail: String
    private lateinit var mCity: String
    private lateinit var mState: String
    private lateinit var mPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.register_screen)

        enter_new_account.setOnClickListener {
            didRegisterNewUser()
        }
    }

    fun didRegisterNewUser() {

        mName = name.text.toString()
        mEmail = email.text.toString()
        mCity = city.text.toString()
        mState = state.text.toString()
        mPassword = password.text.toString()

        val user = User(mName, mEmail, mPassword, mCity, mState)

        val persistence = PersistenceFactory().getPersistenceDAO(PersistenceType.FILE)
        persistence.save(user)

        val data = persistence.getAllUser()
    }
}