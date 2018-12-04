package br.com.iesb.social.dao

import br.com.iesb.social.beans.User
import java.io.File

class UserDAOFile: PersistenceInterface {

    private val fileName = "usuario_iesb.txt"

    override fun getAllUser(): List<String>
            = File(fileName).bufferedReader().readLines()

    override fun save(user: User) {
        File(fileName).bufferedWriter().use {
            it.write("nome: ${user.name}")
            it.write("email: ${user.email}")
            it.write("password: ${user.password}")
            it.write("city: ${user.city}")
            it.write("state: ${user.state}")
        }
    }

    override fun delete(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}