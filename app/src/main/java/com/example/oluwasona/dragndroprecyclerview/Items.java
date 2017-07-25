package com.example.oluwasona.dragndroprecyclerview;

/**
 * Created by OLUWASONA on 05/05/2017.
 */
public class Items {
    private String itemNames;
    private int teamImage;

    public Items() {
    }

    public Items(int teamImage, String itemNames) {
        this.itemNames = itemNames;
        this.teamImage = teamImage;
    }

    public String getItemNames() {
        return itemNames;
    }

    public void setItemNames(String itemNames) {
        this.itemNames = itemNames;
    }

    public int getTeamImage() {
        return teamImage;
    }

    public void setTeamImage(int teamImage) {
        this.teamImage = teamImage;
    }

}
