package com.example.smarttravels

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.smarttravels.databinding.ActivityTourPackageBinding
import com.google.android.material.navigation.NavigationView

class TourPackageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTourPackageBinding
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityTourPackageBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.publish.setOnClickListener() {
            Toast.makeText(this, "Package Published", Toast.LENGTH_LONG).show()
        }

        navigationView = findViewById(R.id.navigationView)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_profile -> {
                    // Acción para el item Profile
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_package -> {
                    // Acción para el item Package
                    true
                }

                R.id.nav_logout -> {
                    // Acción para el item Logout
                    // Aquí puedes implementar el código para cerrar sesión
                    true
                }

                else -> false
            }
        }

    }
}