package com.indra.tugaspam2;

import android.os.Bundle;
import android.app.Activity;

public class second_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
