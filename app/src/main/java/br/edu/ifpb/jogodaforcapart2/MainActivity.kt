package br.edu.ifpb.jogodaforcapart2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import br.edu.ifpb.jogodaforcapart2.fachada.Fachada

class MainActivity : AppCompatActivity() {
    private lateinit var control: Fachada
    private lateinit var dica:    TextView
    private lateinit var palavra: TextView
    private lateinit var status:  TextView
    private lateinit var input:   EditText
    private lateinit var button:  Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // MONTAR O JOGO
        this.control = Fachada()
        this.control.registroPadrao()
        this.control.iniciar()

        // SELECT ELEMENTO PELO ID
        this.dica    = findViewById(R.id.txtView_Dica)
        this.palavra = findViewById(R.id.txtView_Palavra)
        this.status  = findViewById(R.id.txtView_Status)
        this.button  = findViewById(R.id.button_Arriscar)
        this.input   = findViewById(R.id.editTxt_Letra)

        // MOSTRAR NA TELA O INIT DA FORCA
        this.dica.text    = this.control.dica()
        this.palavra.text = this.control.palavra()
        this.status.text  = this.control.status()

        this.button.setOnClickListener(clickButton1())
    }

    inner class clickButton1: View.OnClickListener {
        override fun onClick(p0: View?) {
            if (this@MainActivity.control.terminou()) {
                this@MainActivity.button.isEnabled = false
            }
            else {
                val letra = this@MainActivity.input.text.toString()
                this@MainActivity.control.jogar(letra)

//                ATT ESTADO DA PALAVRA E ATT STATUS
                this@MainActivity.palavra.text = this@MainActivity.control.palavra()
                this@MainActivity.status.text  = this@MainActivity.control.status()
            }
        }
    }
}