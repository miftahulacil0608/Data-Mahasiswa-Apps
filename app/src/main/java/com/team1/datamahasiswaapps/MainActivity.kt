package com.team1.datamahasiswaapps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.team1.datamahasiswaapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(binding.root)
        setupNavigationWithAppbar()
    }

    private fun setupNavigationWithAppbar(){
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        setupActionBarWithNavController(navHost.navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        return host.navController.navigateUp() || super.onSupportNavigateUp()
    }
}