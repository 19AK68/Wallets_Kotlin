package com.ak.wallets.activities

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ak.wallets.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var face = Typeface.createFromAsset(assets, "fonts/PermanentMarker-Regular.TTF");
        text_slog.setTypeface(face);

    }


}
