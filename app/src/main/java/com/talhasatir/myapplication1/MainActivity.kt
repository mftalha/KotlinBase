package com.talhasatir.myapplication1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.talhasatir.myapplication1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    // bu değişken ile artık xml sayfasındaki verilere erişeceğiz. binding.IlgiliId
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // bu kısımda layout sayfasını çağırıyprduk : viewbinding kullandığımızdan artık kullanmıyoruz
        // o yüzde yorum satırına alıp aşşağıdaki 2 satır ile layout'umuzu çağırıp sayfaya basıyoruz.
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // xml kısmında butonun onclik'ine nameChange ismini vermiştim => fonksiyonu da buraya yazıyorum
    fun nameChange(view: View){ // view : obje ismi ;; View: obje type
       // textView.text = "Hello Android"
        binding.textView.text = "Hello binding"
    }
}