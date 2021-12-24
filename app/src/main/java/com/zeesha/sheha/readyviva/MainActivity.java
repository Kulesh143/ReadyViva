package com.zeesha.sheha.readyviva;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private ArrayList<Users>user_list;
private static final String SP_KEY="user_list_sp";
private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       user_list=new ArrayList<>();
       recyclerView=findViewById(R.id.list_view);
       sharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);
       String json_String=sharedPreferences.getString(SP_KEY,null);
       Gson gson=new Gson();
       TypeToken typeToken=new TypeToken<ArrayList<Users>>(){};
       ArrayList<Users>user_list_local=gson.fromJson(json_String,typeToken.getType());
       LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
       recyclerView.setLayoutManager(linearLayoutManager);
       recyclerView.setAdapter(new UserViewAdapter(user_list_local));
    }
}
class UserViewHolder extends RecyclerView.ViewHolder{
public TextView id;
public TextView name;
public TextView marks;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        id=itemView.findViewById(R.id.user_id);
        name=itemView.findViewById(R.id.user_name);
        marks=itemView.findViewById(R.id.user_marks);
    }
}
class UserViewAdapter extends RecyclerView.Adapter{
private ArrayList<Users>user_list;
public UserViewAdapter(ArrayList<Users>user_list){
    this.user_list=user_list;
}
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.one_item_view,viewGroup,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
    final  Users u=user_list.get(i);
    final UserViewHolder userViewHolder= (UserViewHolder) viewHolder;
    userViewHolder.id.setText(u.getId());
    userViewHolder.name.setText(u.getName());
    userViewHolder.marks.setText(u.getMarks());
    }

    @Override
    public int getItemCount() {
        return user_list.size();
    }
}

