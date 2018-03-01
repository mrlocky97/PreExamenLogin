package com.example.juansebastianquinayasguarin.preexamenlogin;

import android.net.Uri;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements RegistroFragment.OnFragmentInteractionListener, LoginFragment.OnFragmentInteractionListener, PrincipalFragment.OnFragmentInteractionListener {
    private ImageView imagen;
    private EditText usuario, contraseña;
    private Button iniciar, registrar;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = (ImageView) findViewById(R.id.IMGV_imagen);
        usuario = (EditText) findViewById(R.id.ET_nombre);
        contraseña = (EditText) findViewById(R.id.ET_Contraseña);
        iniciar = (Button) findViewById(R.id.btn_iniciarSesion);
        registrar = (Button) findViewById(R.id.btn_registrar);

        firebaseAuth = FirebaseAuth.getInstance();

        pantallaLogin();
    }

    public void pantallaLogin() {
        Fragment fragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.activitymain, fragment).commit();
    }

    public void pantallaRegistro() {
        Fragment fragment = new RegistroFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.activitymain, fragment).commit();
    }

    public void pantallaPrincipal(){
        Fragment fragment = new PrincipalFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.activitymain, fragment).commit();
    }

    public void registrarUsuario(final String nombre, final String hotmail, final String contraseña) {
        firebaseAuth.createUserWithEmailAndPassword(hotmail, contraseña).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.v("autenticacion", "Creando usuario con hotmail en proceso..." + task.isSuccessful());
                if (!task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "autentificacion fallida.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "autenticacion correcta.", Toast.LENGTH_SHORT).show();
                    Usuario user = new Usuario(nombre, hotmail, contraseña);
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("usuarios");
                    DatabaseReference databaseReference1 = databaseReference.child(firebaseAuth.getCurrentUser().getUid());
                    databaseReference1.setValue(new Usuario(user.getNombre(),user.getHotmail(),user.getContraseña()));
                }
            }
        });
    }

    public void logearse(String hotmail, String contraseña){
        FirebaseAuth fauth = FirebaseAuth.getInstance();
        fauth.signInWithEmailAndPassword(hotmail,contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "se ha logeado con exito.",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "error de logeo vuelva a intentarlo.",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
