package com.cis.bscars


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.NavUtils
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.cis.bscars.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var pressedtime:Long=0
    private lateinit var navController:NavController
    private lateinit var appBarConfiguration:AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //change statusbarcolor
        //window.statusBarColor=this.resources.getColor(R.color.white)
        supportActionBar?.hide()
         navController=findNavController(R.id.nav_fragment)
        val navBar=binding.navbar
        navBar.setupWithNavController(navController)
        appBarConfiguration= AppBarConfiguration(navController.graph)
        //setupActionBarWithNavController(navController,appBarConfiguration)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



    }

    override fun onSupportNavigateUp(): Boolean {
        hideactionbar()
        showNavbar()
        return  navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
        //navController.navigateUp().and(hideactionbar()).and(showNavbar())
    }


    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (pressedtime+2000>System.currentTimeMillis()) {
            onBackPressedDispatcher.onBackPressed()
            finish()
        }else{
            Toast.makeText(this,"press back again to exit",Toast.LENGTH_LONG).show()
        }
        pressedtime=System.currentTimeMillis()
    }

    fun hideNavbar() {
        binding.navbar.visibility=View.INVISIBLE
    }

    fun showNavbar() {
        binding.navbar.visibility=View.VISIBLE
    }

    fun showactionbar() {
        supportActionBar?.show()
    }

    fun hideactionbar() {
        supportActionBar?.hide()

    }

}


