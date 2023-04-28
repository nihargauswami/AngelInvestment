package com.example.angelinvestment.Model

import android.provider.ContactsContract.CommonDataKinds.Email

data class UserModel(
    var email : String? = null,
    var name: String? = null,
    var mobilenumber: String? = null,
    var companyname: String? = null,
    var currentdesignation:String? = null,
    var postaladdress:String? = null,
    var city : String? = null,
    var pincode : String? = null
)
