package com.abhinav.inohub.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.abhinav.inohub.R
import com.abhinav.inohub.fragment.AboutUsFragment
import com.abhinav.inohub.fragment.HomeFragment
import com.abhinav.inohub.fragment.FundingFragment
import com.abhinav.inohub.fragment.ResourceFragment
import com.abhinav.inohub.fragment.StartupFragment
import com.abhinav.inohub.fragment.MentorFragment
import com.abhinav.inohub.fragment.InvestorFragment
import com.google.android.material.navigation.NavigationView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var navigationLayout: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer)
        toolbar = findViewById(R.id.toolbar)
        navigationLayout = findViewById(R.id.navigation)

        setUpToolbar()
        openDashboard()

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.open,
            R.string.close
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationLayout.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    Toast.makeText(this@MainActivity, "Home", Toast.LENGTH_SHORT).show()
                    openDashboard()
                }
                R.id.startup -> {
                    Toast.makeText(this@MainActivity, "Startup", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, StartupFragment())
                        .commit()
                }
                R.id.mentor -> {
                    Toast.makeText(this@MainActivity,"Mentors", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, MentorFragment())
                        .commit()
                }
                R.id.funding -> {
                    Toast.makeText(this@MainActivity,"Funding", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, FundingFragment())
                        .commit()
                }
                R.id.resource -> {
                Toast.makeText(this@MainActivity,"Resource", Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, ResourceFragment())
                    .commit()
                }
                R.id.investor -> {
                    Toast.makeText(this@MainActivity, "Investor", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, InvestorFragment())
                        .commit()
                }
                R.id.about_us -> {
                    Toast.makeText(this@MainActivity, "About Us", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, AboutUsFragment())
                        .commit()
                }
                R.id.logout -> {
                    sharedPreferences = getSharedPreferences(getString(R.string.Preferences_file_name), MODE_PRIVATE)
                    sharedPreferences.edit().putBoolean("isLoggedIn", false).apply()
                    sharedPreferences.edit().remove("title").apply()
                    Toast.makeText(this, "You have been logged out successfully", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Ino Hub"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openDashboard() {
        val fragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
        supportActionBar?.title = "Ino Hub"
        navigationLayout.setCheckedItem(R.id.home)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
