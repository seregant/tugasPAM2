package com.indra.tugaspam2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText msgNama = (EditText) findViewById(R.id.nama);
        final EditText msgNim = (EditText) findViewById(R.id.nim);
        final EditText msgAlamat = (EditText) findViewById(R.id.alamat);
        final EditText msgNoTelp = (EditText) findViewById(R.id.telp);
        Button btnSubmit = (Button) findViewById(R.id.submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("nama", msgNama.getText().toString());
                intent.putExtra("nim", msgNim.getText().toString());
                intent.putExtra("alamat", msgAlamat.getText().toString());
                intent.putExtra("telp", msgNoTelp.getText().toString());
                startActivity(intent);
            }
        });
    }
}
