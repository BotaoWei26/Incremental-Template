package botao.wei

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val game = Game()

        // button init
        val timeTextView = findViewById<TextView>(R.id.timeTextView)
        val clickTextView = findViewById<TextView>(R.id.clickTextView)
        val tickTextView = findViewById<TextView>(R.id.tickTextView)
        val speedTextView = findViewById<TextView>(R.id.speedTextView)

        val addClickButton = findViewById<Button>(R.id.addClickButton)
        val addTickButton = findViewById<Button>(R.id.addTickButton)
        val addSpeedButton = findViewById<Button>(R.id.addSpeedButton)

        val clockImageButton = findViewById<ImageButton>(R.id.clockImageButton)
        fun updateText(){
            timeTextView.text = (getString(R.string.time) + game.getTime().toString())
            clickTextView.text = (getString(R.string.click) + game.getClick().toString())
            tickTextView.text = (getString(R.string.tick) + game.getTick().toString())
            speedTextView.text = (getString(R.string.speed) + game.getSpeed().toString())
            addClickButton.text = (getString(R.string.add_click) + game.getClickCost().toString())
            addClickButton.isEnabled = (game.getTime() >= game.getClickCost())
            addTickButton.text = (getString(R.string.add_tick) + game.getTickCost().toString())
            addTickButton.isEnabled = (game.getTime() >= game.getTickCost())
            addSpeedButton.text = (getString(R.string.add_speed) + game.getSpeedCost().toString())
            addSpeedButton.isEnabled = (game.getTime() >= game.getSpeedCost())
        }
        updateText()

        addClickButton.setOnClickListener{
            game.increaseClick()
            updateText()
        }

        addTickButton.setOnClickListener{
            game.increaseTick()
            updateText()
        }

        addSpeedButton.setOnClickListener{
            game.increaseSpeed()
            updateText()
        }

        clockImageButton.setOnClickListener{
            game.click()
            updateText()
        }

        // TICK UP
        val handler = Handler()
        lateinit var tick: Runnable
        tick = Runnable {
            game.tick()
            updateText()
            handler.postDelayed(tick, game.getSpeed())
        }
        handler.postDelayed(tick, game.getSpeed())

    }

}
