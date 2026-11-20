package com.androidbook.kotlinbook

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.navigation.NavigationView

class MenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var index  =0
    private lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: Toolbar
    lateinit var navigation : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_5_3)
        drawerLayout = findViewById(R.id.menu)
        val content = findViewById<View>(R.id.menu_content)
        ViewCompat.setOnApplyWindowInsetsListener(content) { view, insets ->
            val bars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }
        ViewCompat.requestApplyInsets(content)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        navigation = findViewById(R.id.navigation)

        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)

        }
        navigation.setNavigationItemSelectedListener(this)
        index = savedInstanceState?.getInt("bannerIndex") ?: 0
        findViewById<ImageView>(R.id.imageView2).setImageResource(
            if (index % 2 == 0) R.drawable.menu_banner1 else R.drawable.menu_banner2)
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) drawerLayout.closeDrawer(GravityCompat.START)
                else finish()
            }
        })

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("bannerIndex", index)
        super.onSaveInstanceState(outState)
    }

    fun onBookListClick(view: View?){

        Toast.makeText(getApplicationContext(),"도서목록 버튼을 클릭하였습니다",Toast.LENGTH_LONG).show()
        val intent : Intent = Intent(this, BooksActivity::class.java)
        startActivity(intent)
    }
    fun onEBookClick(view: View?){
        Toast.makeText(getApplicationContext(),"E-Book 버튼을 클릭하였습니다",Toast.LENGTH_LONG).show()
    }

    fun onCustomerInquiryClick(view: View?){
        Toast.makeText(getApplicationContext(),"고객문의 버튼을 클릭하였습니다",Toast.LENGTH_LONG).show()
    }

    fun onMyPageClick(view: View?){
        Toast.makeText(getApplicationContext(),"나의페이지 버튼을 클릭하였습니다",Toast.LENGTH_LONG).show()
    }

    fun onMarketInfoClick(view: View?){
        Toast.makeText(getApplicationContext(),"마켓정보 버튼을 클릭하였습니다",Toast.LENGTH_LONG).show()
    }
    fun onSettingClick(view: View?){
        Toast.makeText(getApplicationContext(),"설정 버튼을 클릭하였습니다",Toast.LENGTH_LONG).show()
    }

    fun onBannerClick(view: View?){
        val menuObj : ImageView = findViewById(R.id.imageView2)
        if (index %2 == 0) menuObj.setImageResource(R.drawable.menu_banner2)
        else menuObj.setImageResource(R.drawable.menu_banner1)
        index++
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu01 -> {
                Toast.makeText(this, "${item.title} 메뉴를 클릭하였습니다", Toast.LENGTH_SHORT).show()

            }
            R.id.menu03 -> {
                Toast.makeText(this, "${item.title} 메뉴를 클릭하였습니다", Toast.LENGTH_SHORT).show()

            }
            R.id.menu02 -> {
                Toast.makeText(this, "${item.title} 메뉴를 클릭하였습니다", Toast.LENGTH_SHORT).show()

            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}
