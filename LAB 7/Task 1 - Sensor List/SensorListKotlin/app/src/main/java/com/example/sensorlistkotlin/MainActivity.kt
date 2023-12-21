package com.example.sensorlistkotlin

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    //SensorManager senseMan;
    private lateinit var senseMan: SensorManager

    //ListView lv;
    private lateinit var lv: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //lv = (ListView) findViewById(R.id.listview);
        lv = findViewById(R.id.listview)

        //senseMan = (SensorManager) getSystemService(SENSOR_SERVICE);
        senseMan = getSystemService(SENSOR_SERVICE) as SensorManager

        //List<Sensor> sensorList = senseMan.getSensorList(Sensor.TYPE_ALL);
        val sensorList: List<Sensor> = senseMan.getSensorList(Sensor.TYPE_ALL)

        //lv.setAdapter(new ArrayAdapter<Sensor>(this, android.R.layout.simple_list_item_1, sensorList));
        lv.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sensorList)
    }
}