package mx.tecnm.tepic.ladm_u1_practica1_layouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MainActivity() : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View?
    {
        return inflater.inflate(R.layout.activity_main , container , false)
    }
}