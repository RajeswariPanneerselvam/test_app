package com.app.testapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.testapp.ItemClick;
import com.app.testapp.R;
import com.app.testapp.model.DataModel;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

public class RecyclerItemAdapter  extends RecyclerView.Adapter<RecyclerItemAdapter.ViewHolder> {


    List<DataModel> data;
    Context context;
    ItemClick click;


    public RecyclerItemAdapter(List<DataModel>data, ItemClick itemClick,Context context){

        this.data=data;
        this.click=itemClick;
        this.context=context;
        notifyDataSetChanged();
    }


    @Override
    public RecyclerItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.recycler_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder( RecyclerItemAdapter.ViewHolder holder, int position) {
        holder.text_name.setText(data.get(position).getName());
        holder.text_description.setText(data.get(position).getDescription());
        Picasso.with(context).load(data.get(position).owner.avatar_url).into(holder.image_avathar);






    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{


        TextView text_name,text_description;
        ImageView image_avathar;
        public ViewHolder( View itemView) {
            super(itemView);
            text_name=itemView.findViewById(R.id.text_name) ;
            text_description=itemView.findViewById(R.id.text_description);
            image_avathar=itemView.findViewById(R.id.avatar_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click.onClicked(Collections.singletonList(data.get(getAdapterPosition())));
                }
            });
        }
    }
}
