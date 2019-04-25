package com.mx.arges.software.solutions.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mx.arges.software.solutions.R
import com.mx.arges.software.solutions.adapters.AdapterWhoWeAre
import com.mx.arges.software.solutions.beans.Hacemos
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.scheduleAtFixedRate


class ArgesFragment : Fragment() {

    lateinit var mLogo: ImageView
    lateinit var mDescription: TextView
    lateinit var mRecyclerView: RecyclerView
    lateinit var mAdapter: AdapterWhoWeAre
    lateinit var mHacemosList: ArrayList<Hacemos>
    lateinit var mIndicator: ScrollingPagerIndicator
    val timer = Timer()
    var position = 0

    companion object {
        fun newInstance(): ArgesFragment {
            val homeFragment = ArgesFragment()
            return homeFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_arges, container, false)
        mLogo = v.findViewById(R.id.home_arges_logo)
        mDescription = v.findViewById(R.id.home_quienes_somos_description)
        mRecyclerView = v.findViewById(R.id.home_recycler)
        mIndicator = v.findViewById(R.id.indicator)
        setUpViews(v)
        return v
    }

    private fun setUpViews(v: View?) {
        mRecyclerView.layoutManager = LinearLayoutManager(v!!.context, LinearLayoutManager.HORIZONTAL, false)
        mRecyclerView.setItemViewCacheSize(20)

        mHacemosList = ArrayList()
        mHacemosList.add(
            Hacemos(
                "0"
                ,
                "Transformamos tus ideas en aplicaciones innovadoras."
                ,
                "Garantía de servicio."
                ,
                "Tus ideas son lo mas preciado, deja que nosotros te ayudemos a llevarlas al mundo digital para ponerlas al alcance de tus clientes."
            )
        )
        mHacemosList.add(
            Hacemos(
                "1"
                ,
                "Aplicamos las últimas tendencias de diseño."
                ,
                "Vivimos las tendencias de diseño."
                ,
                "Nos enfocamos en que tu aplicación sea sencilla de utilizar para cualquier público.\nNos enfocamos en proporcionar la mejor experiencia de usuario posible a tus clientes para que siempre quieran regresar a tu aplicación."
            )
        )
        mHacemosList.add(
            Hacemos(
                "2"
                ,
                "Desarrollo móvil Android, IOS y web nativo."
                ,
                "Completamente nativo."
                ,
                "Realizamos la aplicación de manera específica para cada sistema operativo asegurando la mejor calidad y desempeño para la mejor experiencia en ambas plataformas."
            )
        )
        mHacemosList.add(
            Hacemos(
                "3"
                ,
                "Trasladamos tu proyecto de idea a realidad."
                ,
                "Impulsa tu proyecto."
                ,
                "Trasladamos tu proyecto de idea a realidad, desarrollando una aplicación con presencia en todas las plataformas (móviles y web)."
            )
        )
        mHacemosList.add(
            Hacemos(
                "4"
                ,
                "Asesoramiento legal y contable."
                ,
                "Asesoramiento legal y contable."
                ,
                "Te ayudamos a comprender las implicaciones legales y contables de tu idea sin costo, para que tomes la mejor decisión antes de empezar a desarrollarla."
            )
        )
        mHacemosList.add(
            Hacemos(
                "5"
                ,
                "Asesoría y capacitación remota."
                ,
                "Garantía de servicio."
                ,
                "Contamos con asesorías y servicio para nuestros clientes. Siempre con el compromiso de resolver todas tus dudas y ayudar en cualquier situación."
            )
        )
        mHacemosList.add(
            Hacemos(
                "6"
                ,
                "Aplicaciones listas para descargar."
                ,
                "Listas para descargar y usarse."
                ,
                "Todas las aplicaciones creadas serán publicadas en la tienda correspondiente para facilitar el acceso a tus clientes."
            )
        )
        mHacemosList.add(
            Hacemos(
                "7"
                ,
                "Panel de administración."
                ,
                "Control total de tu aplicación."
                ,
                "Sin necesidad de recurrir a terceros.\nAdministra y gestiona el contenido de tus aplicaciones desde cualquier lugar en tiempo real con nuestro panel de administración web.\nTener control total nunca había sido tan fácil."
            )
        )


        bindRecyclerData(mHacemosList)
    }

    private fun bindRecyclerData(hacemosList: ArrayList<Hacemos>) {
        if (hacemosList.size > 0) {

            mAdapter = AdapterWhoWeAre(hacemosList)
            mRecyclerView.adapter = mAdapter
            mIndicator.attachToRecyclerView(mRecyclerView, 0)
            // al principio se tarda 4000 milisegundos y despues hace cambios cada 4500 milisegundos
            // se enloquece al cambiar de fragmento
            /*timer.scheduleAtFixedRate(4000, 4500) {
                *//*println("Recycler position -> ${(mRecyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()}")
                println("Position -> $position")*//*
                if (position == mAdapter.itemCount) {
                    position = 0
                }
                mRecyclerView.smoothScrollToPosition(position++)
            }*/
        }
    }

}
