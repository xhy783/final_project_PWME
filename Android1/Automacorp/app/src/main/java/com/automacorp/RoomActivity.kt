package com.automacorp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.automacorp.service.RoomService

class RoomActivity : BasicActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val roomId = intent.getLongExtra(MainActivity.ROOM_ID_PARAM, 0)
        val room = RoomService.ROOMS.firstOrNull {it.id == roomId}

        val roomName = findViewById<EditText>(R.id.txt_room_name)
        roomName.setText ( room?.name ?: "")

        val roomCurrentTemperature = findViewById<EditText>(R.id.txt_room_current_temperature)
        roomCurrentTemperature.setText(room?.currentTemperature?.toString() ?: "")

        val roomTargetTemperature = findViewById<EditText>(R.id.txt_room_target_temperature)
        roomTargetTemperature.setText(room?.targetTemperature?.toString() ?: "")
    }
}