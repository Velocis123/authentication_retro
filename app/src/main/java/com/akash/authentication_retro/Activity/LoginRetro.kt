package com.akash.authentication_retro.Activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.akash.authentication_retro.Api.Api
import com.akash.authentication_retro.Api.ApiService
import com.akash.authentication_retro.R
import com.akash.authentication_retro.Util.SharedPrefManager
import com.akash.authentication_retro.Model.User
import kotlinx.android.synthetic.main.activity_login_retro.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginRetro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_retro)

        var  sharedPrefManager = SharedPrefManager(this)
        if (sharedPrefManager.getInstance(this).isLoggedIn()){

            finish()
            this.startActivity(Intent(this, RegisterRetro::class.java))


        }



        btn_login.setOnClickListener {

            var username: String = edt_login_email.text.toString()
            var password = edt_login_pass.text.toString()
//            var email = edt_register_email.text
//var gender:String
//            radio1.check(R.id.male)
//
//            val v: RadioButton =findViewById(radio1.checkedRadioButtonId)
//            gender= v.text.toString()
            userlogin(username, password);


        }

btn_register.setOnClickListener {


    var intent  :Intent = Intent(applicationContext, RegisterRetro::class.java)

    startActivity(intent)


}
    }

    private fun userlogin(username: String?, password: String?) {
        var  api: Api = Api()

        val retrofit = Retrofit.Builder()
            .baseUrl(api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        var service : ApiService =  retrofit.create(ApiService::class.java)
                var call:Call<User> = service.loginuser(username,password)

        call.enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {

                Toast.makeText(applicationContext,"Error",Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                val sharedPreferences =
                    applicationContext.getSharedPreferences("retrofitreisterlogin", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("username", username)
                editor.commit()

                Toast.makeText(applicationContext, "Login Sucessfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, LoginRetro::class.java)
                startActivity(intent)



            }


        }







        )




    }


}
