package com.example.gabriel_sanchez_s4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gabriel_sanchez_s4.models.Team;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<Team> teams = new ArrayList<Team>();
    adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teams.add(new Team(1,"RedBull", R.drawable.img_redbull, 5));
        teams.add(new Team(2,"Ferrari", R.drawable.img_ferrari, 3));
        teams.add(new Team(3,"Mercedez", R.drawable.img_mercedez_benz, 2));

        list = (ListView) findViewById(R.id.lvTeam);
        myAdapter = new adapter(this, teams);
        list.setAdapter(myAdapter);
        registerForContextMenu(list);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo
            menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
                menuInfo;
        menu.setHeaderTitle(this.teams.get(info.position).getName());
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (teams.size()){
            case 3:
                teams.add(new Team(4,"MCLaren", R.drawable.img_mclaren, 6));
                myAdapter.notifyDataSetChanged();
                break;
            case 4:
                teams.add(new Team(5,"Alpha Tauri", R.drawable.img_alpha_tauri, 1));
                myAdapter.notifyDataSetChanged();
                break;
            case 5:
                teams.add(new Team(6,"Aston Martin", R.drawable.img_aston_martin, 2));
                myAdapter.notifyDataSetChanged();
                break;
            default:
                Toast.makeText(this, "No hay más escudería disponible", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }


}