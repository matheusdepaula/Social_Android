package br.com.iesb.social.dao

import br.com.iesb.social.constants.PersistenceType

class PersistenceFactory {

    fun getPersistenceDAO(type: PersistenceType): PersistenceInterface {
        when (type) {
            PersistenceType.FILE -> return UserDAOFile()
            else -> return UserDAOFile()
        }
    }
}