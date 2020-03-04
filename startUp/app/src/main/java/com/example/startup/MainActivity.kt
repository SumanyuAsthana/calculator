package com.example.startup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
    }
    var isNewOperation=true
    fun buNumberEvent(view: View) {
       if(isNewOperation)
        {
            screenMaterial.setText("")
        }
        isNewOperation=false
        var buttonSelected=view as Button
        var screenMaterialText:String=screenMaterial.text.toString()
/*var buClickValue:String="0"
        buClickValue*/
        when(buttonSelected.id){
            bu0.id->screenMaterialText+="0"
            bu1.id->screenMaterialText+="1"
            bu2.id->screenMaterialText+="2"
            bu3.id->screenMaterialText+="3"
            bu4.id->screenMaterialText+="4"
            bu5.id->screenMaterialText+="5"
            bu6.id->screenMaterialText+="6"
            bu7.id->screenMaterialText+="7"
            bu8.id->screenMaterialText+="8"
            bu9.id->screenMaterialText+="9"
            buDot.id->screenMaterialText+="."/*here prevent from adding more dots*/
            buPlusMinus.id->screenMaterialText="-$screenMaterialText"

            else->{""}
        }

        screenMaterial.setText(screenMaterialText)


    }
    var operation="+"
    var oldNumber=""

    fun buOperationEvent(view: View) {
        var buttonSelected=view as Button
        when(buttonSelected.id)
        {
            buMultiply.id->
            {
                operation="*"
            }
            buPlus.id->
            {
                operation="+"
            }
            buMinus.id->
            {
                operation="-"
            }
            buDivide.id->
            {
                operation="/"
            }
            buPercentage.id->{
                operation="%"
            }
        }
        oldNumber=screenMaterial.text.toString()

        isNewOperation=true
    }

    fun buEqualsEvent(view: View) {
        var newNumber=screenMaterial.text.toString()
        var finalAnswer:Double=0.0
        when(operation){
            "%"->{
                finalAnswer=100*(oldNumber.toDouble()/newNumber.toDouble())
            }
            "*"->{
            finalAnswer=newNumber.toDouble()*oldNumber.toDouble()
            }
            "/"->{
                finalAnswer=oldNumber.toDouble()/newNumber.toDouble()
            }
            "-"->{
finalAnswer=oldNumber.toDouble()-newNumber.toDouble()
            }
            "+"->{
finalAnswer=oldNumber.toDouble()+newNumber.toDouble()
            }
        }
        screenMaterial.setText(finalAnswer.toString())
        isNewOperation=true
    }

    fun buClearAll(view: View) {
        screenMaterial.setText("0")
        isNewOperation=true
    }
}