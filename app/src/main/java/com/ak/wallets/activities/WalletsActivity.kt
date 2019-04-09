package com.ak.wallets.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import android.widget.Toast
import com.ak.wallets.Adapter.MyCardsAdapter
import com.ak.wallets.Interface.IFireStoreLoadDone
import com.ak.wallets.R
import com.ak.wallets.model.Cards
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_wallets.*

class WalletsActivity : AppCompatActivity(), IFireStoreLoadDone {
    override fun onFireStoreLoadSuccess(cardsList: List<Cards>) {
        adapter = MyCardsAdapter(this, cardsList)
        view_pager.adapter = adapter
        dialog.dismiss()
    }

    override fun onFireStoreLoadFailed(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        dialog.dismiss()
    }

    lateinit var adapter: MyCardsAdapter
    lateinit var cards: CollectionReference
    lateinit var iFirebaseStoreLoadDone: IFireStoreLoadDone
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallets)

        //init
        iFirebaseStoreLoadDone = this

        dialog = SpotsDialog.Builder().setContext(this).build()

        cards = FirebaseFirestore.getInstance().collection("Cards")
        getData()
    }

    private fun getData() {

        dialog.show()
        cards.get()
            .addOnFailureListener { e -> iFirebaseStoreLoadDone.onFireStoreLoadFailed(e.message!!) }
            .addOnCompleteListener { task ->
                val cardsList = ArrayList<Cards>()

                if (task.isSuccessful) {
                    for (card in task.result!!) {
                        val cardsItem = card.toObject(Cards::class.java)
                        cardsList.add(cardsItem)

                    }
                    iFirebaseStoreLoadDone.onFireStoreLoadSuccess(cardsList)
                }
            }


    }

}
