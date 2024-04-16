package com.nimbuzz.photoapp.ui.screens.activity

import android.Manifest
import android.app.Activity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.nimbuzz.photoapp.ui.screens.mainscreen.MainScreen
import com.nimbuzz.photoapp.ui.theme.NimBuzzAppTheme
import dagger.hilt.android.AndroidEntryPoint

private const val REQUEST_CODE_STORAGE = 100

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val splashViewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition { splashViewModel.isLoading.value }
        }
        setContent {
            NimBuzzAppTheme {
                MainScreen()
            }
        }
    }

    fun requestStoragePermission(context: Activity) {
        val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        ActivityCompat.requestPermissions(context, permissions, REQUEST_CODE_STORAGE)
    }

}