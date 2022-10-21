package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class newActivity extends AppCompatActivity {
 EditText phonenumber,phonenumbercall,sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        connect();
    }

    private void connect() {
        phonenumber=findViewById(R.id.editTextPhone);
        phonenumbercall=findViewById(R.id.editTextPhone2);
        sms=findViewById(R.id.editTextTextPersonName);
}

    public void call(View view) {
        String phonenumbers=phonenumber.getText().toString();

        if(!checkphonenum(phonenumbers)){
            Toast.makeText(this, "phone number is not correct", Toast.LENGTH_SHORT).show();
            return;}

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phonenumbers, null));
        startActivity(intent);


              /*  Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "Your Phone_number"));
                startActivity(intent);*/


            //call activity
        }




    private boolean checkphonenum(String phonenumber) {

        if (phonenumber.matches("\\d{10}"))
            return true;
            // validating phone number with -, . or spaces
        else if (phonenumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
            return true;
            // validating phone number with extension length from 3 to 5
        else if (phonenumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
            return true;
            // validating phone number where area code is in braces ()
        else if (phonenumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
            return true;
            // Validation for India numbers
        else if (phonenumber.matches("\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}"))
            return true;
        else if (phonenumber.matches("\\(\\d{5}\\)-\\d{3}-\\d{3}"))
            return true;

        else if (phonenumber.matches("\\(\\d{4}\\)-\\d{3}-\\d{3}"))
            return true;
            // return false if nothing matches the input
        else
            return false;
    }


    public void sms(View view) {
        String phonenumbers = phonenumber.getText().toString();
        String smss = sms.getText().toString();

        if (!checkphonenum(phonenumbers)) {
            Toast.makeText(this, "phone number is not correct", Toast.LENGTH_SHORT).show();
            return;}
        else{
            SmsManager smsB = SmsManager.getDefault();
            smsB.sendTextMessage(phonenumbers, null, smss, null, null);
            
        }
/*
            //sms activity
            // Create the intent.
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
            // Set the data for the intent as the phone number.
            smsIntent.setData(Uri.parse(phonenumbers));
            // Add the message (sms) with the key ("sms_body").
            smsIntent.putExtra("sms_body", smss);
            // If package resolves (target app installed), send intent.
            if (smsIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(smsIntent);
            } else {
                Log.d(, "Can't resolve app for ACTION_SENDTO Intent");
            }
*/

        }
    }