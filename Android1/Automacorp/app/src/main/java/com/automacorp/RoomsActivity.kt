package com.automacorp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.automacorp.adapter.RoomsAdapter
import com.automacorp.service.ApiServices
import com.automacorp.service.RoomService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoomsActivity : BasicActivity(), RoomsAdapter.OnRoomClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rooms)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val roomsAdapter = RoomsAdapter(this)

        findViewById<RecyclerView>(R.id.list_rooms).also { recyclerView -> // (1)
            recyclerView.layoutManager = LinearLayoutManager(this) // (2)
            recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL)) // (3)
            recyclerView.setHasFixedSize(true) // (4)
            recyclerView.adapter = roomsAdapter // (5)
        }

        lifecycleScope.launch(context = Dispatchers.IO) { // (1)
            runCatching { ApiServices.roomsApiService.findAll().execute() }
                .onSuccess {
                    withContext(context = Dispatchers.Main) { // (2)
                        roomsAdapter.setItems(it.body() ?: emptyList()) }
                }
                .onFailure {
                    withContext(context = Dispatchers.Main) {
                        it.printStackTrace()
                        Toast.makeText(applicationContext, "Error on rooms loading $it", Toast.LENGTH_LONG)
                            .show()  // (3)
                    }
                }
        }
    }

    override fun selectRoom(id: Long) {
        val intent = Intent(this, RoomActivity::class.java).putExtra(MainActivity.ROOM_ID_PARAM, id)
        startActivity(intent)
    }
}
