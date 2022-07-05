package com.example.myapplicationst7;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class RVOnItemTouchHelper extends ItemTouchHelper.SimpleCallback {
    private final MasonryAdapter rvAdapter;

    public RVOnItemTouchHelper(MasonryAdapter rvAdapter) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.rvAdapter = rvAdapter;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, RecyclerView.ViewHolder dragged, RecyclerView.ViewHolder target) {
        rvAdapter.swap(dragged.getAdapterPosition(), target.getAdapterPosition());
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder swiped, int direction) {
        switch (direction) {
            case ItemTouchHelper.LEFT:
                //Remove item
                rvAdapter.remove(swiped.getAdapterPosition());
                System.out.println("swiped Left");
                break;
            case ItemTouchHelper.RIGHT:
                rvAdapter.remove(swiped.getAdapterPosition());
                System.out.println("swiped Right");
                break;
        }
    }
}
