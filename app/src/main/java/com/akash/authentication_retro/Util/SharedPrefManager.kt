package com.akash.authentication_retro.Util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.akash.authentication_retro.Activity.LoginRetro
import com.akash.authentication_retro.Model.User

class SharedPrefManager{



    private val SHARED_PREF_NAME:String = "retrofitreisterlogin"
    private val KEY_USERNAME:String = "username"
    private val KEY_EMAIL:String = "keyemail"




    private  var ctx: Activity
    var mInstance: SharedPrefManager? = null

    public constructor(context: Activity){

        ctx=context
    }

    public fun getInstance(contxt : Activity): SharedPrefManager {
        if (mInstance == null){

            mInstance = SharedPrefManager(contxt)


        }
        return mInstance as SharedPrefManager

    }



//    public fun userLogin (user: User){
//
//        var sharedPreferences:SharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE)
//
//
//        var editor:SharedPreferences.Editor = sharedPreferences.edit()
//        editor.putInt(KEY_ID, user.getId()!!)
//editor.putString(KEY_USERNAME,user.getName())
//        editor.putString(KEY_EMAIL,user.getEmail())
//        editor.putString(KEY_GENDER,user.getGender())
//
//        editor.apply()
//
//    }

    public fun isLoggedIn():Boolean{

        var sharedPreferences: SharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(KEY_USERNAME,null)!=null

    }





}