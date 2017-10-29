package com.example.user.afinal.Views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.afinal.Controller.UserController;
import com.example.user.afinal.Domain.User;
import com.example.user.afinal.R;
/**
 * Created by User on 28/10/2017.
 */

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        final EditText userName = (EditText) findViewById(R.id.campo_userName);
        final EditText name = (EditText) findViewById(R.id.campo_name);
        final EditText lastName = (EditText) findViewById(R.id.campo_lastName);
        final EditText password = (EditText) findViewById(R.id.campo_password);
        final EditText age = (EditText) findViewById(R.id.campo_age);
        final EditText rol = (EditText) findViewById(R.id.campo_rol);
        final Button sign = (Button) findViewById(R.id.sign);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User person3 = new User(userName.getText().toString(), name.getText().toString(), lastName.getText().toString(), password.getText().toString(), rol.getText().toString(), Integer.parseInt(age.getText().toString()));
                boolean usersCreate = new UserController(getApplicationContext()).create(person3);
                if (usersCreate)
                    Toast.makeText(getApplicationContext(), "Usuario creado exitosamente", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "No fue posible crear Usuario", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
