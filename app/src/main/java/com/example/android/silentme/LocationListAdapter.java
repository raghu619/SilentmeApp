package com.example.android.silentme;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.location.places.PlaceBuffer;

public class LocationListAdapter extends RecyclerView.Adapter<LocationListAdapter.PlaceViewHolder> {

    private Context mContext;

    private PlaceBuffer mPlaces;

    public LocationListAdapter(Context context, PlaceBuffer places) {
        this.mContext = context;
        this.mPlaces=places;
    }


    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Get the RecyclerView item layout
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_place_card, parent, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        String placeName = mPlaces.get(position).getName().toString();

        String placeAddress = mPlaces.get(position).getAddress().toString();

        holder.nameTextView.setText(placeName);
        holder.addressTextView.setText(placeAddress);


    }
    public void swapPlaces(PlaceBuffer newPlaces){
        mPlaces = newPlaces;
        if (mPlaces != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
    }



    @Override
    public int getItemCount() {

        if(mPlaces==null) return 0;
        return mPlaces.getCount();
    }
class PlaceViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        TextView addressTextView;

        public PlaceViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
            addressTextView = (TextView) itemView.findViewById(R.id.address_text_view);
        }

    }
}
