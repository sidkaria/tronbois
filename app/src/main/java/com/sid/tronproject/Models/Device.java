package com.sid.tronproject.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Device {
    @SerializedName("lat")
    private double currLat;

    @SerializedName("lon")
    private double currLon;

    @SerializedName("type")
    private String type;

    @SerializedName("mac_id")
    private String macID;

    @SerializedName("connected_devices")
    private ArrayList<String> connectedDevices;

    public double getCurrLat() {
        return currLat;
    }

    public double getCurrLon() {
        return currLon;
    }

    public String getType() {
        return type;
    }

    public String getMacID() {
        return macID;
    }

    public ArrayList<String> getConnectedDevices() {
        return connectedDevices;
    }
}
