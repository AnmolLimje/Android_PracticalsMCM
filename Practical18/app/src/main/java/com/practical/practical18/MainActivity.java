package com.practical.practical18;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtID;
    EditText txtName;
    EditText txtAddress;
    Button btnSave;
    DatabaseHelper databaseHelper;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtID=findViewById(R.id.txtID);
        btnSave=findViewById(R.id.btnSave);
        txtName=findViewById(R.id.txtName);
        txtAddress=findViewById(R.id.txtAddress);
        spinner=findViewById(R.id.spinnerID);
        databaseHelper=new DatabaseHelper(this);

        autoIncID();
        getListOfID();


    }

    private void getListOfID(){
        List<String> list = databaseHelper.getAllID();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //showMessage(parent.getItemAtPosition(position).toString());
                if(parent.getItemAtPosition(position).toString()!="Search") {
                    String[] dat=databaseHelper.getSingleData(parent.getItemAtPosition(position).toString());
                    if(dat[0]!=null){
                        txtID.setText(dat[0]);
                        txtName.setText(dat[1]);
                        txtAddress.setText(dat[2]);
                    }
                    //showMessage(dat[0]+" "+dat[1]+" "+dat[2]);
                }else{
                    //That Means if None Option is selected is ready t insert records
                    txtName.setText("");
                    txtAddress.setText("");
                    autoIncID();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
    }

    private void autoIncID(){
        Integer i=databaseHelper.getNextID();
        txtID.setText(i.toString());
    }

    public void btnSaveClick(View view){
        if(view ==findViewById(R.id.btnSave)){//If Button Saved
            insertDat();
            getListOfID();
        }

        if(view==findViewById(R.id.btnViewAll)){
            GetAllData();
        }

        if(view==findViewById(R.id.update)){
            UpdateData();
            getListOfID();
        }

        if(view==findViewById(R.id.delete)){
            deleteData();
            getListOfID();
        }
    }

    public void showMessage(String Message){
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
    }

    //Notify Users
    public void notifyUser(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    private void insertDat(){
        boolean result=databaseHelper.insertData(txtName.getText().toString(),txtAddress.getText().toString());
        if(result){
            showMessage("Inserted");
            txtName.setText("");
            txtAddress.setText("");
            autoIncID();
        }
        else{
            showMessage("Data Not Inserted");
        }
    }

    private void UpdateData(){
        if(databaseHelper.updateData(Integer.valueOf(txtID.getText().toString()),txtName.getText().toString(),txtAddress.getText().toString())){
            showMessage("Data Updated");
            txtName.setText("");
            txtAddress.setText("");
            autoIncID();
        }else{
            showMessage("Data Not Updated");
        }
    }

    private void deleteData(){
        if(databaseHelper.deleteData(Integer.valueOf(txtID.getText().toString()))){
            showMessage("Data Deleted");
            txtName.setText("");
            txtAddress.setText("");
            autoIncID();
        }else{
            showMessage("Data Not Deleted");
        }
    }

    //To Get All Data
    private void GetAllData(){
        showMessage("Getting Data...");
        Cursor res=databaseHelper.getAllData();
        if(res.getCount()==0)notifyUser("Error: ","No Data Found");

        StringBuffer buffer=new StringBuffer();
        while(res.moveToNext()){
            buffer.append("ID: \t"+res.getString(0)+"\n");
            buffer.append("NAME: \t"+res.getString(1)+"\n");
            buffer.append("ADDRESS: \t"+res.getString(2)+"\n\n\n");
        }

        notifyUser("Data",buffer.toString());

    }
}
