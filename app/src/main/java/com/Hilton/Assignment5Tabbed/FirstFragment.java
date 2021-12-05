package com.Hilton.Assignment5Tabbed;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.HiltonTabbed.Assignment5Tabbed.R;


public class FirstFragment extends Fragment {

    EditText namesEDT, phonenoEDT,addressEDT, emailEDT;
    Button registerBtn;
    DatabaseHelper _dBHelper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        _dBHelper=new DatabaseHelper(getContext());

        namesEDT=view.findViewById(R.id.editText_names);
        phonenoEDT=view.findViewById(R.id.editText_phone);
        addressEDT=view.findViewById(R.id.editText_address);
        emailEDT=view.findViewById(R.id.email);
        registerBtn=view.findViewById(R.id.button_register);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                    String names=namesEDT.getText().toString().trim();
                    String phone=phonenoEDT.getText().toString().trim();
                    String email= emailEDT.getText().toString().trim();
                    String address=addressEDT.getText().toString().trim();
                    boolean isInserted=_dBHelper.insertUserdata(names,phone,email,address);
                    if (isInserted){
                        namesEDT.setText("");
                        phonenoEDT.setText("");
                        emailEDT.setText("");
                        addressEDT.setText("");
                        Toast.makeText(getContext(),"User is Successfully Registered",Toast.LENGTH_LONG).show();
                        showToast("User is Successfully Registered");
                    }
                    else
                        Toast.makeText(getContext(), "Failed to add user", Toast.LENGTH_LONG).show();
                }
                catch (Exception x) {
                    Toast.makeText(getContext(), "Failed to add user", Toast.LENGTH_LONG).show();
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void showToast(String message){
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}