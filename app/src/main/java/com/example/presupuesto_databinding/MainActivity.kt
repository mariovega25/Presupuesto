package com.example.presupuesto_databinding

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.presupuesto_databinding.databinding.ActivityMainBinding

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
        var n1=bindind.edNc.text.toString().toInt()
        var n2=bindind.edLt.text.toString().toInt()
        var n3=bindind.edAt.text.toString().toInt()
        var metrosCuadrados= n2 * n3 * 500
        var CostoTotal= metrosCuadrados * n1
        bindind.txtResultado.text=CostoTotal.toString()


    }
}