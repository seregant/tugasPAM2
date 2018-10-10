package com.indra.tugaspam2;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    Bitmap photo;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText msgNama = (EditText) findViewById(R.id.nama);
        final EditText msgNim = (EditText) findViewById(R.id.nim);
        final EditText msgAlamat = (EditText) findViewById(R.id.alamat);
        final EditText msgNoTelp = (EditText) findViewById(R.id.telp);
        final EditText msgMail = (EditText) findViewById(R.id.email);

        Button btnSubmit = (Button) findViewById(R.id.submit);
        Button btnCamera = (Button) findViewById(R.id.takePhoto);
        final Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        final Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
                onActivityResult(1, 1, takePictureIntent);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (photo!= null){
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    photo.compress(Bitmap.CompressFormat.PNG, 90, stream);
                    byte[] msgImage = stream.toByteArray();
                    intent.putExtra("img", msgImage);
                }
                intent.putExtra("nama", msgNama.getText().toString());
                intent.putExtra("nim", msgNim.getText().toString());
                intent.putExtra("alamat", msgAlamat.getText().toString());
                intent.putExtra("telp", msgNoTelp.getText().toString());
                intent.putExtra("mail", msgMail.getText().toString());
                startActivity(intent);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final ImageView thmb = (ImageView) findViewById(R.id.thumb);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            thmb.setImageBitmap(imageBitmap);
            this.photo = (Bitmap) extras.get("data");
        }
    }
}
