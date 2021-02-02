package br.com.moldato.meuaplicativo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@NonNull  Bundle savedInstanceState) {
        Log.d("CicloVida", "A.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView help_text = (TextView) findViewById(R.id.msg_help_login);
        final EditText ed_name = (EditText) findViewById(R.id.ed_name);
        final EditText ed_password = (EditText) findViewById(R.id.ed_password);
        final ImageView img_success = (ImageView) findViewById(R.id.img_success);
        final Button bt_exit = (Button) findViewById(R.id.bt_exit);
        final Button bt_singup = (Button) findViewById(R.id.bt_singup);
        final Button bt_singin = (Button) findViewById(R.id.bt_singin);

        bt_singup.setText(R.string.bt_text_singup);
        bt_singin.setText(R.string.bt_text_singin);
        help_text.setText(R.string.msg_help_login);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle((ProgressDialog.STYLE_HORIZONTAL));
        progressDialog.setMessage("Esperando ...");

        builder.setMessage("Tem certeza?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        bt_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        bt_singin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String loginStr = ed_name.getText().toString();
                String passwordStr = ed_password.getText().toString();
                if(loginStr != null ){
                    if(passwordStr != null){
                        if(loginStr.equals(passwordStr)){
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            intent.putExtra("login", loginStr);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplicationContext(), "Credencial inválida", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Senha Inválida", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Login Inválido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginStr = ed_name.getText().toString();
                String passwordStr = ed_password.getText().toString();
                if(loginStr != null && loginStr.equals("aluno")){
                    if(passwordStr != null && passwordStr.equals("aluno")){
                        help_text.setText("Seja bem vindo ...");
                        img_success.setImageResource(android.R.drawable.presence_online);
                    }else{
                        Toast.makeText(getApplicationContext(),"Senha Inválida", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Login Inválido", Toast.LENGTH_LONG).show();
                }

            }
        });

        bt_singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_name.setText("");
                ed_password.setText("");
                help_text.setText(R.string.msg_help_login);
                img_success.setImageResource(android.R.drawable.presence_offline);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("CicloVida", "A.onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        Log.d("CicloVida", "A.onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("CicloVida", "A.onResume");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.d("CicloVida", "A.onRestart");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Log.d("CicloVida", "A.onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("CicloVida", "A.onStop");
        Log.d("CicloVida", "Boa noite Leticia");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("CicloVida", "A.onDestroy");
        super.onDestroy();
    }


}