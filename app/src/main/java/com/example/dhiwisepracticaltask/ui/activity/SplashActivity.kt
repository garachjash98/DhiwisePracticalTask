package com.example.dhiwisepracticaltask.ui.activity

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.dhiwisepracticaltask.R
import com.example.dhiwisepracticaltask.databinding.ActivityHomeBinding
import com.example.dhiwisepracticaltask.databinding.ActivitySplashBinding
import com.example.dhiwisepracticaltask.utils.launchActivity

class SplashActivity : AppCompatActivity() {

    private var _binding: ActivitySplashBinding? = null
    private val storagePermissionRequestCode = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(_binding?.root)
        init()
    }

    private fun init() {
        checkPermissions()
    }

    private fun checkPermissions() {
        val readPermission = ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )
        val writePermission = ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

        if (readPermission != PackageManager.PERMISSION_GRANTED || writePermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions()
        } else {
            openHomeScreen()
        }
    }

    private fun requestPermissions() {
        val permissions = arrayOf(
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        ActivityCompat.requestPermissions(this, permissions, storagePermissionRequestCode)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            storagePermissionRequestCode ->{
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    openHomeScreen()
                } else {
                    openHomeScreen()
                }
            }
        }
    }

    private fun openHomeScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            launchActivity(HomeActivity::class.java)
            finish()
        }, 2000)
    }
}