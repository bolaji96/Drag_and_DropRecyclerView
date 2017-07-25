package com.example.oluwasona.dragndroprecyclerview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by OLUWASONA on 24/07/2017.
 */

public class Drag_and_drop_adapter extends RecyclerView.Adapter<Drag_and_drop_adapter.MyViewHolder>
        implements ItemTouchHelperAdapter {

    private Context context;
    private List<Items> mItems = new ArrayList<>();
    private Typeface mTypeface;
    private final OnStartDragListener mDragStartListener;

    //Create a constructor of your adapter class with the needed parameters.
    public Drag_and_drop_adapter(Context context, OnStartDragListener mDragStartListener, List<Items> mItemsList) {
        this.mDragStartListener = mDragStartListener;
        this.mItems = mItemsList;
        this.context = context;
        mTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/MavenPro-Regular.ttf");
    }

    //You inflate your layout here
    @Override
    public Drag_and_drop_adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View v = inflater.inflate((viewType == 0) ? R.layout.list_item_draggable : R.layout.list_item2_draggable, parent, false);
        return new MyViewHolder(v);
    }

    //Configure your layout here
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        //assign the object of your custom class to the content of your arrayList
        Items items = mItems.get(position);
        //All the variables declared in your MyViewHolder class can be accessed by holder.name_of_variable
        //holder is the object of your MyViewHolder class declared
        //Set the text of your textview
        holder.textView.setText(items.getItemNames());
        //set the image of your choice for your
        holder.teamLogo.setImageResource(items.getTeamImage());

        // Start a drag whenever the handle view it touched
        holder.handleView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mDragStartListener.onStartDrag(holder);
                }
                return false;
            }
        });
    }

    //Returns the size of your arrayList
    @Override
    public int getItemCount() {return mItems.size();}

    //Getters to return ItemName and TeamImage of the respective custom class for a particular index of your ArrayList
    public String getItemName(int i) {
        Items items = mItems.get(i);
        return items.getItemNames();
    }

    public int getTeamImage(int i) {
        Items items = mItems.get(i);
        return items.getTeamImage();
    }

    //Boolean function for handling movement of view and respective content of the indexes your arrayList
    //when the drag handle is clicked
    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    /**
     *Implementation of your view holder that implements {@link ItemTouchHelperViewHolder} and has provision for the
     * "handle" view that starts the drag event when touched.
     */
    public class MyViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
        //Declare the required variables for the layouts that woulld be used in each list item
        // or cardview in your recyclerView
        public FrameLayout mContainer;
        public final TextView textView;
        public final ImageView teamLogo;
        public final ImageView handleView;
        //Create a constructor of your view holder and assign these variables
        public MyViewHolder(View itemView) {
            super(itemView);
            mContainer = (FrameLayout) itemView.findViewById(R.id.container);
            textView = (TextView) itemView.findViewById(R.id.textView);
            teamLogo = (ImageView) itemView.findViewById(R.id.imageView);
            handleView = (ImageView) itemView.findViewById(R.id.drag_handle);
            textView.setTypeface(mTypeface);
        }

        //To change the background of the view when selected
        @Override
        public void onItemSelected() {itemView.setBackgroundColor(Color.LTGRAY);}
        //To change the background of the view when an item is cleared - if swipeable is implemented
        @Override
        public void onItemClear() {itemView.setBackgroundColor(0);}
    }
}
