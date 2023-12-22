package com.automacorp

//noinspection SuspiciousImport
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity


class MainActivity : BasicActivity() {
    companion object {
        const val WINDOW_NAME_PARAM = "com.automacorp.windowname.attribute"
        const val ROOM_ID_PARAM = "com.automacorp.roomid.attribute"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    /** Called when the user taps the button */
    fun openWindow(view: View) {
        // Extract value filled in editext identified with txt_window_name id
        val windowName = findViewById<EditText>(R.id.txt_window_name).text.toString()
//        // Display a message
//        Toast.makeText(this, "You choose $windowName", Toast.LENGTH_LONG).show()
        val intent = Intent(this, WindowActivity::class.java).apply {
            putExtra(WINDOW_NAME_PARAM, windowName)
        }
        startActivity(intent)
    }
    fun openRoom(view: View) {
        val intent = Intent(this, RoomActivity::class.java).apply {
            putExtra(ROOM_ID_PARAM, 1L)
        }
        startActivity(intent)
    }
}
