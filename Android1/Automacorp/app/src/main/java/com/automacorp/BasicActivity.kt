package com.automacorp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

open class BasicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_rooms -> startActivity(
                Intent(this, RoomsActivity::class.java)
            )
            R.id.menu_website -> startActivity(
                Intent(Intent.ACTION_VIEW, Uri.parse("https://dev-mind.fr"))
            )
            R.id.menu_email -> startActivity(
                Intent(Intent.ACTION_SENDTO, Uri.parse("mailto://guillaume@dev-mind.fr"))
            )

        }
        return super.onContextItemSelected(item)
    }
}