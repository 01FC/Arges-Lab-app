package com.mx.arges.software.solutions

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomappbar.BottomAppBar
import com.mx.arges.software.solutions.fragments.ArgesFragment
import com.mx.arges.software.solutions.fragments.ContactFragment
import com.mx.arges.software.solutions.fragments.ProductsFragment
import com.mx.arges.software.solutions.fragments.WorkFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //lateinit var mTextView: TextView
    lateinit var mFragmentManager: FragmentManager
    lateinit var mFragmentHome: ArgesFragment
    lateinit var mFragmentContact: ContactFragment
    lateinit var mFragmentProducts: ProductsFragment
    lateinit var mFragmentWork: WorkFragment
    /**
     * OnCreate
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(bottom_app_bar)

        mFragmentManager = supportFragmentManager
        mFragmentHome = ArgesFragment.newInstance()
        mFragmentContact = ContactFragment.newInstance()
        mFragmentProducts = ProductsFragment.newInstance()
        mFragmentWork = WorkFragment.newInstance()

        //mTextView = message
        //mTextView.text = "Hello ARGES"
        estadoInicial()
    }

    /**
     * OnCreateOptionsMenu
     * */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.home, menu)

        return true
    }

    /**
     * OnOptionItemSelectedMenu
     * */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.app_bar_contacto -> {
                //mTextView.text = "Hello contacto"
                showContact()
                bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                bottom_app_bar.replaceMenu(R.menu.contacto)
                fab?.setImageResource(R.drawable.ic_reply)
                fab.setOnClickListener { v ->
                    estadoInicial()
                }
            }
            R.id.app_bar_como_trabajamos -> {
                //mTextView.text = "Hello chamba"
                showWork()
                bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                bottom_app_bar.replaceMenu(R.menu.trabajo)
                fab?.setImageResource(R.drawable.ic_reply)
                fab.setOnClickListener { v ->
                    estadoInicial()
                }
            }
            R.id.app_bar_paquetes -> {
                //mTextView.text = "Hello paquetes"
                showProducts()
                bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                bottom_app_bar.replaceMenu(R.menu.paquetes)
                fab?.setImageResource(R.drawable.ic_reply)
                fab.setOnClickListener { v ->
                    estadoInicial()
                }
            }
        }
        return true
    }

    /**
     * Estado inicial de la aplicacion
     * */
    private fun estadoInicial() {
        //mTextView.text = "Hello ARGES"
        showHome()
        bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        bottom_app_bar.replaceMenu(R.menu.home)
        fab?.setImageResource(R.drawable.arges_log_button)
        fab.setOnClickListener { v ->
            //Toast.makeText(this, "Arges Software Solutions S.A. de C.V.", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Fragment Selector
     * */
    private fun setFragment(fragment: Fragment) {
        mFragmentManager
            .beginTransaction()
            .replace(R.id.main_coordinator, fragment)
            .commit()
    }

    private fun showHome() {
        setFragment(mFragmentHome)
    }

    private fun showContact() {
        setFragment(mFragmentContact)
    }

    private fun showProducts() {
        setFragment(mFragmentProducts)
    }

    private fun showWork() {
        setFragment(mFragmentWork)
    }

    override fun onBackPressed() {
        // Kill application
        AlertDialog.Builder(this)
            .setTitle("")
            .setMessage("Seguro que desea salir de la aplicacion?")
            .setPositiveButton("Salir") { _, _ ->
                val homeIntent = Intent(Intent.ACTION_MAIN)
                homeIntent.addCategory(Intent.CATEGORY_HOME)
                homeIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(homeIntent)
                android.os.Process.killProcess(android.os.Process.myPid())
            }.setNegativeButton("Cancelar") { _, _ ->
            }.show()
    }
}
