package com.example.fepper

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.Manifest
import android.app.Dialog
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView


class ProfileFragment : Fragment() {

    private lateinit var profileImage: ImageView
    private lateinit var profileBtn: AppCompatButton
    private lateinit var edit: ImageView
    private lateinit var usernameTextView: TextView
    private lateinit var phoneNumberTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var walletActivity: ConstraintLayout
    private lateinit var addressActivity: ConstraintLayout
    private lateinit var termsActivity: ConstraintLayout
    private lateinit var supportActivity: ConstraintLayout
    private lateinit var notificationActivity: ConstraintLayout
   // lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        profileImage = view.findViewById(R.id.profileImage)
        profileBtn = view.findViewById(R.id.profileBtn)
        usernameTextView = view.findViewById(R.id.username)
        phoneNumberTextView = view.findViewById(R.id.userPhoneNo)
        emailTextView = view.findViewById(R.id.userEmail)
        notificationActivity=view.findViewById(R.id.notificationActivity)
        walletActivity=view.findViewById(R.id.walletActivity)
        addressActivity=view.findViewById(R.id.addressActivity)
        termsActivity=view.findViewById(R.id.termsActivity)
        supportActivity=view.findViewById(R.id.supportActivity)

        edit = view.findViewById(R.id.edit)
        edit.setOnClickListener {
            showEditDialog()
        }

        notificationActivity.setOnClickListener{
            val fragment = NotificationFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit()
            //bottomNavigationView.menu.findItem(R.id.navigation_notification)?.setIcon(R.drawable.notification_icon_green)
        }
        walletActivity.setOnClickListener {
            val intent = Intent(requireContext(), WalletActivity::class.java)
            startActivity(intent)
        }
        addressActivity.setOnClickListener {
            val intent = Intent(requireContext(), AddressActivity::class.java)
            startActivity(intent)
        }
        termsActivity.setOnClickListener {
            val intent = Intent(requireContext(), TermsActivity::class.java)
            startActivity(intent)
        }
        supportActivity.setOnClickListener {
            val intent = Intent(requireContext(), SupportActivity::class.java)
            startActivity(intent)
        }



       profileBtn.setOnClickListener {

           ImagePicker.with(this)
               .crop()	    			//Crop image(Optional), Check Customization for more option
               .compress(1024)			//Final image size will be less than 1 MB(Optional)
               .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
               .start()
       }

        return view
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        profileImage.setImageURI(data?.data)
    }


    private fun showEditDialog() {
        val dialogBuilder = Dialog(requireContext(),R.style.CustomDialogTheme)
        dialogBuilder.setContentView(R.layout.details_edit_dialogbox)

        val editTextUsername = dialogBuilder.findViewById<EditText>(R.id.editTextUsername)
        val editTextPhoneNumber = dialogBuilder.findViewById<EditText>(R.id.numberEditText)
        val editTextEmail = dialogBuilder.findViewById<EditText>(R.id.editTextEmail)
        val saveButton = dialogBuilder.findViewById<AppCompatButton>(R.id.saveBtn)

        // Set initial text values to EditTexts
        editTextUsername.setText(usernameTextView.text)
        editTextPhoneNumber.setText(phoneNumberTextView.text)
        editTextEmail.setText(emailTextView.text)


            // Set click listener for save button
            saveButton.setOnClickListener {
                // Update the TextViews in the main layout
                usernameTextView.text = editTextUsername.text
                phoneNumberTextView.text = editTextPhoneNumber.text
                emailTextView.text = editTextEmail.text
                dialogBuilder.dismiss()
            }

            dialogBuilder.show()
    }
    interface BottomNavigationListener {
        fun onNotificationClicked()
    }
}