package iuh_ad_nguyenanhtoan.msv_19447201.calculating_net_income

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    var ck = '1'
    var gross =""
    var a= ""
    var tax_rate=0
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val swt: Switch = findViewById(R.id.switch1)
        val cal : Button = findViewById(R.id.button)
        val net_income: TextView = findViewById(R.id.textView2)
        val radioButton1: RadioButton = findViewById(R.id.radioButton3)
        val radioButton2: RadioButton = findViewById(R.id.radioButton2)
        val radioButton3: RadioButton = findViewById(R.id.radioButton)
        swt?.setOnCheckedChangeListener({ _ , isChecked ->
            val message = if (isChecked) "Switch1:ON" else "Switch1:OFF"
            Toast.makeText(this@MainActivity, message,
                Toast.LENGTH_SHORT).show()
        })

        radioButton1.setOnClickListener(){
            tax_rate= 25/100
        }
        radioButton2.setOnClickListener(){
            tax_rate= 20/100
        }
        radioButton3.setOnClickListener(){
            tax_rate= 15/100
        }
        cal.setOnClickListener {
             ck='1'
            calculate()
        }
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode", "SetTextI18n")
    private fun calculate(){
        val swt: Switch = findViewById(R.id.switch1)
        val net_income: TextView = findViewById(R.id.textView2)
        val gross_income: TextView = findViewById(R.id.gross_income_edit_text)
        val radioButton1: RadioButton = findViewById(R.id.radioButton3)
        val radioButton2: RadioButton = findViewById(R.id.radioButton2)
        val radioButton3: RadioButton = findViewById(R.id.radioButton)
        var message=""
        swt?.setOnCheckedChangeListener({ _ , isChecked ->
            if (isChecked) {
                message = "ok"
            }
            else {
                message="no"
                }
        })


        if (ck.equals('1') && message.equals("ok")){

//            gross_income.text = ''((1 - tax_rate).toString())
            net_income.text ="Next income:" + (((gross_income.text as String).toInt()) * (1- tax_rate)).toString()
        }
        else{
            net_income.text = ("Next income:" +gross_income.text).toString()
        }

    }
}
