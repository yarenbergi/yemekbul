package com.yarenbergi.yemekbul.activity

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.database.AppDatabase
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedInputStream
import java.io.File


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth
        val currentUser = auth.currentUser
        if(currentUser == null){
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        navController = findNavController(R.id.navHostFragment)
        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.recipesFragment,
                R.id.favoriteRecipesFragment,
                R.id.shoppingListFragment
         )
        )

        bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)


        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()

        StrictMode.setThreadPolicy(policy)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onStop() {

        super.onStop()

        //updating ingredients.csv on google storage
        var file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/ingredients.csv")
        auth = Firebase.auth
        val currentUser = auth.currentUser
        val storage = Firebase.storage
        val storageRef = storage.reference
        if (currentUser != null) {
            if(currentUser.email!= null){
                val fileRef = storageRef.child(currentUser?.email.toString() + "/" + "ingredients.csv")
                val os = BufferedInputStream(file.inputStream())
                var uploadTask = fileRef.putStream(os)
                uploadTask.addOnFailureListener {
                    // Handle unsuccessful uploads
                    println("Failure in upload")
                }.addOnSuccessListener { taskSnapshot ->
                    // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
                    // ...
                    println("Success")
                    println(currentUser.isAnonymous)
                }
            }
        }

    }
}