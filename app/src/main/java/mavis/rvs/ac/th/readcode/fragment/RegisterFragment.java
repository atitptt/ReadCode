package mavis.rvs.ac.th.readcode.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import mavis.rvs.ac.th.readcode.MainActivity;
import mavis.rvs.ac.th.readcode.R;
import mavis.rvs.ac.th.readcode.utility.myAlert;

/**
 * Created by Mavis on 21/03/2018.
 */

public class RegisterFragment extends Fragment {
//           Explicit
    private String nameString, userString, passwordString;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//      create Toolbar
        createToolbar();

//      Register Controller
        registerController();


    }       // Main Method

    private void registerController() {
        Button button = getView().findViewById(R.id.btnRegister);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                   Get Value from EditText
                EditText nameEditText = getView().findViewById(R.id.edtName);
                EditText userEditText = getView().findViewById(R.id.edtuser);
                EditText passwordEditText = getView().findViewById(R.id.edtpassword);

//                chang EditText to String
                nameString = nameEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

//                  check Space
                if (nameString.isEmpty() || userString.isEmpty()  || passwordString.isEmpty()) {
//                  Have Space
                    myAlert objMyAlert = new myAlert(getActivity());
                    objMyAlert.myDialog("Have Space","Please fill All Blank");

                } else {
                }
//                  No Space


            }
        });


    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarRegister);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
//            setup Title
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Register");
//          Show Nevigator Icon
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        return view;
    }
}//Main Class
