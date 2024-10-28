package com.example.presupuesto_databinding

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.presupuesto_databinding.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var bindind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       // setContentView(R.layout.activity_main)
        bindind=DataBindingUtil.setContentView(this, R.layout.activity_main)
       /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
    }
    fun calcularCosto(view: View){
        var n1Text=bindind.edNc.text.toString()
        var n2Text=bindind.edLt.text.toString()
        var n3Text=bindind.edAt.text.toString()

        if (n1Text.isEmpty() || n2Text.isEmpty() || n3Text.isEmpty()) {
            Toast.makeText(this, "No dejes campos vacíos", Toast.LENGTH_SHORT).show()
            return // Salir de la función si hay algún campo vacío
        }
        // Convertir a Int solo si los campos están completos
        val n1 = n1Text.toInt()
        val n2 = n2Text.toInt()
        val n3 = n3Text.toInt()
        var metrosCuadrados= n2 * n3 * 500
        var CostoTotal= metrosCuadrados * n1

         // Formatear el resultado como una cantidad en pesos
        val formatoPesos = NumberFormat.getCurrencyInstance(Locale("es", "MX"))
        bindind.txtResultado.text = formatoPesos.format(CostoTotal)



    }
    fun limpiarCampos(view: View) {
        // Limpiar los campos de entrada
        bindind.edNc.text.clear()
        bindind.edLt.text.clear()
        bindind.edAt.text.clear()

        // Limpiar el resultado
        bindind.txtResultado.text = ""
    }
}