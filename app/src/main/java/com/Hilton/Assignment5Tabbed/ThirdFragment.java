package com.Hilton.Assignment5Tabbed;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.HiltonTabbed.Assignment5Tabbed.R;

import java.util.ArrayList;

public class ThirdFragment extends Fragment {

    DatabaseHelper _dbHelper;
    ArrayList<String> _users;
    ListView usersList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        usersList=view.findViewById(R.id.list_view);
        _dbHelper=new DatabaseHelper(getContext());
        _users=new ArrayList<>();

        Cursor res=_dbHelper.getdata();
        if (res.getCount()==0){
            Toast.makeText(getContext(),"No Entry Exists",Toast.LENGTH_SHORT).show();
        }

        while(res.moveToNext()) {
            _users.add("Fullname : "+res.getString(0)+"\n\n"+"Phone No :"+res.getString(1)+"\n\n"+"email : "+res.getString(2)+"\n\n"+"Address : "+res.getString(3)+"\n\n\n");
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,_users);
        usersList.setAdapter(adapter);


            return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        _dbHelper=new DatabaseHelper(getContext());
        _users=new ArrayList<>();
        _users.clear();
        Cursor res=_dbHelper.getdata();
        if (res.getCount()==0){
            Toast.makeText(getContext(),"No Entry Exists",Toast.LENGTH_SHORT).show();
        }

        while(res.moveToNext()) {
            _users.add("Fullname : "+res.getString(0)+"\n\n"+"Phone No :"+res.getString(1)+"\n\n"+"email : "+res.getString(2)+"\n\n"+"Address : "+res.getString(3)+"\n\n\n");
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,_users);
        usersList.setAdapter(adapter);
    }

}