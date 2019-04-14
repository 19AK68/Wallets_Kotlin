package com.ak.wallets.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

import com.ak.wallets.R
import com.ak.wallets.model.Cards
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_wallets.*
import org.jetbrains.anko.toast

class WalletsActivity : AppCompatActivity() {

    private val TAG = "WalletsActivity"
    private val database = FirebaseDatabase.getInstance()
    private val table_catds = database.getReference("Cards")
    private lateinit var cards: Cards



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallets)

        val nameBank = findViewById<TextView>(R.id.tv_bank_name)
        val numberCard_4 = findViewById<TextView>(R.id.tv_card_number4)
        val cardcolder = findViewById<TextView>(R.id.tv_card_holder)


        Log.d(TAG,"onCreate")

        initData()




    }

    private fun initData() {

        table_catds.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Check if cards not exits in database
                if(dataSnapshot.child("01").exists()){
                    cards = dataSnapshot.child("01").getValue(Cards::class.java)!!
                    Log.d(TAG, " Card in base")
                    tv_bank_name.text = cards.Bank_name

                } else{
                    toast("Cards not exist in Database")
                }

            }


            override fun onCancelled(databaseErroe: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }


        })
    }
}
