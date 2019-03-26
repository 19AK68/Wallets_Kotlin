package com.ak.wallets.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.ak.wallets.R
import com.ak.wallets.model.User
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.jetbrains.anko.toast

class SignInActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG = "SignInActivity"
    private val database = FirebaseDatabase.getInstance()
    private val table_user = database.getReference("User")
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        Log.d(TAG, "onCreate")
        progressbar.visibility = View.INVISIBLE
        btn_enter.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        progressbar.visibility = View.VISIBLE
        table_user.addValueEventListener(object : ValueEventListener {


            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Check if user not exits in database
                if (dataSnapshot.child(edtPhone.text.toString()).exists()) {
                    progressbar.visibility = View.INVISIBLE
                    //Get User information
                    user = dataSnapshot.child(edtPhone.text.toString()).getValue(User::class.java)!!

                    if (user.Password == edtPassword.text.toString()) {

                        toast("Sign is successfully!")

                    } else {
                        toast("Wrong Password!")

                    }
                } else {
                    progressbar.visibility = View.INVISIBLE
                    toast("User not exist in Database")

                }
            }

            override fun onCancelled(dataError: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }

}
