package com.maro.githubuser.api

import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults
import io.realm.kotlin.where


/**
 * Created by Wanhar on 28/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
class RealmService(private val mRealm: Realm) {

    companion object{
        fun initDatabase(context: Context){
            Realm.init(context)
            val realmConfiguration = RealmConfiguration.Builder()
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build()
            Realm.setDefaultConfiguration(realmConfiguration)
        }
    }

    fun closeRealm() {
        mRealm.close()
    }
}