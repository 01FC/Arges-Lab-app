package com.mx.arges.software.solutions.fragments


import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mx.arges.software.solutions.R

class ContactFragment : Fragment(), View.OnClickListener {
    // buttons
    lateinit var mFloatFb: FloatingActionButton
    lateinit var mFloatInsta: FloatingActionButton
    lateinit var mFloatTel: FloatingActionButton
    lateinit var mFloatMail: FloatingActionButton
    lateinit var mView: View
    lateinit var mImageContact: ImageView


    companion object {
        fun newInstance(): ContactFragment {
            val contactFragment = ContactFragment()
            return contactFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_contact, container, false)

        mFloatFb = mView.findViewById(R.id.contact_fb)
        mFloatInsta = mView.findViewById(R.id.contact_insta)
        mFloatTel = mView.findViewById(R.id.contact_cel)
        mFloatMail = mView.findViewById(R.id.contact_mail)
        mImageContact = mView.findViewById(R.id.contact_map)

        mImageContact.setOnClickListener(this)
        mFloatFb.setOnClickListener(this)
        mFloatInsta.setOnClickListener(this)
        mFloatTel.setOnClickListener(this)
        mFloatMail.setOnClickListener(this)
        return mView
    }


    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.contact_fb -> {
                seeFb()
            }
            R.id.contact_insta -> {
                seeInsta()
            }
            R.id.contact_cel -> {
                newCall()
            }
            R.id.contact_mail -> {
                sendMail()
            }
            R.id.contact_map -> {
                //intent
                launchDirectionsIntent()
            }
        }

    }

    private fun launchDirectionsIntent() {
        try {
            val uri = "geo: 20.604868, -103.414761?q=20.604868,-103.414761 (Arges Software Solutions S.A. de C.V.)"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            mView.context.startActivity(intent)

        } catch (e: Exception) {
            try {
                val uri = "https://play.google.com/store/apps/details?id=com.google.android.apps.maps"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                mView.context.startActivity(intent)
            } catch (x: Exception) {

            }
        }

    }

    private fun getOpenFacebookIntent(): Intent {
        val userFb = "ARGESLAB"
        val profileId = "213004999632297"
        try {
            mView.context.packageManager.getPackageInfo("com.facebook.katana", 0)
            return Intent(
                Intent.ACTION_VIEW,
                Uri.parse("fb://profile/$profileId")
            )
        } catch (e: Exception) {
            return Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com/$userFb")
            )
        }
    }

    private fun seeFb() {
        val fbIntent = getOpenFacebookIntent()
        mView.context.startActivity(fbIntent)
    }

    private fun isIntentAvailable(intent: Intent): Boolean {
        val packageManager: PackageManager = mView.context.packageManager
        val listResolvers: List<ResolveInfo> =
            packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
        return listResolvers.size > 0
    }

    private fun seeInsta() {
        val instaUser = "argeslab"
        val uri = Uri.parse("https://instagram.com/_u/$instaUser")
        val instaIntent = Intent(Intent.ACTION_VIEW, uri)
        instaIntent.`package` = "com.instagram.android"
        if (isIntentAvailable(instaIntent)) {
            mView.context.startActivity(instaIntent)
        } else {
            mView.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/$instaUser")))
        }
    }

    private fun newCall() {
        val phone = "+5213313131784"
        val uri = Uri.parse("tel:$phone")
        val callIntent = Intent(Intent.ACTION_DIAL, uri)
        mView.context.startActivity(callIntent)
    }

    private fun sendMail() {
        val mail = "contacto@argeslab.com"
        val uri = Uri.parse("mailto:$mail").buildUpon().build()
        val emailIntent = Intent(Intent.ACTION_SENDTO, uri)
        mView.context.startActivity(
            Intent.createChooser(
                emailIntent,
                mView.resources.getString(R.string.contacto_correo)
            )
        )
    }

}
