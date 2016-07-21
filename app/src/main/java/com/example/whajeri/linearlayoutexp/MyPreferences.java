package com.example.whajeri.linearlayoutexp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by whajeri on 08/07/2016.
 */
public class MyPreferences extends DialogFragment {

    ArrayList mSelectedItems = new ArrayList();  // Where we track the selected items

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        /* I'm using SharedPreferences as a simple way to store key value sets
                */
        SharedPreferences sharedPref = getActivity().getSharedPreferences("mesprefs", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();


        // Set the dialog title
        builder.setTitle("My Preferences")
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setMultiChoiceItems(R.array.prefs_array, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    mSelectedItems.add(which);
                                } else if (mSelectedItems.contains(which)) {
                                    // Else, if the item is already in the array, remove it
                                    mSelectedItems.remove(Integer.valueOf(which));
                                }
                            }
                        })
                // Set the action buttons
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialo
                        Iterator ite = mSelectedItems.listIterator();
                        while(ite.hasNext()) {

                            int pref_int = ((Integer )(ite.next())).intValue();
                            switch (pref_int){
                                case 0 :
                                    editor.putString(getString(R.string.pref_1), getString(R.string.pref_1));
                                    Log.i("info", "Preference 1");
                                    break;
                                case 1 :
                                    editor.putString(getString(R.string.pref_2), getString(R.string.pref_2));
                                    Log.i("info", "Preference 2");
                                    break;
                                case 2 :
                                    editor.putString(getString(R.string.pref_3), getString(R.string.pref_3));
                                    Log.i("info", "Preference 3");
                                    break;

                            }
                        }
                        editor.commit();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });




        return builder.create();

    }
}
