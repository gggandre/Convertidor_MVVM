package mx.itesm.ag.convertidor_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.ag.convertidor_mvvm.model.Convertidor

class ConvertidorVM: ViewModel() {
    //El viewmodel de la vist


    //modelo
    private val modelo = Convertidor()

    //variables -> conectan el modelo y la vista
    //LiveData si no, no sirven como conexión
    //La vista se suscribe a estas variables
    val millas = MutableLiveData<Double>(0.0)

    //Interface
    fun convertir(km: Double){
        millas.value = modelo.convertirKmMi(km)

    }
}
