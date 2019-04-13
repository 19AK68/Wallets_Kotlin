package com.ak.wallets.model

data class Cards (
    var Balance: String ="0.00",
    var Bank_name: String ="MY BANK",
    var Card_number_1: String ="0000",
    var Card_number_2: String ="0000",
    var Card_number_3: String ="0000",
    var Card_number_4: String ="0000",
    var Code_cvv: String ="000",
    var Currency: String ="UAH",
    var End_month: String ="00",
    var Enf_year: String ="00 ",
    var First_name: String? = null,
    var Last_name: String? = null ,
    var Title : String? = null,
    var image : String? = null

)