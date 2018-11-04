package com.sid.tronproject.API;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sid.tronproject.R;
import com.sid.tronproject.Responses.TransactionResponse;

import java.util.ArrayList;

public class TransactionsAdapter extends ArrayAdapter<TransactionResponse> {
    public TransactionsAdapter(Context context, ArrayList<TransactionResponse> transactions) {
        super(context, 0, transactions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TransactionResponse currentTransaction = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.transaction_item, parent, false);
        }
        // Lookup view for data population
        TextView tvDevicesSize = (TextView) convertView.findViewById(R.id.tvDevicesSize);
        // Populate the data into the template view using the data object
        tvDevicesSize.setText("Number of Devices: " + currentTransaction.getDevices().size());
        // Return the completed view to render on screen
        return convertView;
    }
}
