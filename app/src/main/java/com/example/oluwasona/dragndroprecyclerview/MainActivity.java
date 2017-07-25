package com.example.oluwasona.dragndroprecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnStartDragListener {
    //Declare your global variables
    RecyclerView recyclerView;
    ArrayList itemsList;
    private ItemTouchHelper mItemTouchHelper;
    public static String[] mNewPositions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Find our recycler view
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //Configure your recyclerView
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //assign your arrayList
        itemsList = new ArrayList<>();
        //Declare your adapter
        final Drag_and_drop_adapter drag_and_drop_adapter = new Drag_and_drop_adapter(this, this, itemsList);
        //set your recyclerView adapter
        recyclerView.setAdapter(drag_and_drop_adapter);
        //Create an object of ItemTouchHelper.CallBack and assign it to SimpleItemTouchHelperCallback - it accepts your
        //adapter as a parameter.
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(drag_and_drop_adapter);
        //Assign mItemTouchHelper declared to ItemTouchHelper with object of ItemTouchHelper.CallBack as a parameter
        mItemTouchHelper = new ItemTouchHelper(callback);
        //attach mItemtouchHelper to your recyclerview
        mItemTouchHelper.attachToRecyclerView(recyclerView);
        //Function to populate recyclerView
        prepareItems();
    }

    private void prepareItems() {
       //Array of images that'd be assigned to the image Views at different positions of the recyclerView
        int[] premierLeagueTeams = { R.drawable.arsenal_fc_icon, R.drawable.afc_bournemouth_icon, R.drawable.burnley_fc_icon,
                R.drawable.chelsea_fc_icon, R.drawable.crystal_palace_icon, R.drawable.everton_fc_icon,
                R.drawable.hull_city_icon, R.drawable.leicester_city_icon, R.drawable.liverpool_fc_icon,
                R.drawable.manchester_city_icon, R.drawable.manchester_united_icon};

        //Pass parameters to your custom class and populate your ArrayList - arraylist_name.add(object_name_of_custom_class)
        Items items = new Items(premierLeagueTeams[0],"Arsenal FC");
        itemsList.add(items);

        Items items1 = new Items(premierLeagueTeams[1],"Bournemouth FC");
        itemsList.add(items1);

        Items items2 = new Items(premierLeagueTeams[2],"Burnley FC");
        itemsList.add(items2);

        Items items3 = new Items(premierLeagueTeams[3],"Chelsea FC");
        itemsList.add(items3);

        Items items4 = new Items(premierLeagueTeams[4],"Crystal Palace FC");
        itemsList.add(items4);

        Items item5 = new Items(premierLeagueTeams[5],"Everton FC");
        itemsList.add(item5);

        Items items6 = new Items(premierLeagueTeams[6],"Hull City FC");
        itemsList.add(items6);

        Items items7 = new Items(premierLeagueTeams[7],"Leicester FC");
        itemsList.add(items7);

        Items items8 = new Items(premierLeagueTeams[8],"Liverpool FC");
        itemsList.add(items8);

        Items items9 = new Items(premierLeagueTeams[9],"Manchester City");
        itemsList.add(items9);

        Items items10 = new Items(premierLeagueTeams[10],"Manchester United FC");
        itemsList.add(items10);
    }

    //Method created to implement OnStartDragListener
    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
