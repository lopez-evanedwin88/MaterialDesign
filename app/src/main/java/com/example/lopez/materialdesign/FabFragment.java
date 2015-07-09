package com.example.lopez.materialdesign;

import android.app.Fragment;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 7/9/2015.
 */
public class FabFragment extends android.support.v4.app.Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fab,container,false);
        FloatingActionButton fab = (FloatingActionButton)v.findViewById(R.id.fab);

        final View.OnClickListener clickListener = new View.OnClickListener() {
            public void onClick(View v) {

            }
        };
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,R.string.snackbar,Snackbar.LENGTH_LONG).setAction(R.string.undo, clickListener).show();
            }
        });

        return v;
    }
}
