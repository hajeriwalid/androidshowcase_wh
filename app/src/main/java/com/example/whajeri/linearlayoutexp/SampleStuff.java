package com.example.whajeri.linearlayoutexp;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;

/**
 * Created by whajeri on 15/07/2016.
 */
public class SampleStuff {

    /*
        Next we initialize a LayoutInflater object, which we will use to inflate our XML layout. Inflate simply means
         to turn our XML layout into a Java object. Once this is done, we can then access all our widgets in the
         usual way. We can think of inflater.inflate replacing setContentView for our dialog. And in the second line,
          we do just that with the inflate method.
          We now have a View object called dialogView, which contains all the UI elements from our dialog_new_note.xml layout file.
         *//*
    LayoutInflater inflater = getActivity().getLayoutInflater();
    View dialogView = inflater.inflate(R.layout.dialog_prefs, null);

    *//***
     * Comme pour Mainviez, on transforme chaque propriete graphique dont on a besoin en objet Java
     *//*
    final CheckBox checkBox_pref_1 = (CheckBox) dialogView.findViewById(R.id.checkBox_pref_1);
    final CheckBox checkBox_pref_2 = (CheckBox) dialogView.findViewById(R.id.checkBox_pref_2);
    final Switch switch_pref_1 = (Switch) dialogView.findViewById(R.id.switch_pref_1);

    final Button button_pref_nok = (Button) dialogView.findViewById(R.id.button_pref_nok);
    final Button button_pref_ok = (Button) dialogView.findViewById(R.id.button_pref_ok);

        *//*
            Instead of having all the dialog box implementing the OnClickListener, we use an anonymous inner class to
             do that
         *//*
    button_pref_nok.setOnClickListener(

            new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();
        }
    }

    );


    button_pref_ok.setOnClickListener(

            new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            *//**
     * I'm using SharedPreferences as a simple way to store key value sets
     *//*
            SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();

            if(checkBox_pref_1.isChecked()){
                editor.putString(getString(R.string.pref_1), "like 1" );
            }

            if(!checkBox_pref_1.isChecked()){
                editor.putString(getString(R.string.pref_1), "does not like 1" );
            }

            if(checkBox_pref_2.isChecked()){
                editor.putString(getString(R.string.pref_2), "like 2" );
            }

            if(!checkBox_pref_2.isChecked()){
                editor.putString(getString(R.string.pref_2), "does not like 2" );
            }

        }
    }

    );*/

}
