package com.shapp.todorpg

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    public val DATABASE_VERSION: Int = 1
    public val DATABASE_NAME: String = "contactDb"
    public val TABLE_CONTACTS: String = "contactsDb"

    public val KEY_ID: String = "_id"
    public val KEY_NAME: String = "name"
    public val KEY_MAIL: String = "mail"




    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table" + TABLE_CONTACTS + "(" + KEY_ID + " integer primary key,"
                + KEY_NAME + " text," + KEY_MAIL + " trxt" + ")")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists " + TABLE_CONTACTS)

        onCreate(db)
    }
}