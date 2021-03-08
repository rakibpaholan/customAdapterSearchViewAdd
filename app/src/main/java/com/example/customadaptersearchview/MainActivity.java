package com.example.customadaptersearchview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ListVewAdapter adapter;
    String [] title;
    String [] description;
    int [] icon;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Item list");

        listView = (ListView)findViewById(R.id.listViewId);
        title = new String[] {"Afghanistan","Bangladesh","Bhutan","China","Germany","India","Myanmar","Nepal","Pakistan","Russia"};
        description = new String[] {"Afghanistan...","Bangladesh...","Bhutan...","China...","Germany...","India...","Myanmar...",
                "Nepal...","Pakistan...","Russia..."};

        icon = new int[] {R.drawable.afgan_flag,R.drawable.bangladesh_flag,
                R.drawable.bhuta_flag,R.drawable.chinaflag_here,R.drawable.germany_flag,
                R.drawable.india_flag,R.drawable.meyanmar_flag,R.drawable.nepal_flag,
                R.drawable.pakflag_flag,R.drawable.russia_flag};

                for ( int i = 0; i <title.length; i++){
                    Model model = new Model(title[i],description[i],icon[i]);
                    arrayList.add(model);
                }

                /*pass result to arrayListViewAdapter*/
        adapter = new ListVewAdapter(MainActivity.this,arrayList);
        listView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mune_here,menu);
        MenuItem myActionMenu = menu.findItem((R.id.action_search));
        SearchView searchView = (SearchView)myActionMenu.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(s);
                }
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id = item.getItemId();
       if ((id==R.id.action_setting)){
           return true;
       }
        return super.onOptionsItemSelected(item);
    }
}

/*design row of list view*/
/*adding menu to add searchView in actionbar*/
/*add model class*/
/*add adapter class*/
/*add some images in drawable folder*/
/*run project and test*/
/* ok that's works well now handle item click to move to new activity with actionbar title and send some data*/
/*Change the Action Bar title of Both Activities*/
/*add BackButton in the Action Bar of New Activities*/
/*Handel Item Clicks*/