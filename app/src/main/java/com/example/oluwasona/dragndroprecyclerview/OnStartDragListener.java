package com.example.oluwasona.dragndroprecyclerview;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Nimco on 7/6/2017.
 */

public interface OnStartDragListener {
    /**
     * Called when a view is requesting a start of a drag.
     *
     * @param viewHolder The holder of the view to drag.
     */
    void onStartDrag(RecyclerView.ViewHolder viewHolder);
}
