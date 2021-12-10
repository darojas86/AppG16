package com.example.appg16.ui.vistas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appg16.R;
import com.example.appg16.ui.MainActivity;
import com.example.appg16.ui.controladores.RegistroControlador;
import com.example.appg16.ui.utiles.ValidarCorreo;

public class RegistroActivity extends AppCompatActivity {
    private EditText a2_et_nombre,et_correo,etclaveregistro1,etclaveregistro2;
    private Button b_completar_registro;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        //Captura de elementos graficos
        a2_et_nombre=findViewById(R.id.a2_et_nombre);
        et_correo=findViewById(R.id.et_correo);
        etclaveregistro1=findViewById(R.id.etclaveregistro1);
        etclaveregistro2=findViewById(R.id.etclaveregistro2);
        b_completar_registro=findViewById(R.id.b_completar_registro);
        //Captura constraintlayout para evento de teclado
        view= findViewById(R.id.clregistro);
        //Asignacion de escuchadores evento del teclado
        a2_et_nombre.addTextChangedListener(textWatcher);
        et_correo.addTextChangedListener(textWatcher);
        etclaveregistro1.addTextChangedListener(textWatcher);
        etclaveregistro2.addTextChangedListener(textWatcher);

    }

    private boolean habilitar() {

        String nombre=getnombre().trim();
        String correo=getcorreo().trim();
        String clave=getclaveregistro1().trim();
        String confirmarclave=getclaveregistro2().trim();
        //Condicion de validacion de los campos de registro
        if (clave.equals(confirmarclave)&&(nombre.length()>2) && (clave.length()>2)&& ValidarCorreo.validar(correo))
        {
            b_completar_registro.setEnabled(true);
            return true;
        }else{
            b_completar_registro.setEnabled(false);
            return false;
        }

    }

    //Escuchador en cambios de teclado
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            habilitar();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    public void volver (View view){
        Intent i= new Intent(this, MainActivity.class);
        startActivity(i);
    }
    //Onclick boton registrar
    public void registro (View view){
        RegistroControlador.registro(this,getnombre(),getcorreo(),getclaveregistro1());
    }

    private String getnombre() {
        return a2_et_nombre.getText().toString().trim();
    }

    private String getcorreo() {
        return et_correo.getText().toString().trim();
    }

    private String getclaveregistro1() {
        return etclaveregistro1.getText().toString().trim();
    }

    private String getclaveregistro2() {
        return etclaveregistro2.getText().toString().trim();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ocultarTeclado(this,view);
        a2_et_nombre.clearFocus();
        et_correo.clearFocus();
        etclaveregistro1.clearFocus();
        etclaveregistro2.clearFocus();
        return true;
    }

    private void ocultarTeclado(Context contexto, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) contexto.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
    }
}