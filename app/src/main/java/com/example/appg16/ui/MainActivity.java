package com.example.appg16.ui;

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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appg16.R;
import com.example.appg16.ui.controladores.LoginControlador;
import com.example.appg16.ui.utiles.ValidarCorreo;
import com.example.appg16.ui.vistas.RecuperarContraActivity;
import com.example.appg16.ui.vistas.RegistroActivity;

public class MainActivity extends AppCompatActivity {

    private EditText et_usuario,et_clave;
    private TextView tv_recuperar_contraseña;
    private Button a1_b_ingresar;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_usuario=findViewById(R.id.et_usuario);
        et_clave=findViewById(R.id.et_clave);
        tv_recuperar_contraseña=findViewById(R.id.tv_recuperar_contraseña);
        a1_b_ingresar=findViewById(R.id.a1_b_ingresar);

        view= findViewById(R.id.cllogin);

        et_usuario.addTextChangedListener(textWatcher);
        et_clave.addTextChangedListener(textWatcher);


    }
    public void registrar (View view){
        Intent i= new Intent(this, RegistroActivity.class);
        startActivity(i);
    }
    public void login (View view){
        //Controlador para validar el ingreso del usuario creado en Firebase
        LoginControlador.login(this,getcorreo(),getclave());
    }
    public void recuperar_contraseña (View view){
        Intent i= new Intent(this, RecuperarContraActivity.class);
        startActivity(i);
    }
    private boolean habilitar() {

        String correo=getcorreo().trim();
        String clave=getclave().trim();

        //Condicion de validacion de los campos de registro
        if ((clave.length()>2)&& ValidarCorreo.validar(correo))
        {
            a1_b_ingresar.setEnabled(true);
            return true;
        }else{
            a1_b_ingresar.setEnabled(false);
            return false;
        }
    }
    //Escuchador en cambios de teclado
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            habilitar();
        }
        @Override
        public void afterTextChanged(Editable s) {}
    };

    private String getcorreo() {
        return et_usuario.getText().toString().trim();
    }

    private String getclave() {
        return et_clave.getText().toString().trim();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ocultarTeclado(this,view);
        et_usuario.clearFocus();
        et_clave.clearFocus();
        return true;
    }
    //Metodo para ocultar teclaro al tocar el fondo de la pantalla(ConstraintLayout)
    private void ocultarTeclado(Context contexto, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) contexto.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
    }
}