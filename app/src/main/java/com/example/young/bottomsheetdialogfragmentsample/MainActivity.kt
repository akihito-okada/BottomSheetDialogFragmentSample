package com.example.young.bottomsheetdialogfragmentsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.young.bottomsheetdialogfragmentsample.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState ?: supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
    }
}
