package com.akashbhave.sparker;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.mail.internet.InternetAddress;

public class Signup1Activity extends AppCompatActivity {

    public void sendNext1(View view) {
        String name = ((EditText) findViewById(R.id.nameET)).getText().toString();
        String email = ((EditText) findViewById(R.id.emailET)).getText().toString();
        String password = ((EditText) findViewById(R.id.passwordET)).getText().toString();
        // Booleans to hold the value if entries are valid
        boolean nameGood = false;
        boolean emailGood = true;
        boolean passwordGood = false;

        String toastMessage = "";
        // Full name CHECK
        if(name.length() > 5 && name.contains(" ")) {
            nameGood = true;
        } else {
            toastMessage = "Name must be above 5 characters and have two words.\n";
        }
        // Email check
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (javax.mail.internet.AddressException ex) {
            emailGood = false;
            toastMessage += "Enter a valid email address.\n";
        }
        // Password check
        if(password.length() > 7) {
            passwordGood = true;
        } else {
            toastMessage += "Your password be at least 8 characters long.";
        }

        // Checks if all criteria are met
        if(nameGood && emailGood && passwordGood) {
            Log.i("SIGNUP", "name: " + name);
            Log.i("SIGNUP", "email: " + email);
            Log.i("SIGNUP", "password: " + password);
        } else {
            // Gives the user error messages
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);

        // Locks the orientation to portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }
}
