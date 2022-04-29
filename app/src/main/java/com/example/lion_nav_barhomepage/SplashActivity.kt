package com.example.lion_nav_barhomepage

import android.app.PendingIntent.getActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.WindowManager
import androidx.activity.viewModels
import com.example.lion_nav_barhomepage.patientdashboard.patientdata
var patient_main_data = patientdata()
@Suppress("DEPRECATION")

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
//        viewModel.set_patientdata()
////        patientData= viewModel.getdata()
//        Log.e("In splash ::","${patientData}")

        val checklogin = sharedPreferences.getBoolean("logged", false)
        if (checklogin == true) {
            patient_main_data = patientdata(
                sharedPreferences.getString("logged_id",null),
                sharedPreferences.getString("logged_name",null),
                sharedPreferences.getString("logged_email",null),
                sharedPreferences.getString("logged_phone",null),
                sharedPreferences.getString("logged_img",null),
                sharedPreferences.getString("logged_gender",null),
                sharedPreferences.getString("logged_dob",null),
                sharedPreferences.getString("logged_weight",null),
                sharedPreferences.getString("logged_height",null),
            )
            Handler().postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 3500)
        }
        else {
            Handler().postDelayed({
                val intent = Intent(this, IntroActivity::class.java)
                startActivity(intent)
                finish()
            }, 3500)

        }
    }
}