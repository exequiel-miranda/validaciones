package bryan.miranda.validaciones

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1- Mando a llamar a todos los elementos de la vista
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtContrasenia = findViewById<EditText>(R.id.txtContrasenia)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtTelefono = findViewById<EditText>(R.id.txtTelefono)
        val txtDUI = findViewById<EditText>(R.id.txtDUI)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)



        btnGuardar.setOnClickListener {
            // Guardo en una variable los valores que escribió el usuario
            val nombre = txtNombre.text.toString()
            val correo = txtCorreo.text.toString()
            val contrasenia = txtContrasenia.text.toString()
            val edad = txtEdad.text.toString()
            val telefono = txtTelefono.text.toString()
            val DUI = txtDUI.text.toString()


            // Variable para verificar si hay errores
            //La inicializamos en false
            var hayErrores = false

            //TODO: 1- Validar que los campos no estén vacíos
            if (nombre.isEmpty()) {
                txtNombre.error = "El nombre es obligatorio"
                hayErrores = true
            } else {
                txtNombre.error = null
            }
            if (correo.isEmpty()) {
                txtCorreo.error = "El correo es obligatorio"
                hayErrores = true
            } else {
                txtCorreo.error = null
            }

            if (edad.isEmpty()) {
                txtEdad.error = "La edad es obligatoria"
                hayErrores = true
            } else {
                txtEdad.error = null
            }

            if (telefono.isEmpty()) {
                txtTelefono.error = "El teléfono es obligatorio"
                hayErrores = true
            } else {
                txtTelefono.error = null
            }

            if (DUI.isEmpty()) {
                txtDUI.error = "El DUI es obligatorio"
                hayErrores = true
            } else {
                txtDUI.error = null
            }

            if (contrasenia.isEmpty()) {
                txtContrasenia.error = "La contraseña es obligatoria"
                hayErrores = true
            } else {
                txtContrasenia.error = null
            }

            // TODO: 2- Validar que la edad solo contenga números
            if (!edad.matches(Regex("[0-9]+"))) {
                txtEdad.error = "La edad debe contener solo números"
                hayErrores = true
            } else if (edad.toInt() <= 0 || edad.toInt() > 110) {
                txtEdad.error = "Ingrese una edad valida"
                hayErrores = true
            } else {
                txtEdad.error = null
            }


            // TODO: 3- Validar que el correo tenga un formato de correo electrónico
            // Valida que tenga el formato [nombre.apellido123@dominio.extension]
            // Por ejemplo: exequiel.miranda314@gmail.com
            //  Usando:   [A-Za-z0-9+_.-]+ @   [a-z]+  [.] + [a-z]+
            // Ejemplo : [nombre.apellido] @ [dominio] [.] [extension]
            //
            //Si queremos que sea:
            // bryan_miranda@ricaldone.edu.sv, sería usando la misma logica:
            //
            //  Usando:  [A-Za-z0-9+_.-]+ @    [a-z]+   [.]+[a-z]+[.]+[a-z]+
            // Ejemplo: [nombre_apellido] @ [ricaldone] [.] [edu] [.] [sv]
            //
            // Solo se reemplaza lo que está entre comillas
            if (!correo.matches(Regex("[a-zA-Z0-9._-]+@[a-z]+[.][a-z]+"))) {
                txtCorreo.error = "El correo no tiene un formato válido"
                hayErrores = true
            } else {
                txtCorreo.error = null
            }

            // Valida que la contraseña tenga más de 7 dígitos
            if (contrasenia.length <= 7) {
                txtContrasenia.error = "La contraseña debe tener más de 7 caracteres"
                hayErrores = true
            } else {
                txtContrasenia.error = null
            }

            // Valida que el DUI tenga la estructura 12345678-9
            if (!DUI.matches(Regex("[0-9]{8}-[0-9]"))) {
                txtDUI.error = "El DUI no tiene un formato válido. Ej: 12345678-9"
                hayErrores = true
            } else {
                txtDUI.error = null
            }

            // Función para limpiar los campos
            fun limpiarCampos() {
                txtNombre.text.clear()
                txtCorreo.text.clear()
                txtContrasenia.text.clear()
                txtEdad.text.clear()
                txtTelefono.text.clear()
                txtDUI.text.clear()
            }

            // Función para guardar los datos
            fun guardarDatos(
                nombre: String,
                correo: String,
                edad: Int,
                telefono: String,
                DUI: String,
                contraseña: String
            ) {
                // Lógica para guardar los datos
                // Aqui tendría que ir lo de oracle
                Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()
            }

            // Si hay errores, no procede a guardar los datos
            if (hayErrores) {
                //Hacer algo si hay errores
            } else {
                // Si todas las validaciones son correctas, procede a guardar los datos
                guardarDatos(nombre, correo, edad.toInt(), telefono, DUI, contrasenia)
                limpiarCampos()
            }
        }
    }
}