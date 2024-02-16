package com.automacorp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.automacorp.R
import com.automacorp.model.RoomDto

class RoomsAdapter(val listener: OnRoomClickListener) : RecyclerView.Adapter<RoomsAdapter.RoomsViewHolder>() { // (1)

    interface OnRoomClickListener {
        fun selectRoom(id: Long)
    }

    inner class RoomsViewHolder(view: View) : RecyclerView.ViewHolder(view) { // (2)
        val name: TextView = view.findViewById(R.id.txt_room_name)
        val currentTemperature: TextView = view.findViewById(R.id.txt_current_temperature)
    }

    private val items = mutableListOf<RoomDto>() // (3)

    fun setItems(rooms: List<RoomDto>) {  // (4)
        items.clear()
        items.addAll(rooms)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size // (5)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomsViewHolder { // (6)
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_rooms_item, parent, false)
        return RoomsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomsViewHolder, position: Int) {  // (7)
        val roomDto = items[position]
        holder.apply {
            name.text = roomDto.name
            currentTemperature.text = roomDto.currentTemperature?.toString() ?: "?"
            itemView.setOnClickListener { listener.selectRoom(roomDto.id) }
        }
    }

    override fun onViewRecycled(holder: RoomsViewHolder) { // (2)
        super.onViewRecycled(holder)
        holder.apply {
            itemView.setOnClickListener(null)
        }

    }
}