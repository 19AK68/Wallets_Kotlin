package com.ak.wallets.Interface

import com.ak.wallets.model.Cards

interface IFireStoreLoadDone {
    fun onFireStoreLoadSuccess(cardsList:List<Cards>)
    fun onFireStoreLoadFailed(message:String)

}