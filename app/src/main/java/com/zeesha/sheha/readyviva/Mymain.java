package com.zeesha.sheha.readyviva;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Mymain extends AppCompatActivity {
private ArrayList<Users>user_list;
private static final String SP_KEY="user_list_sp";
private  SharedPreferences sharedPreferences;
private Button save,go;
private EditText id,name,marks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymain);
     sharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);
     user_list=new ArrayList<>();
     save=findViewById(R.id.save_btn);
     go=findViewById(R.id.go);
     id=findViewById(R.id.user_id_txt);
     name=findViewById(R.id.user_name_txt);
     marks=findViewById(R.id.user_marks_txt);
     save.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             if(!id.getText().toString().isEmpty()&&!name.getText().toString().isEmpty()&&!marks.getText().toString().isEmpty()){
                 user_list.add(new Users(id.getText().toString(),name.getText().toString(),marks.getText().toString()));
                 Gson gson=new Gson();
                 String jsonString=gson.toJson(user_list);
                 SharedPreferences.Editor editor=sharedPreferences.edit();
                 editor.putString(SP_KEY,jsonString);
                 editor.apply();
                 clear();
                 Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                 Intent i=new Intent(getApplicationContext(),MainActivity.class);
                 startActivity(i);
             }
         }
     });
     go.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent i=new Intent(getApplicationContext(),MainActivity.class);
             startActivity(i);
         }
     });
        }

    private void clear() {
        id.setText("");
        name.setText("");
        marks.setText("");
    }


}
