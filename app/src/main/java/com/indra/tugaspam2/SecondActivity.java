package com.indra.tugaspam2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.widget.TextView;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        TextView vNama = (TextView)findViewById(R.id.vnama);
        TextView vNim = (TextView)findViewById(R.id.vnim);
        TextView vAlamat = (TextView)findViewById(R.id.valamat);
        TextView vTelp = (TextView)findViewById(R.id.vtelp);


        Intent data = getIntent();
        vNama.setText(data.getStringExtra("nama"));
        vNim.setText(data.getStringExtra("nim"));
        vAlamat.setText(data.getStringExtra("alamat"));
        vTelp.setText(data.getStringExtra("telp"));

    }

}
