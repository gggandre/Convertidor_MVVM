package mx.itesm.ag.convertidor_mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import mx.itesm.ag.convertidor_mvvm.databinding.ActivityMainBinding
import mx.itesm.ag.convertidor_mvvm.viewmodel.ConvertidorVM


//Vista
class MainActivity : AppCompatActivity() {
        //viewbinding
        private lateinit var binding: ActivityMainBinding
        private val convertidorVM: ConvertidorVM by viewModels()

        //Referencia al view Model
        //El viewnmodel tiene variables livedata y me puedo suscribir a sus cambios


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            //Configuraciones
            registrarObservadores()  //Suscribirse a los cambios
            registrarEventos()  //Atender el click del botón

            }

    private fun registrarEventos() {
        binding.btnConvertir.setOnClickListener {
            val km = binding.etKilometros.text.toString().toDouble()
            convertidorVM.convertir(km)
        }
    }

    private fun registrarObservadores() {
            //Suscribe a los cambios.
                convertidorVM.millas.observe(this) {
                    //Mostrarlo e millas
                    binding.etMillas.setText(it.toString())

    }

    }
}
