package com.ak.wallets.activities

import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ak.wallets.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    //val face = Typeface.createFromAsset(assets, "fonts/PermanentMarker-Regular.TTF")!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  text_slog.setTypeface(face);

        btn_sign_in.setOnClickListener(this)
        btn_sign_up.setOnClickListener(this)

    }
    override fun onClick(view: View?) {
        when(view?.id)
        {
            R.id.btn_sign_in ->{
                startActivity(Intent(this, SignInActivity::class.java))
            }

            R.id.btn_sign_up ->{
                startActivity(Intent(this, SignUpActivity::class.java))
            }
        }


    }

}
