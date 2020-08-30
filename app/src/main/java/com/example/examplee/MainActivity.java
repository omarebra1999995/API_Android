package com.example.examplee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

ImageView t1 ;
Button b1 ;
RecyclerView rr ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
          rr=findViewById(R.id.r);
        ArrayList<Integer> in =new ArrayList<Integer>();


        in.add(R.drawable.arm);
        in.add(R.drawable.sap);
        in.add(R.drawable.raj);



        recy r =new recy(in, new onclick() {
            @Override
            public void onItem(int c) {
                String nameComp="";
                Intent in =new Intent(getBaseContext(),activ2.class);
                if(c==R.drawable.arm){
                    nameComp="Aramco";
                } if(c==R.drawable.sap){
                    nameComp="SABIC";

                }   if(c==R.drawable.raj){
                       nameComp="AlRajhiBank)";

            }
                in.putExtra("id",c);
                in.putExtra("comp",nameComp);
                startActivityForResult(in,1);





            }
        });
        RecyclerView.LayoutManager n=new LinearLayoutManager(this);
rr.setHasFixedSize(true);
rr.setLayoutManager(n);
rr.setAdapter(r);



    }
}


