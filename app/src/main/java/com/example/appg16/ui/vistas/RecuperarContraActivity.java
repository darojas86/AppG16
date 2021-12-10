package com.example.appg16.ui.vistas;

import android.app.Activity;
import android.content.Context;
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
import com.example.appg16.ui.controladores.RecuperarContraControlador;
import com.example.appg16.ui.utiles.ValidarCorreo;

public class RecuperarContraActivity extends AppCompatActivity {
    private View view;
    private EditText et_a2_correo;
    private Button b_a3_recuperar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contra);

        et_a2_correo=findViewById(R.id.et_a2_correo);
        b_a3_recuperar=findViewById(R.id.b_a3_recuperar);

        view= findViewById(R.id.cllogin);

        et_a2_correo.addTextChangedListener(textWatcher);
    }

    public void recuperar_contraseña (View view){
        RecuperarContraControlador.recuperar(this,getcorreo());

    }
    private boolean habilitar() {

        String correo=getcorreo().trim();

        //Condicion de validacion de los campos de registro
        if (ValidarCorreo.validar(correo))
        {
            b_a3_recuperar.setEnabled(true);
            return true;
        }else{
            b_a3_recuperar.setEnabled(false);
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
        return et_a2_correo.getText().toString().trim();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ocultarTeclado(this,view);
        et_a2_correo.clearFocus();
        return true;
    }
    //Metodo para ocultar teclaro al tocar el fondo de la pantalla(ConstraintLayout)
    private void ocultarTeclado(Context contexto, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) contexto.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
    }
}