package com.example.smarttravels

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttravels.MainActivity

class Login : AppCompatActivity() {

    private lateinit var signInButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) // Reemplaza "tu_layout_login" con el nombre real de tu layout

        // Inicializar el botón de inicio de sesión
        signInButton = findViewById(R.id.signInButton)

        // Configurar el OnClickListener para el botón de inicio de sesión
        signInButton.setOnClickListener {
            // Crear un Intent para iniciar la MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // Finalizar la actividad actual (opcional, dependiendo de tu flujo de navegación)
            finish()
        }

        // Resto de tu código...
    }
}
