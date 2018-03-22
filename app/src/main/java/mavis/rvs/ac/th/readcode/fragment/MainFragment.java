package mavis.rvs.ac.th.readcode.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import mavis.rvs.ac.th.readcode.R;
import mavis.rvs.ac.th.readcode.utility.GetAllUser;
import mavis.rvs.ac.th.readcode.utility.MyConstant;
import mavis.rvs.ac.th.readcode.utility.myAlert;

/**
 * Created by Mavis on 20/03/2018.
 */

public class MainFragment extends Fragment{
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Register Controller
        registerController();

//        Login Controller
        loginController();


    }  // Main Method

    private void loginController() {
        Button button = getView().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText userEditText = getView().findViewById(R.id.edtuser);
                EditText passwordEditText = getView().findViewById(R.id.edtpassword);

                String userString = userEditText.getText().toString().trim();
                String passwordString = passwordEditText.getText().toString().trim();

                if (userString.isEmpty() || passwordString.isEmpty()) {
//                    Have space
                    myAlert myAlert = new myAlert(getActivity());
                    myAlert.myDialog(getString(R.string.have_space),
                            getString(R.string.messge_have_space));








                } else {
//              No Space
                    try {

                        MyConstant myConstant = new MyConstant();
                        GetAllUser getAllUser = new GetAllUser(getActivity());
                        getAllUser.execute(myConstant.getUrlGetAllUserString());

                        String jsonString = getAllUser.get();
                        Log.d("22MarchV1", "JSON==>" + jsonString);

                        String[] columnUserString = myConstant.getLoginStrings();
                        String[] loginStrings = new String[columnUserString.length];
                        boolean statusBool = true;

                        JSONArray jsonArray = new JSONArray(jsonString);
                        for (int i=0; i<jsonArray.length(); i+=1) {

                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            if (userString.equals(jsonObject.getString(columnUserString[2]))) {

                                statusBool = false;
                                for (int i1=0; i1<columnUserString.length; i1+=1) {
                                    loginStrings[i1] = jsonObject.optString(columnUserString[i1]);
                                    Log.d("22marchV1", "loginString[" + i1 + "] ==> " + loginStrings[i1]);

                                }

                            } // if

                        } //  for
                        if (statusBool) {
//                                user fail
                            myAlert nmyAlert = new myAlert(getActivity());
                            nmyAlert.myDialog("User Fales");


                        } else if (passwordString.equals(loginStrings[3])) {
//                          password True

                            Toast.makeText(getActivity(),"welcome"+ loginStrings[1],
                                    Toast.LENGTH_SHORT).show();

                        } else {
//                            password False
                            myAlert nmyAlert = new myAlert(getActivity());
                            nmyAlert.myDialog("Password False", "Please Try Again False");



                        }



                    } catch (Exception e) {
                        e.printStackTrace();

                    }



                }


            }   // onClick
        });


    }

    private void registerController() {
        TextView textView = getView().findViewById(R.id.txtRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                  Replace Fragment
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment, new RegisterFragment())
                        .addToBackStack(null)
                        .commit();



            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }
}  //Main Class
