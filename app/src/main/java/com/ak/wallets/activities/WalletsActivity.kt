package com.ak.wallets.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ak.wallets.R
import com.google.firebase.auth.FirebaseAuth

class WalletsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallets)

        val uid = FirebaseAuth.getInstance().uid
        Log.d("WalletActivity"," Working $uid")

        if(uid !== null){

            Toast.makeText(this,"Working...",Toast.LENGTH_LONG).show();

        }



    }
}
