package com.example.smarttravels

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView

class ProfileActivity : AppCompatActivity() {
    private lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile) // Reemplaza con el nombre de tu XML/layout
        // Otro código de inicialización si es necesario

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
