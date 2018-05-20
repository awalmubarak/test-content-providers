package com.anditer.contentproviders;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textview = findViewById(R.id.textview);

        Cursor contacts = getContacts();

        while (contacts.moveToNext()){
            String name = contacts.getString(contacts.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
            textview.append("Name: ");
            textview.append(name);
            textview.append("\n");


        }


    }

    //this function gets all contacts from the device using content provider
    private Cursor getContacts(){
        Uri uri = ContactsContract.Contacts.CONTENT_URI;

        String[] projects = {ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME};
        String selection = ContactsContract.Contacts.IN_VISIBLE_GROUP + " = '"  + ("1") + "'";

        return getContentResolver().query(uri,projects, selection, null, null);

    }
}
