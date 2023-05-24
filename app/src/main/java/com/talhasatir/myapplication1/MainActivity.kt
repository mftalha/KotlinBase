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

        //**************************

        println("Hello Word")
        println(5*10)
        var yas = 40 // değişken tanımlama
        val x =10  // sabit sayı tanımalama : daha sonra değiştiirlemez.

        val integerValue: Int = 5
        val stringValue: String
        stringValue = "test string"

        // ------- data type change
        val IntVal = 10
        val changeInt = IntVal.toLong() // int change => long

        var userEntry = "50"
        var IntVal2 = userEntry.toInt()
        println(IntVal2 / 2)

        // --------------- array
        var myArray = arrayOf("Talha","Uzay","Dünya","Araba","Gezegen")
        myArray[0]
        myArray.get(0) // bu şekildede dizinin istediğimiz dizinini alabilioruz.
        myArray.set(3,"Motor") // dizi içindeki veriyi değiştimek içinv

        // --
        val numberArray = doubleArrayOf(1.0,2.0,3.5)
        println(numberArray.get(2))

        val mixedArray = arrayOf("Talha",24,true,15.2) // gini karışık dizilerde olusturabilirz.
        println(mixedArray[0])

        // -------------- ArrayList => array'in daha gelişmiş hali
        val nameList = arrayListOf("Talha","Space","World") // bu şekilde oluşturuyoruz.
        val nameList2 = arrayListOf<String>()  //bu şekildede bırakabiliyoruz.
        println(nameList[0])
        println(nameList.get(1))

        nameList.add("Table") // arrayden farklı add diyip ekleme yapabiliyoruz : arrayList'de

        val mixArrayList = arrayListOf<Any>() // karışık diziler için.
        mixArrayList.add("apple")
        mixArrayList.add(3)

        // ---------------- string interpreter => string tırnağı içinde kotlin kodu yazmak.
        println("dizinin 2. elemanı: ${mixArrayList[0]}")

        println("set - loop block")
        // ----------- setOf (dizi gibi ama içine biz kaçtane aynı elemandan verirsek verelim o 1 tane tutar : tekrar yaptırmaz.)
        val myArraySet = setOf<Int>(7,8,9,9,9,8,10)
        println("myArraySet.size: ${myArraySet.size}")

        //For Each
        myArraySet.forEach{
            println(it)
        }

        // Map
        println("-------Map----------")
        val yemekArray = arrayOf("Elma","Et","Tavuk")
        val kaloriArray = arrayOf(100,300,200)

        println("${yemekArray[0]}'nın kalorisi: ${kaloriArray[0]}")

        val yemekKaloriMap = hashMapOf<String, Int>()
        yemekKaloriMap.put("Elma",100)
        yemekKaloriMap.put("Et",300)
        yemekKaloriMap.put("Tavuk",200)
    }

    // xml kısmında butonun onclik'ine nameChange ismini vermiştim => fonksiyonu da buraya yazıyorum
    fun nameChange(view: View){ // view : obje ismi ;; View: obje type
       // textView.text = "Hello Android"
        binding.textView.text = "Hello binding"
    }
}