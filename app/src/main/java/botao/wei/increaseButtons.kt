package botao.wei

import android.widget.Button

class increaseButton(b: Button){
    val button: Button

    init {
        button = b
    }

    fun setupListen(change: () -> Unit, update: () -> Unit){
        this.button.setOnClickListener{
            change
            update
        }
    }

}