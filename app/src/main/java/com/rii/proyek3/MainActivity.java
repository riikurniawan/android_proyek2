package com.rii.proyek3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView tvPassword;
    EditText editUsername, editPassword, editEmail, editNama, editAsal, editAlamat;
    Button btnSimpan;

    final String FILENAME = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.setTitle("Halaman depan");

        editUsername = findViewById(R.id.editUsernameR);
        tvPassword = findViewById(R.id.tvPassword);
        editPassword = findViewById(R.id.editPasswordR);
        editEmail = findViewById(R.id.editEmailR);
        editNama = findViewById(R.id.editNamaR);
        editAsal = findViewById(R.id.editAsalR);
        editAlamat = findViewById(R.id.editAlamatR);
        btnSimpan = findViewById(R.id.btnSimpan);

        //menyembunyikan, mendisabledkan item
        editUsername.setEnabled(false);
        tvPassword.setVisibility(View.GONE);
        editPassword.setVisibility(View.GONE);
        editEmail.setEnabled(false);
        editNama.setEnabled(false);
        editAsal.setEnabled(false);
        editAlamat.setEnabled(false);
        btnSimpan.setVisibility(View.GONE);

        bacaFileLogin();
    }

    void bacaFileLogin() {
        File sdcard = getFilesDir();
        File file = new File(sdcard, FILENAME);

        if(file.exists()) {
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while (line != null) {
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException ioe) {
                System.out.println("Error: " + ioe.getMessage());
            }

            String data = text.toString();
            String [] dataUser = data.split(";");
            bacaDataUser(dataUser[0]);
        }
    }

    void bacaDataUser(String username) {
        File sdcard = getFilesDir();
        File file = new File(sdcard, username);

        if(file.exists()) {
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while (line != null) {
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException ioe) {
                System.out.println("Error: " + ioe.getMessage());
            }

            String data = text.toString();
            String [] detailUser = data.split(";");

            editUsername.setText(detailUser[0]);
            editEmail.setText(detailUser[2]);
            editNama.setText(detailUser[3]);
            editAsal.setText(detailUser[4]);
            editAlamat.setText(detailUser[5]);
        }
    }
}