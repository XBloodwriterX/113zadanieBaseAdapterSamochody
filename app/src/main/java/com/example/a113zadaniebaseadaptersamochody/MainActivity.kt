package com.example.a113zadaniebaseadaptersamochody

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val carList = listOf(
        Car(R.drawable.captur, "Renault Captur", "Opis samochodu 1"),
        Car(R.drawable.leon, "Seat Leon", "Opis samochodu 2"),
        Car(R.drawable.octavia, "Skoda Octavia", "Opis samochodu 3"),
        Car(R.drawable.trafic, "Renault Trafic", "Opis samochodu 4"),
    )
    private val lvCars: ListView by lazy { findViewById(R.id.lvCars) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvCars.adapter = CarAdapter(carList)

        lvCars.setOnItemClickListener { parent, view, position, id ->
            val selectedCar = parent.getItemAtPosition(position) as Car
            val intent = Intent(this, CarFormActivity::class.java).apply {
                putExtra("car", selectedCar)
            }
            startActivity(intent)
        }
    }
}