package com.jessicathornsby.launchslice;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;

import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.Slice;
import androidx.slice.SliceProvider;
import androidx.slice.builders.ListBuilder;
import androidx.slice.builders.SliceAction;


public class MySliceProvider extends SliceProvider {


    @Override
    public boolean onCreateSliceProvider() {

        return true;
    }

    @Override
    public Slice onBindSlice(Uri sliceUri) {
        final String path = sliceUri.getPath();
        switch (path) {

//Define the slice’s URI; I’m using ‘mainActivity’//

            case "/mainActivity":
                return createSlice(sliceUri);
        }
        return null;
    }

    public Slice createSlice(Uri sliceUri) {
        SliceAction activityAction = createActivityAction();

//Create the ListBuilder//

        ListBuilder listBuilder = new ListBuilder(getContext(), sliceUri, ListBuilder.INFINITY);

        //Create the RowBuilder//

        ListBuilder.RowBuilder rowBuilder = new ListBuilder.RowBuilder(listBuilder)

//Set the title text//

                .setTitle("Launch MainActivity.")

//Set the row’s primary action//

                .setPrimaryAction(activityAction);

//Add the row to the ListBuilder//

        listBuilder.addRow(rowBuilder);

//Build the List//

        return listBuilder.build();
    }

    public SliceAction createActivityAction() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        return new SliceAction(PendingIntent.getActivity(getContext(), 0, intent, 0),
                IconCompat.createWithResource(getContext(), R.drawable.ic_home),
                "Launch MainActivity");
    }



}

