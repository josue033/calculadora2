package saavedra.salazar.calculadora2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

/*
* Lo que hacemos es implementar la interfaz
* OnclickListener de la clase View, para poder "escuchar los clicks"
* en ciertos elementos
* */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    /*
    * La variable operación nos servirá para establecer qué operación se realizará entre los
    * operandos*/
    var operacion = ""
    /*
    * Esta variable nos servirá para saber si existe una operación pendiente o no,
    * lo cual nos ayuda a determinar si estamos ante el operando 1 o el operando 2
    * */
    var operacionPendiente = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //llamada al método initUI
        initUI()
    }



    /*
    * El método nos sirve para inicializar nuestros listeners,
    * es completamente opcional
    * */
    private fun initUI(){
        /*
        * Asignamos los listeners a los botones*/
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btnMas.setOnClickListener(this)
        btnMen.setOnClickListener(this)
        btnPor.setOnClickListener(this)
        btnIgual.setOnClickListener(this)
        btnDiv.setOnClickListener(this)
        btnBorrar.setOnClickListener(this)
        btnPunto.setOnClickListener(this)
    }

    /*
    * La interfaz onclick sí necesita estar implementada debido al gran número de
    * botones con los que cuenta específicamente esta app
    * */

    override fun onClick(p0: View?) {
        /*La estructura de control when es el equivalente al switch*/
        when(p0!!.id){//utilizamos el id del elemento al que se le haya dado click, el cual, recibimos como argumento en el método


            R.id.btn1->{ // con funciones de flecha damos funcionalidad a cada botón
                if(operacionPendiente){
                    etOperando2.text.append("1")
                }else{
                    etOperando1.text.append("1")
                }

            }
            R.id.btn2->{
                if(operacionPendiente){
                    etOperando2.text.append("2")
                }else{
                    etOperando1.text.append("2")
                }
            }
            R.id.btn3->{
                if(operacionPendiente){
                    etOperando2.text.append("3")
                }else{
                    etOperando1.text.append("3")
                }
            }
            R.id.btn4->{
                if(operacionPendiente){
                    etOperando2.text.append("4")
                }else{
                    etOperando1.text.append("4")
                }
            }
            R.id.btn5->{
                if(operacionPendiente){
                    etOperando2.text.append("5")
                }else{
                    etOperando1.text.append("5")
                }
            }
            R.id.btn6->{
                if(operacionPendiente){
                    etOperando2.text.append("6")
                }else{
                    etOperando1.text.append("6")
                }
            }
            R.id.btn7->{
                if(operacionPendiente){
                    etOperando2.text.append("7")
                }else{
                    etOperando1.text.append("7")
                }
            }
            R.id.btn8->{
                if(operacionPendiente){
                    etOperando2.text.append("8")
                }else{
                    etOperando1.text.append("8")
                }
            }
            R.id.btn9->{
                if(operacionPendiente){
                    etOperando2.text.append("9")
                }else{
                    etOperando1.text.append("9")
                }
            }
            R.id.btnPunto->{
                if (operacionPendiente){
                    etOperando2.text.append(".")
                }else{
                    etOperando1.text.append(".")
                }
            }
            /*
            * Cuando es un botón de operador, cambiamos la operación y establecemos el hecho
            * de que existe una operación pendiente
            * */
            R.id.btnMas-> {
                tvoperacion.setText("+")
                operacion = "+"
                operacionPendiente = true
                if(etOperando1.text.isEmpty()){
                    etOperando1.text.append("0")
                }

            }
            R.id.btnMen-> {
                tvoperacion.setText("-")
                operacion = "-"
                operacionPendiente = true
                if (etOperando1.text.isEmpty()){
                    etOperando1.text.append("0")
                }
            }
            R.id.btnPor->{
                tvoperacion.setText("*")
                operacion = "*"
                operacionPendiente = true
                if (etOperando1.text.isEmpty()){
                    etOperando1.text.append("0")
                }
            }
            R.id.btnDiv->{
                tvoperacion.setText("/")
                operacion = "/"
                operacionPendiente = true
                if (etOperando1.text.isEmpty()){
                    etOperando1.text.append("0")
                }
            }
            /*Cuando el botón que se presiona es el igual =
            * Realizamos otro when basándonos en la operación seleccionada y realizamos la operación
            * */
            R.id.btnIgual->{
                var operando1: Float
                var operando2: Float
                if(etOperando1.text.isNotEmpty() and etOperando2.text.isNotEmpty()){
                    operando1 = etOperando1.text.toString().toFloat()
                    operando2 = etOperando2.text.toString().toFloat()
                }else{
                    operando1 = 0f
                    operando2 = 0f
                }

                var resultado = 0f
                when(operacion){
                    "+"-> resultado = operando1+operando2
                    "-"-> resultado = operando1-operando2
                    "*"-> resultado = operando1*operando2
                    "/"-> resultado = operando1/operando2
                }

                operacionPendiente = false //quitamos la bandera y reestablecemos los editText
                etOperando1.text.clear()
                etOperando2.text.clear()
                tvresultado.setText("$resultado")//mostramos el resultado
            }

            /*
            * Método de borrar pantalla, debería dejar todo en su estado normal*/
            R.id.btnBorrar->{
                etOperando1.text.clear()
                etOperando2.text.clear()
                tvresultado.setText("resultado")
                tvoperacion.setText("operación")
            }


        }


    }
}
