package com.asadbek.viewpager2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.asadbek.viewpager2.adapters.ViewPagerAdapter
import com.asadbek.viewpager2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var otkList = mutableListOf<String>()
    private var themeList = mutableListOf<String>()
    private var aboutList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()
    lateinit var listAbout:ArrayList<String>
    lateinit var listTheme:ArrayList<String>
    lateinit var listImage:ArrayList<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listAbout = ArrayList()
        listTheme = ArrayList()
        listImage = ArrayList()

        sync()
        posToList()



        binding.viewpager2.adapter = ViewPagerAdapter(otkList,themeList,aboutList)
        binding.viewpager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL


    }

    private fun addToList(otk:String,theme:String,about:String,img:Int){
        otkList.add(otk)
        themeList.add(theme)
        aboutList.add(about)
        imageList.add(img)
    }

    private fun sync() {
        listTheme.add("Xush kelibsiz")
        listAbout.add("Kim ko‘rubdur, ey ko‘ngul, ahli jahondin yaxshilig‘, \n" +
                "Kimki, ondin yaxshi yo‘q, ko‘z tutma ondin yaxshilig‘")
        listImage.add(R.drawable.earphone)
        listTheme.add("Hikoyalar dunyosi")
        listAbout.add("Gar zamonni nayf qilsam ayb qilma, ey rafiq, \n" +
                "Ko‘rmadim hargiz, netoyin, bu zamondin yaxshilig‘ ! ")
        listTheme.add("Kitob ortidan...")
        listImage.add(R.drawable.earphones_2)
        listAbout.add("Dilrabolardin yomonliq keldi mahzun ko‘ngluma,\n" +
                " Kelmadi jonimg'a hech oromi jondin yaxshilig'.")
        listTheme.add("Bizga qo`shiling")
        listImage.add(R.drawable.earphones_3)
        listAbout.add("Ey ko‘ngul, chun yaxshidin ko‘rdung yamonliq asru ko‘p,\n" +
                " Emdi ko‘z tutmoq ne ma’ni har yamondin yaxshilig'?")
        listImage.add(R.drawable.hom1)
    }

    private fun posToList() {
        for (i in 0..3){
            addToList("O`tkazib yuborish",listTheme[i],listAbout[i],listImage[i])
        }
    }
}