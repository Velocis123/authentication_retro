package com.akash.authentication_retro.Activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.akash.authentication_retro.Api.Api
import com.akash.authentication_retro.Api.ApiService
import com.akash.authentication_retro.Model.User
import com.akash.authentication_retro.R
import com.akash.authentication_retro.Util.SharedPrefManager
import kotlinx.android.synthetic.main.activity_register_retro.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterRetro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_retro)

        var  sharedPrefManager = SharedPrefManager(this)
        if (sharedPrefManager.getInstance(this).isLoggedIn())
        {


            this.startActivity(Intent(this, MainActivity::class.java))
            return
        }


btn_regist.setOnClickListener {

    var username :String = edt_register_userame.text.toString()
    var password :String = edt_register_pass.text.toString()
    var email :String = edt_register_email.text.toString()

    radio1.check(R.id.male)

    val v: RadioButton =findViewById(radio1.checkedRadioButtonId)
    var gender = v.text.toString()

    createuser(username,password,email,gender)



}

    }

    private fun createuser(username: String?, password: String?,email:String?,gender:String?) {
        var  api: Api = Api()

        val retrofit = Retrofit.Builder()
            .baseUrl(api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        var service : ApiService =  retrofit.create(ApiService::class.java)
        var call:Call<User> = service.registeruser(username,password,email,gender)

        call.enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {

                Toast.makeText(applicationContext,"Error",Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<User>, response: Response<User>) {


                Toast.makeText(applicationContext, "Registered Sucessfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, LoginRetro::class.java)
                startActivity(intent)



            }


        }







        )




    }











}

