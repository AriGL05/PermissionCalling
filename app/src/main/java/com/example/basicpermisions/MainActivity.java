package com.example.basicpermisions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLlamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLlamar = findViewById(R.id.mama);
        btnLlamar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_DENIED){
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1987);
        }
        else {
            Intent llamarmama = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 871 1585205"));
            startActivity(llamarmama);
        }
    }
}