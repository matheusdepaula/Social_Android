package br.com.iesb.social.dao

import br.com.iesb.social.beans.User

interface PersistenceInterface {
    fun save(user: User)
    fun getAllUser(): List<String>
    fun delete(user: User)
    fun update()
}