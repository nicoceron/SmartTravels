package com.example.smarttravels

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView

class DetallePackageActivity : AppCompatActivity() {

    private lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package)

        // Aquí puedes inicializar cualquier elemento de la vista, por ejemplo:
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
