package com.sid.tronproject.Responses;

import com.google.gson.annotations.SerializedName;
import com.sid.tronproject.Models.Device;

import java.util.ArrayList;

public class TransactionResponse {

    @SerializedName("devices")
    private ArrayList<Device> devices;

    public ArrayList<Device> getDevices() {
        return devices;
    }
}
