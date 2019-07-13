package com.pe.me.wexist.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import com.pe.me.wexist.R
import com.pe.me.wexist.fragments.OthersFragment
import com.pe.me.wexist.fragments.ProfileFragment
import com.pe.me.wexist.fragments.TopicsFragment


class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item->
        when(item.itemId){
            R.id.navigation_topics ->{
                println("Temas")
                replaceFragment(TopicsFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_others ->{
                println("Otros")
                replaceFragment(OthersFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile ->{
                println("Perfil")
                replaceFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(TopicsFragment())
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}
