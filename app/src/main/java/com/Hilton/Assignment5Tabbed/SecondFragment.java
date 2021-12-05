package com.Hilton.Assignment5Tabbed;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.HiltonTabbed.Assignment5Tabbed.R;


public class SecondFragment extends Fragment {


    TextView userInfoTxt;
    DatabaseHelper _dbHelper;
    EditText searchEdt;
    ImageButton imgBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        _dbHelper=new DatabaseHelper(getContext());
        searchEdt=view.findViewById(R.id.search_Edt);
        imgBtn=view.findViewById(R.id.img_search);
        userInfoTxt=view.findViewById(R.id.user_info);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=searchEdt.getText().toString().trim();
                Cursor res=_dbHelper.getUser(email);
                if (res.getCount()==0){
                    Toast.makeText(getContext(),"No Entry Exists",Toast.LENGTH_SHORT).show();
                    userInfoTxt.setText("");
                }
                while(res.moveToNext()) {
                    userInfoTxt.setText("Full Name : "+res.getString(0)+"\n\n"+"Phone No :"+res.getString(1)+"\n\n"+"email :"+res.getString(2)+"\n\n"+"Address : "+res.getString(3)+"\n\n\n");
                }
            }
        });


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        _dbHelper=new DatabaseHelper(getContext());
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=searchEdt.getText().toString().trim();
                Cursor res=_dbHelper.getUser(email);
                if (res.getCount()==0){
                    Toast.makeText(getContext(),"No Entry Exists",Toast.LENGTH_SHORT).show();
                    userInfoTxt.setText("");
                }
                while(res.moveToNext()) {
                    userInfoTxt.setText("Full Name : "+res.getString(0)+"\n\n"+"Phone No :"+res.getString(1)+"\n\n"+"email :"+res.getString(2)+"\n\n"+"Address : "+res.getString(2)+"\n\n\n");
                }
            }
        });
    }
}