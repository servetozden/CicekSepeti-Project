package com.example.ciceksepeti.activity

import androidx.appcompat.app.AppCompatActivity
import com.example.ciceksepeti.R

open class BaseActivity() : AppCompatActivity() {


    protected fun replaceFragmentAtMainContainer(
        fragmentManager: androidx.fragment.app.FragmentManager, backStackName: String, fragment: androidx.fragment.app.Fragment) {
        fragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            .replace(R.id.containerFragment, fragment)
            .addToBackStack(backStackName)
            .commitAllowingStateLoss()
    }
}