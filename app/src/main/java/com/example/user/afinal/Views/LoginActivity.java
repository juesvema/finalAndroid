package com.example.user.afinal.Views;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.user.afinal.Controller.ApplicationController;
import com.example.user.afinal.R;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout tilNombre;
    private TextInputLayout tilPassword;
    ApplicationController appController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appController = (ApplicationController) getApplication();
        tilNombre = (TextInputLayout) findViewById(R.id.til_nombre);
        tilPassword = (TextInputLayout) findViewById(R.id.til_password);

        Button fab = (Button) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);
            }
        });

        Button botonAceptar = (Button) findViewById(R.id.btnLogin);
        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = tilNombre.getEditText().getText().toString();
                String password = tilPassword.getEditText().getText().toString();
                appController.authenticate(nombre, password);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

}
