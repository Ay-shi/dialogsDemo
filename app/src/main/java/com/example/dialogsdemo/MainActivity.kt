package com.example.dialogsdemo

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogsdemo.databinding.ActivityMainBinding
import com.example.dialogsdemo.databinding.CustomDialogBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
        binding.dialog1.setOnClickListener{
            Snackbar.make(it,"you have clicked the button",Snackbar.LENGTH_LONG).show()
        }
        binding.dialog2.setOnClickListener{
            var options= arrayOf("pink","blue","red","green")
            var builder=AlertDialog.Builder(this)
            builder.setTitle("What is your favourite color")
            builder.setSingleChoiceItems(options,0) { dialogInterface, i ->
                run {
                    Toast.makeText(this, "you selected ${options[i]}", Toast.LENGTH_SHORT).show()
                    dialogInterface.dismiss()
                }
            }
            builder.setIcon(R.drawable.ic_launcher_foreground)
            builder.setCancelable(false)
            builder.create().show()
        }
        binding.dialog3.setOnClickListener {
            var binding=CustomDialogBinding.inflate(layoutInflater)
            val view=binding.root
            val customDialog= Dialog(this)
            customDialog.setContentView(view)
            binding.tvCancel.setOnClickListener {
                Toast.makeText(this,"clicked cancel",Toast.LENGTH_SHORT ).show()
                //can use applicationContext if this not working in place of context attribute
                customDialog.dismiss()
            }
            binding.tvSubmit.setOnClickListener {
                Toast.makeText(this,"clicked submit",Toast.LENGTH_SHORT ).show()
                customDialog.dismiss()
            }
            customDialog.show()
        }
        binding.dialog4.setOnClickListener {
             val progressDialog= Dialog(this)
            progressDialog.setContentView(R.layout.progress_dialog)
            progressDialog.show()
        }
    }
}