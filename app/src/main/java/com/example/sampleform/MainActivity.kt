package com.example.sampleform

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Matcher
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("SetTextI18n")
    fun submitFunction(view: View){

        val fullName : String
        val spaceString : String = " "
        val emailPattern : String = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        val namePattern : String = "^[A-Za-z]+\$"
        val mobPattern : String = "[0-9]{10}"

        fullname_view.visibility = View.INVISIBLE
        out_email_view.visibility = View.INVISIBLE
        out_mob_view.visibility = View.INVISIBLE
        first_name_error.visibility = View.INVISIBLE
        first_name_error.visibility = View.INVISIBLE
        email_error.visibility = View.INVISIBLE
        mobile_no_error.visibility = View.INVISIBLE

        val fName : String = first_name_input?.text.toString()
        val lName : String = last_name_input?.text.toString()
        val eMail : String = email_input?.text.toString()
        val mNum = mobile_no_input?.text.toString()


        if( fName.trim() == "" || !fName.matches(namePattern.toRegex()) ){
            if (!fName.matches(namePattern.toRegex())) first_name_error.setText("Invalid first name")
            else first_name_error.setText("First name is Required")
            first_name_error.visibility = View.VISIBLE
        } else if (lName.trim() == "" || !lName.matches(namePattern.toRegex()) ){
            if (!lName.matches(namePattern.toRegex())) last_name_error.setText("Invalid Last name")
            else last_name_error.setText("Last name is Required")
            first_name_error.visibility = View.VISIBLE
        }else if ( eMail.trim() == "" || (!eMail.matches(emailPattern.toRegex())) ){
            if (eMail.trim() == "") email_error.setText("Email address required")
            else email_error.setText("Invalid Email address")
            email_error.visibility = View.VISIBLE
        } else if ((mNum.trim()) == "" || (!mNum.matches(mobPattern.toRegex()))) {
            if (!mNum.matches(mobPattern.toRegex())) mobile_no_error.setText("Invalid mobile number")
            else mobile_no_error.setText("Mobile number required")
            mobile_no_error.visibility = View.VISIBLE
        } else {
            fullName = fName + spaceString + lName
            fullname_view.setText(fullName)
            out_email_view.setText(eMail)
            out_mob_view.setText(mNum)

            fullname_view.visibility = View.VISIBLE
            out_email_view.visibility = View.VISIBLE
            out_mob_view.visibility = View.VISIBLE

        }



    }
}

