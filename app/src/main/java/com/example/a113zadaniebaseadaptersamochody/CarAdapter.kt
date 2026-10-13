package com.example.a113zadaniebaseadaptersamochody

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class CarAdapter(private val carList: List<Car>) : BaseAdapter() {
    override fun getCount(): Int {
        return carList.size
    }

    override fun getItem(position: Int): Any? = carList.getOrNull(position)

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val view = convertView ?: LayoutInflater.from(parent.context).inflate(R.layout.car_item_view, parent, false)

        val car = carList[position]

        view.findViewById<android.widget.ImageView>(R.id.ivCar).setImageResource(car.imageId)
        view.findViewById<android.widget.TextView>(R.id.tvTitle).text = car.name
        view.findViewById<android.widget.TextView>(R.id.tvDescription).text = car.description

        return view
    }
}