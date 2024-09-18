package com.example.yourname.bottomnav_fragment_drawer

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.yourname.bottomnav_fragment_drawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var acttionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        acttionBarDrawerToggle = ActionBarDrawerToggle(this,binding.drawerLayout,R.string.nav_open,R.string.nav_close)

        binding.drawerLayout.addDrawerListener(acttionBarDrawerToggle)
        acttionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val homeFragment = HomeFragment()
        val personFragment = PersonFragment()
        val settingFragment = SettingFragment()

        setCurrentFragment(homeFragment)


        binding.bottomBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.person -> setCurrentFragment(personFragment)
                R.id.setting -> setCurrentFragment(settingFragment)
            }
            true
        }
        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    setCurrentFragment(homeFragment)
                    binding.drawerLayout.closeDrawers()
                }
                R.id.person -> {
                    setCurrentFragment(personFragment)
                    binding.drawerLayout.closeDrawers()
                }
                R.id.setting -> {
                    setCurrentFragment(settingFragment)
                    binding.drawerLayout.closeDrawers()
                }
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentLayout,fragment).commit()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(acttionBarDrawerToggle.onOptionsItemSelected(item)){
            true
        }
        else super.onOptionsItemSelected(item)
    }
}