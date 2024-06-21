package com.example.textfileapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Menulis teks ke file
        String data = "Haloo nama saya Afif dengan nim 21.83.0652";
        try {
            writeToFile("data.txt", data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Membaca teks dari file
        try {
            String text = readFromFile("data.txt");
            textView.setText(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(String fileName, String data) throws IOException {
        FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
        fos.write(data.getBytes());
        fos.close();
    }

    private String readFromFile(String fileName) throws IOException {
        FileInputStream fis = openFileInput(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }
}
