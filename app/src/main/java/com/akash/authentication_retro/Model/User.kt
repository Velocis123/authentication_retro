package com.akash.authentication_retro.Model

class User{


    private var username: String? = null
    private var password: String? = null
    private var email: String? = null
    private var gender: String? = null

    constructor(username: String?, password: String?, email: String?, gender: String?) {
        this.username = username
        this.password = password
        this.email = email
        this.gender = gender
    }


    fun getUsername(): String? {
        return username
    }

    fun setUsername(username: String) {
        this.username = username
    }

    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun getGender(): String? {
        return gender
    }

    fun setGender(gender :String)
    {
        this.gender = gender


    }


}






