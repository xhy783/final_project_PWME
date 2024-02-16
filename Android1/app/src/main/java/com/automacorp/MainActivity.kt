package com.automacorp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.automacorp.ui.theme.AutomacorpTheme

class MainActivity : BasicActivity() {
    companion object {
        val ROOM_ID_PARAM = "com.automacorp.roomid.attribute"
        const val WINDOW_NAME_PARAM = "com.automacorp.windowname.attribute"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun openRoom(view: View) {
        val intent = Intent(this, RoomActivity::class.java).apply {
            putExtra(ROOM_ID_PARAM, 1L)
        }
        startActivity(intent)
    }
}


