package com.yarenbergi.yemekbul.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.yarenbergi.yemekbul.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin.setOnClickListener {
            validate()
        }

    }

    private fun validate(){
        val isEmailValid = validateEmail()
        val isPasswordValid = validatePassword()

        if (isEmailValid && isPasswordValid){
            showSucces()
        }
    }

    private fun validateEmail():Boolean{
        val email= editTextEmail.text.toString()

        if(email.isEmpty()){
            textInputLayoutEmail.error = getString(R.string.emailEmptyErrorMessage)
            return false
        }

        if(Patterns.EMAIL_ADDRESS.matcher(email).matches().not()){
            textInputLayoutEmail.error = getString(R.string.emailInvalidErrorMessage)
            return false
        }

        textInputLayoutEmail.error = null
        return true
    }

    private fun validatePassword():Boolean{
        val password = editTextPassword.text.toString()

        if(password.length < 8){
            textInputLayoutPassword.error = getString(R.string.passwordInvalidErrorMessage)
            return false
        }

        textInputLayoutPassword.error = null
        return true
    }

    fun showSucces(){
        val email = editTextEmail.text.toString()
        val name = email.substringBefore("@")
        toast(getString(R.string.loginSucces, name))
    }

    private fun toast(text: String){
        Toast.makeText(this, "Hoşgeldiniz!", Toast.LENGTH_LONG).show()
    }

}