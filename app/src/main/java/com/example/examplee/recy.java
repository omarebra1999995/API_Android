package com.example.examplee;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class recy extends RecyclerView.Adapter<recy.VH> {
    ArrayList<Integer> comp;
    onclick lis;
    public recy(ArrayList<Integer> comp , onclick lis){
        this.comp=comp;
        this.lis=lis;

    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.design,null,false);
      VH vv =new VH(v);
        return vv;
    }

    @Override
    public int getItemCount() {
        return comp.size();
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
           int m =comp.get(position);

           holder.im.setImageResource(m);
           holder.im.setTag(m);

    }

    class VH extends RecyclerView.ViewHolder{

ImageView im ;
        public VH(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.im);
            im.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lis.onItem((int)im.getTag());
                }
            });
        }
    }
}
