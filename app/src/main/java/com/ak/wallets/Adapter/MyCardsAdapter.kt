package com.ak.wallets.Adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.ak.wallets.R
import com.ak.wallets.model.Cards
import com.squareup.picasso.Picasso

class MyCardsAdapter(
    private var context: Context,
    private var cardsList: List<Cards>
) : PagerAdapter() {

    private var inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view == o
    }

    override fun getCount(): Int {
        return cardsList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view = inflater.inflate(R.layout.view_pager_cards_item, container, false)


        val cards_image = view.findViewById<View>(R.id.cards_image) as ImageView
        val cards_title = view.findViewById<View>(R.id.card_title) as TextView
        val txt_balance = view.findViewById<View>(R.id.txt_balance) as TextView
        val txt_balance_sum = view.findViewById<View>(R.id.txt_sum_balance) as TextView

        //set data
        Picasso.get().load(cardsList[position].image).into(cards_image)
        txt_balance_sum.text = cardsList[position].Balance

        view.setOnClickListener {
            Toast.makeText(context, "Clicekd", Toast.LENGTH_SHORT).show()
        }

        container.addView(view)
        return view


    }
}
