package com.twiekie.avantika_aplicativo_jmr.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.twiekie.avantika_aplicativo_jmr.R
import com.twiekie.avantika_aplicativo_jmr.model.Productos
import com.twiekie.avantika_aplicativo_jmr.view.constants.Constants
import com.twiekie.avantika_aplicativo_jmr.viewmodel.ProductosViewMdel
import io.paperdb.Paper

class MainActivity : AppCompatActivity() {


    private val prodviewmode: ProductosViewMdel by viewModels()
    private lateinit var binding: ViewDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Retrieve NavController from the NavHostFragment
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
       // Paper.init(this)
      // Paper.book().write("contacts", "palitroche");
        prodviewmode.onCreate()
        prodviewmode.prodModel.observe(this,{prod->
            Log.i("parseo",prod.toString())
            /*val data: String? = Paper.book().read("contacts")
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()*/
        })
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        // Set up the action bar for use with the NavController
        setupActionBarWithNavController(navController)
    }
}