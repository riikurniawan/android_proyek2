package com.rii.proyek3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class RegisterActivity extends AppCompatActivity {

    EditText editUsername, editPassword, editEmail, editNama, editAsal, editAlamat;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("Register");

        editUsername = findViewById(R.id.editUsernameR);
        editPassword = findViewById(R.id.editPasswordR);
        editEmail = findViewById(R.id.editEmailR);
        editNama = findViewById(R.id.editNamaR);
        editAsal = findViewById(R.id.editAsalR);
        editAlamat = findViewById(R.id.editAlamatR);

        btnSimpan = findViewById(R.id.btnSimpan);


        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (!isValidation()) {
                        Toast.makeText(RegisterActivity.this, "Mohon lengkapi seluruh data!", Toast.LENGTH_SHORT).show();
                    } else {
                    simpanFileData();
                    }

            }
        });
    }

    boolean isValidation() {
        if(editUsername.getText().toString().equals("") ||
                editPassword.getText().toString().equals("") ||
                editEmail.getText().toString().equals("") ||
                editNama.getText().toString().equals("") ||
                editAsal.getText().toString().equals("") ||
                editAlamat.getText().toString().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    void simpanFileData() {
        String isiFile = editUsername.getText().toString() + ";" +
                editPassword.getText().toString() + ";" +
                editEmail.getText().toString() + ";" +
                editNama.getText().toString() + ";" +
                editAsal.getText().toString() + ";" +
                editAlamat.getText().toString();
        File file = new File(getFilesDir(), editUsername.getText().toString());
        FileOutputStream outputStream = null;

        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
            Toast.makeText(this, "Berhasil registrasi!", Toast.LENGTH_SHORT).show();
            onBackPressed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}