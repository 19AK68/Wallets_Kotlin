package com.ak.wallets.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ak.wallets.R
import com.ak.wallets.model.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.toast

class SignUpActivity : AppCompatActivity(),  View.OnClickListener  {
    private val TAG = "SignUpActivity"
    private val database = FirebaseDatabase.getInstance()
    private val table_user = database.getReference("User")
    private lateinit var user: User
    private var operation = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        progressbar.visibility = View.INVISIBLE
        btn_enter.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        progressbar.visibility = View.VISIBLE


        table_user.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                var TagOK = "OK"
                // check if already user phone

                if(!dataSnapshot.child(edtPhone.text.toString()).exists() ){
                    val mName = edtName.text.toString()
                    val mPass = edtPassword.text.toString()
                    if(mName.isNotEmpty()&&mPass.isNotEmpty()){
                        var user = User(mName, mPass)
                        table_user.child(edtPhone.text.toString()).setValue(user)
                        progressbar.visibility = View.INVISIBLE
                        toast("Sign Up successfully!!!")
                        operation = TagOK
                        finish()

                    } else {
                        progressbar.visibility = View.INVISIBLE
                        toast("Please enter full name and password ")
                    }

                } else {
                    progressbar.visibility = View.INVISIBLE
                    if(operation != TagOK){
                        toast("Phone Number already registe")
                    }

                }

//
//                if(dataSnapshot.child(edtPhone.text.toString()).exists()){
//                    toast("Phone Number already registe")
//                } else {
//                    progressbar.visibility = View.INVISIBLE
//                    val mName = edtName.text.toString()
//                    val mPass = edtPassword.text.toString()
//
//                    if(mName.isEmpty() && mPass.isEmpty()){
//                        toast("Please enter full name and password ")
//                    } else {
//                        progressbar.visibility = View.INVISIBLE
//                        var user = User(mName, mPass)
//                        table_user.child(edtPhone.text.toString()).setValue(user)
//                        toast("Sign Up successfully!!!")
//                        finish()
//
//                    }
//
//                }

            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })

    }
}
