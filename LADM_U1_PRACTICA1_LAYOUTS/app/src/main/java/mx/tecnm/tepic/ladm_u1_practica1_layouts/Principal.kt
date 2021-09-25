package mx.tecnm.tepic.ladm_u1_practica1_layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Principal : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout

    // ICONO MENU
    lateinit var icono_menu: ImageView

    // TEXTO TITULO
    lateinit var txt_titulo: TextView


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        navigationView = findViewById(R.id.nav_view)
        drawerLayout = findViewById(R.id.drawer_layout)
        icono_menu = findViewById(R.id.boton_menu_lateral)
        txt_titulo = findViewById(R.id.txt_titulo)

        supportFragmentManager.beginTransaction().add( R.id.contenido , Portada() ).commit()
        txt_titulo.setText("Portada")

        icono_menu.setOnClickListener{ it ->
            drawerLayout.openDrawer(GravityCompat.START)
        }

      //  icono_menu = ActionBarDrawerToggle(this , drawerLayout , R.string.drawer_open , R.string.drawer_close)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        selectItemNav(item)
        return false
    }

    private fun selectItemNav(item: MenuItem) {
        var fm = supportFragmentManager
        var ft = fm.beginTransaction()
        when( item.itemId )
        {
            R.id.portada -> ft.replace(R.id.contenido , Portada() ).commit()
            R.id.p1 -> ft.replace(R.id.contenido , MainActivity() ).commit()
            R.id.p2 -> ft.replace(R.id.contenido , Pantalla2() ).commit()
            R.id.p3 -> ft.replace(R.id.contenido , Pantalla3() ).commit()
            R.id.p4 -> ft.replace(R.id.contenido , Pantalla4() ).commit()
            R.id.p5 -> ft.replace(R.id.contenido , pantalla5() ).commit()
            R.id.p6 -> ft.replace(R.id.contenido , Pantalla6() ).commit()
            R.id.p7 -> ft.replace(R.id.contenido , Pantalla7() ).commit()
            R.id.p8 -> ft.replace(R.id.contenido , Pantalla8() ).commit()
        }
        txt_titulo.setText( item.title )
        drawerLayout.closeDrawers()
    }
}