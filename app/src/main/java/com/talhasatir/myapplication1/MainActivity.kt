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

        // If Control
        println("---------If Statements----------")
        val skor = 15;
        if(skor < 10){
            println("skor: 10 dan küçüktür")
        }
        else if(skor >= 10 && skor <20){
            println("skor 10 ve 20 arasında")
        }
        else{
            println("skor 20 den büyüktür.")
        }

        println("------When-----------")
        var notRakami = 3
        var notStringi = ""

        when(notRakami){
            0 -> notStringi = "Geçersiz Not"
            1 -> notStringi = "Zayıf"
            2 -> notStringi = "Kötü"
            3 -> notStringi = "Orta"
            4 -> notStringi = "İyi"
            else -> notStringi = "Pek İyi"
        }

        // methot işlemleri
        println(notStringi)

        firstFunction()
        cikarmaFunction(9,5);
        println(toplama(4,8))

        binding.change.setOnClickListener{ // change id'ye tıklandığında buraya gir.
            val toplamaSonucu = toplama(10,50)
            binding.textView2.text = "Sonuç: ${toplamaSonucu}"
        }

        sinifCalisasi()
    }

    // xml kısmında butonun onclik'ine nameChange ismini vermiştim => fonksiyonu da buraya yazıyorum
    fun nameChange(view: View){ // view : obje ismi ;; View: obje type // bunları yazma sebebimiz : xml deki id ile çağırmamız.
       // textView.text = "Hello Android"
        binding.textView.text = "Hello binding"
    }

    fun firstFunction(){
        println("first function run")
    }

    // fonksiyona girdi almak
    fun cikarmaFunction(x: Int , y: Int){
        println(x - y)
        binding.textView2.text = "Sonuç: ${x-y}"
    }

    // return
    fun toplama(a: Int, b: Int) : Int{
        return a+b
    }

    fun sinifCalisasi(){
        var name = "Talha"
        var job = "Software"
        var age = 24

        var superman = SuperKahraman("Superman",50,"Developer")

        binding.textView2.text = "Yaş: ${superman.age}"
    }

    fun nullable(){
        //null olaak başlatyoruz int dfeğetri
        var myAge : Int? = null // Int? => null olabilir diyoruz.
        //println(myAge*2) //hata verir : çünkü değerin null olm a ihtimali vardır.
        //println(myAge!!*2) //dedigimde calisacaktir : biz 2 ünlem ile bu deger garanti doludur diyoruz. => eger bos gelirse ama program patlar.

        // elvis operatörü
        var sonuc = myAge?.minus(2) ?: 10 //=> sonuc = myAge-2 (egerki myage bos degil ise) ;; sonuc = 10 // myAge bos ise
        println(sonuc)

        // let
        myAge?.let { //egerrki myAge degeri bos degilse ilgili tag'a gir. => println icerigini yazdır.
            println(it * 5)
        }
    }

}