package com.mx.arges.software.solutions.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mx.arges.software.solutions.R
import com.mx.arges.software.solutions.adapters.AdapterProducts
import com.mx.arges.software.solutions.beans.ExtraProducts

class ProductsFragment : Fragment() {
    lateinit var mRecyclerProductos: RecyclerView
    lateinit var mAdapterProducts: AdapterProducts
    lateinit var mProductsList: ArrayList<ExtraProducts>
    lateinit var mView: View

    companion object {
        fun newInstance(): ProductsFragment {
            val prodFragment = ProductsFragment()
            return prodFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_products, container, false)
        mRecyclerProductos = mView.findViewById(R.id.products_recycler)

        setUpViews(mView)
        return mView
    }

    private fun setUpViews(v: View?) {
        mRecyclerProductos.layoutManager = GridLayoutManager(v!!.context, 2)
        mRecyclerProductos.setItemViewCacheSize(20)
        mRecyclerProductos.setHasFixedSize(true)
        mProductsList = ArrayList()

        mProductsList.add(
            ExtraProducts(
                "1",
                "Diseño de marca.",
                "Te apoyamos a realizar el manual de identidad de la aplicación, logo personalizado, gama de colores y tipografía a utilizar dentro de la aplicación."
            )
        )
        mProductsList.add(
            ExtraProducts(
                "3",
                "Diseño de perfil en las tiendas de aplicaciones.",
                "Te diseñamos un perfil para las tiendas de aplicaciones asegurándonos que transmitas a tus clientes tus ideas con imágenes en los formatos y tamaños correctos."
            )
        )
        mProductsList.add(
            ExtraProducts(
                "5",
                "Términos y condiciones.",
                "Es importante que tus clientes y tú estén protegidos, te ayudamos a lograrlo diseñando términos y condiciones específicos para tus apliaciones, así como avisos de privacidad que cumplan con todos los estándares de las leyes de manejos de datos."
            )
        )
        mProductsList.add(
            ExtraProducts(
                "8",
                "Código de la aplicación.",
                "Contamos con sistema de venta de código fuente de las aplicaciones, el cuál no es aplicable con los paquetes."
            )
        )
        mProductsList.add(
            ExtraProducts(
                "7",
                "Publicación externa.",
                "En Arges publicamos con una licencia para nuestros clientes, pero si deseas la publicación bajo otra licencia nosotros te ayudamos a obtenerla."
            )
        )
        mProductsList.add(
            ExtraProducts(
                "6",
                "Asesoría remota.",
                "Ofrecemos asesoría como servicio para nuestros clientes. Siempre con el compromiso de resolver todas tus dudas y ayudar en cualquier situación."
            )
        )
        mProductsList.add(
            ExtraProducts(
                "4",
                "Registros de propiedad intelectual.",
                "Sabemos que tus ideas son importantes, te ayudamos a protegerlas con registro de nombre, logo e ideas."
            )
        )
        mProductsList.add(
            ExtraProducts(
                "2",
                "Financiaminento.",
                "Te ofrecemos múltiples planes de financiamiento para facilitar el desarrollo de tu proyecto y así juntos poder transformar tu idea en una realidad. Aceptamos las principales tarjetas del mercado."
            )
        )
        mProductsList.add(
            ExtraProducts(
                "0",
                "Asesoría legal y contable.",
                "Servicio de asesoramiento legal, contable y analisis competencias totalmente GRATIS para ayudarte a tomar la mejor decisión posible antes de empezar a desarrollar."
            )
        )
        mProductsList.add(
            ExtraProducts(
                "9",
                "Paquetes para emprendedores.",
                "Ofrecemos los mejores paquetes para facilitar la transformación de tus ideas a realidad. Entre los cuales tenemos E-COMMERCE, PRESENTACIÓN, MANTENIMIENTO ANUAL. Para mayor información contáctanos!"
            )
        )
        bindRecyclerData(mProductsList)

    }

    private fun bindRecyclerData(mProductsList: ArrayList<ExtraProducts>) {
        if (mProductsList.size > 0) {
            mAdapterProducts = AdapterProducts(mProductsList)
            mRecyclerProductos.adapter = mAdapterProducts
        }
    }

}
