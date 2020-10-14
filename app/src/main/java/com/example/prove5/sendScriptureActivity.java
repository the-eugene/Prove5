package com.example.prove5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class sendScriptureActivity extends AppCompatActivity {
    String book="";
    String chapter="";
    String verse="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_scripture);
        Intent intent=getIntent();
        book=intent.getStringExtra("com.example.prove5.Book");
        chapter=intent.getStringExtra("com.example.prove5.Chapter");
        verse=intent.getStringExtra("com.example.prove5.Verse");
        String scripture=book+" "+chapter+":"+verse;
        Log.d("com.example.prove5", String.format("Received intent with %s %s:%s",book, chapter,verse));
        TextView textView=findViewById(R.id.scriptureDisplay);
        textView.setText(scripture);
    }

    public void saveScripture(View v){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Book",book);
        editor.putString("Chapter",chapter);
        editor.putString("Verse",verse);
        editor.apply();
        Toast.makeText(this, "Scripture Saved!", Toast.LENGTH_SHORT).show();
    }
}