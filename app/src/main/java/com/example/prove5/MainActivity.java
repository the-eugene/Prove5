package com.example.prove5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendScripture(View v){
        String book = ((EditText) findViewById(R.id.editBook)).getText().toString();
        String chapter = ((EditText) findViewById(R.id.editChapter)).getText().toString();
        String verse = ((EditText) findViewById(R.id.editVerse)).getText().toString();
        Log.d("com.example.prove5", String.format("About to create intent with %s %s:%s",book, chapter,verse));
        Intent intent = new Intent(this, sendScriptureActivity.class);
        intent.putExtra("com.example.prove5.Book",book);
        intent.putExtra("com.example.prove5.Chapter",chapter);
        intent.putExtra("com.example.prove5.Verse",verse);
        startActivity(intent);
    }

    public void loadScripture(View v) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        ((EditText) findViewById(R.id.editBook)).setText(sharedPref.getString("Book",""));
        ((EditText) findViewById(R.id.editChapter)).setText(sharedPref.getString("Chapter",""));
        ((EditText) findViewById(R.id.editVerse)).setText(sharedPref.getString("Verse",""));
    }
}