package edu.rockvalleycollege.week6

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spin = findViewById<Spinner>(R.id.spinner)
        val txtCA = findViewById<EditText>(R.id.txtCurrentAge)
        val txtRA = findViewById<EditText>(R.id.txtRetireAge)
        val txtShow = findViewById<TextView>(R.id.txtShow)
        txtShow.isFocusable = false
        val btnSub = findViewById<Button>(R.id.btnSubmit)
        val list = arrayOf("None","A Little", "A Lot", "Most")
        val adapter1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list)
        val message = "Thanks for using my app, Cheers!"

        txtCA.requestFocus();
        android.R.layout.simple_spinner_item
        android.R.layout.simple_spinner_dropdown_item
        spin.adapter = adapter1

        btnSub.setOnClickListener{


            txtCA.requestFocus();
            when(spin.selectedItem.toString()){
                "None" -> txtShow.text = "Current Age: ${txtCA.text.toString()} \nRetirement Age: ${txtRA.text.toString()} \n" +
                                         "An FDIC-insured savings account is most suitable for someone with your risk tolerance.\n"+
                                         "$message"


                "A Little" -> txtShow.text = "Current Age: ${txtCA.text.toString()} \nRetirement Age: ${txtRA.text.toString()} \n" +
                                             "A portfolio of bond funds is most suitable for someone with your risk tolerance.\n"+
                                             "$message"

                "A Lot" -> txtShow.text = "Current Age: ${txtCA.text.toString()} \nRetirement Age: ${txtRA.text.toString()} \n" +
                                          "A portfolio of 80% equity funds and 20% bond funds is most suitable for someone with your risk tolerance.\n"+
                                          "$message"

                "Most" -> txtShow.text = "Current Age: ${txtCA.text.toString()} \nRetirement Age: ${txtRA.text.toString()} \n" +
                                         "A portfolio of equity funds and individual stocks is most suitable for someone with your risk tolerance \n"+
                                         "$message"

            }

            txtCA.setText("")
            txtRA.setText("")
            hideKeyboard()
        }
        findViewById<View>(android.R.id.content).setOnTouchListener { _, _ ->
            hideKeyboard()
            false
        }
    }

        fun hideKeyboard() {
            try {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)

            } catch (e: Exception) {

            }

        }





//NOTHING BELOW HERE
}