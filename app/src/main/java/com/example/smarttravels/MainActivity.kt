package com.example.smarttravels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var packagesRecyclerView: androidx.recyclerview.widget.RecyclerView
    private lateinit var bestForYouRecyclerView: androidx.recyclerview.widget.RecyclerView

    private lateinit var packageAdapter: PackageAdapter
    private lateinit var bestForYouAdapter: BestForYouAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        packagesRecyclerView = findViewById(R.id.packagesRecyclerView)
        bestForYouRecyclerView = findViewById(R.id.bestForYouRecyclerView)
        //Datos paises
        val countries = arrayOf(
            "Argentina", "Brasil", "Chile", "Colombia", "Ecuador",
            "España", "Estados Unidos", "Francia", "Italia", "México",
            "Perú", "Portugal", "Uruguay", "Venezuela"
        )
        // Datos de ejemplo para los paquetes
        val packages = listOf(
            Package("1", "Buceo y Bosques", "https://picsum.photos/200/300?random=6"),
            Package("2", "Tour a playa blanca", "https://picsum.photos/200/300?random=5"),
            // ... más paquetes
        )

        // Datos de ejemplo para "Best for you"
        val bestForYouItems = listOf(
            BestForYouAdapter.BestForYouItem("Aventura Pura Vida", "https://picsum.photos/200/300?random=2", "Rp. 2.500.000.000 / Year", "~ 6 People"),
            BestForYouAdapter.BestForYouItem("Escape Romántico", "https://picsum.photos/200/300?random=1", "Rp. 2.000.000.000 / Year", "~ 2 People"),
            BestForYouAdapter.BestForYouItem("Volcanes Vivos", "https://picsum.photos/200/300?random=3", "Rp. 500.000.000 / Year", "~ 2 People"),
            BestForYouAdapter.BestForYouItem("Sabor Local", "https://picsum.photos/200/300?random=4", "Rp. 900.000.000.000 / Year", "~ 5 People"),
            // ... más ítems
        )

        // Inicializar los adaptadores
        packageAdapter = PackageAdapter(packages)
        bestForYouAdapter = BestForYouAdapter(bestForYouItems)

        // Configurar el RecyclerView para paquetes
        packagesRecyclerView.layoutManager = LinearLayoutManager(this)
        packagesRecyclerView.adapter = packageAdapter

        // Configurar el RecyclerView para "Best for you"
        bestForYouRecyclerView.layoutManager = LinearLayoutManager(this)
        bestForYouRecyclerView.adapter = bestForYouAdapter

        // Configurar el AutoCompleteTextView con el ArrayAdapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, countries)
        val searchEditText = findViewById<AutoCompleteTextView>(R.id.searchEditText)
        searchEditText.setAdapter(adapter)
        searchEditText.threshold = 1
    }
}
