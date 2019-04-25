package com.mx.arges.software.solutions.fragments


import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mx.arges.software.solutions.R
import com.mx.arges.software.solutions.adapters.AdapterWorkingProcess
import com.mx.arges.software.solutions.beans.WorkProcess
import xyz.sangcomz.stickytimelineview.RecyclerSectionItemDecoration
import xyz.sangcomz.stickytimelineview.TimeLineRecyclerView
import xyz.sangcomz.stickytimelineview.model.SectionInfo


class WorkFragment : Fragment() {
    lateinit var mRecyclerTimeline: TimeLineRecyclerView
    lateinit var mAdapter: AdapterWorkingProcess
    lateinit var mView: View
    lateinit var mProcessList: ArrayList<WorkProcess>
    lateinit var icFinkl: Drawable
    lateinit var icBuzz: Drawable

    companion object {
        fun newInstance(): WorkFragment {
            val workFragment = WorkFragment()
            return workFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_work, container, false)
        icFinkl = AppCompatResources.getDrawable(mView.context, R.drawable.ic_finkle)!!
        icBuzz = AppCompatResources.getDrawable(mView.context, R.drawable.ic_buzz)!!
        setUpViews()

        return mView
    }

    private fun setUpViews() {
        mProcessList = ArrayList()
        mRecyclerTimeline = mView.findViewById(R.id.recycler_timeline)
        mRecyclerTimeline.layoutManager = LinearLayoutManager(mView.context, RecyclerView.VERTICAL, false)
        mRecyclerTimeline.setItemViewCacheSize(20)


        mProcessList.add(WorkProcess(false, true, "", "", null, "Hoy", "23 de abril"))
        mProcessList.add(
            WorkProcess(
                true
                , false
                , "Contacto"
                , "Nace una gran idea en nuestros clientes y contactan ARGES LAB."
                , "0"
                , " "
                , " "
            )
        )

        mProcessList.add(WorkProcess(false, true, "", "", null, "Mañana", "24 de abril"))
        mProcessList.add(
            WorkProcess(
                true
                , false, "Validación"
                , "Nos reunimos sin costo con nuestro equipo legal y contable, para analizar si la idea es posible de crear."
                , "1"
                , " "
                , " "
            )
        )

        mProcessList.add(WorkProcess(false, true, "", "", null, "Pasado mañana", "25 de abril"))
        mProcessList.add(
            WorkProcess(
                true
                , false
                , "Decisión"
                , "Te enviamos una propuesta de trabajo y tú decides cuando empezamos a transformar tu idea en realidad."
                , "2"
                , " "
                , " "
            )
        )

        mProcessList.add(WorkProcess(false, true, "", "", null, "Lunes", "29 de abril"))
        mProcessList.add(
            WorkProcess(
                true
                , false
                , "Implementación"
                , "Ajustamos detalles finales y empezamos a desarrollar tus ideas."
                , "3"
                , " "
                , " "
            )
        )

        mProcessList.add(WorkProcess(false, true, "", "", null, "Cada tres semanas ", "20 de mayo, 9 de junio, etc."))
        mProcessList.add(
            WorkProcess(
                true
                , false
                , "Retroalimentación"
                , "Juntas periódicas para ajustar detalles durante todo el desarrollo, asegurándonos que tu aplicación sea lo que siempre soñaste."
                , "4"
                , " "
                , " "
            )
        )

        mProcessList.add(WorkProcess(false, true, "", "", null, "Tres semanas antes de la publicación", "12 de agosto"))
        mProcessList.add(
            WorkProcess(
                true
                , false
                , "Revisión Final"
                , "Un último vistazo a tu aplicación antes de lanzarla al mundo."
                , "5"
                , " "
                , " "
            )
        )

        mProcessList.add(WorkProcess(false, true, "", "", null, "El gran día", "2 de septiembre"))
        mProcessList.add(
            WorkProcess(
                true
                , false
                , "Publicación"
                , "Tu aplicación como siempre la imaginaste en las tiendas de aplicaciones, al alcance de todos tus clientes."
                , "6"
                , " "
                , " "
            )
        )



        mAdapter = AdapterWorkingProcess(mProcessList)
        mRecyclerTimeline.addItemDecoration(getSectionCallback(mProcessList))
        mRecyclerTimeline.adapter = mAdapter
    }

    //Get SectionCallback method
    private fun getSectionCallback(processList: ArrayList<WorkProcess>): RecyclerSectionItemDecoration.SectionCallback {
        return object : RecyclerSectionItemDecoration.SectionCallback {
            //In your data, implement a method to determine if this is a section.
            override fun isSection(position: Int): Boolean {
                return processList[position].isSection!!
            }

            //Implement a method that returns a SectionHeader.
            override fun getSectionHeader(position: Int): SectionInfo? {
                val dot: Drawable? =
                    try {
                        if (processList[position].icon!!.toInt() % 2 == 0) {
                            icFinkl
                        } else {
                            icBuzz
                        }
                    } catch (e: Exception) {
                        null
                    }

                return SectionInfo(
                    processList[position].shortTitle!!,
                    processList[position].shortDescription!!,
                    dot
                )
            }
        }
    }

}
