package com.example.yourname.bottomnav_fragment_drawer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.yourname.bottomnav_fragment_drawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val personFragment = PersonFragment()
        val settingFragment = SettingFragment()


        binding.bottomBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.person -> setCurrentFragment(personFragment)
                R.id.setting -> setCurrentFragment(settingFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentLayout,fragment).commit()
        }

    }
}