package org.kuro.dinner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.kuro.dinner.R;
import org.kuro.dinner.model.entity.Address;

import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.AddressViewHolder> {

    List<Address> addressList;
    Context context;

    public AddressAdapter(List<Address> addressList, Context context) {
        this.addressList = addressList;
        this.context = context;
    }

    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.address_card, parent, false);
        return new AddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {
        Address address = addressList.get(position);
        holder.name.setText(address.getName());
        holder.address_mobile.setText(address.getMobile());
        holder.address_name.setText(address.getAddress());
        holder.address_state.setChecked(address.getState());
        if (address.getState()) {
            holder.address_state.setText("默认地址");
        } else {
            holder.address_state.setText("设为默认");
        }
    }

    @Override
    public int getItemCount() {
        return addressList.size();
    }

    static class AddressViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView address_mobile;
        TextView address_name;
        RadioButton address_state;

        public AddressViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.address_user);
            address_mobile = itemView.findViewById(R.id.address_mobile);
            address_name = itemView.findViewById(R.id.address_name);
            address_state = itemView.findViewById(R.id.address_state);
        }
    }
}
