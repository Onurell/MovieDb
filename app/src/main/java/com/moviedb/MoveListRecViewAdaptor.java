package com.moviedb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviedb.R;

import java.util.List;

public class MoveListRecViewAdaptor extends RecyclerView.Adapter<MoveListRecViewAdaptor.MyViewHolder> implements RecyclerInterface{


    private Context mContext;
    private List<ModelClass> mData;

    public MoveListRecViewAdaptor(Context mContext, List<ModelClass> mData) {
        this.mContext = mContext;
        this.mData = mData;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.movie_item, parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.title.setText(mData.get(position).getTitle());
        holder.id.setText(mData.get(position).getId());

        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/w500"+mData.get(position).getPoster_path())
                .into(holder.poster_path);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(mData.get(holder.getAdapterPosition()));
            }
        });




    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onItemClick(ModelClass movie) {

        Intent intent = new Intent(mContext.getApplicationContext(),DetailActivity.class);
        intent.putExtra("movie",movie);
        mContext.startActivity(intent);

    }






    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView id;
        TextView title;
        ImageView poster_path;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_txt);
            id = itemView.findViewById(R.id.id_txt);

            poster_path = itemView.findViewById(R.id.imageView);





        }


    }
}
