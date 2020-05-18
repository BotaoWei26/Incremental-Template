package botao.wei

import kotlin.math.ceil
import kotlin.math.floor

class Game{
    private var time: Int = 0
    private var timeClick: Int = 1
    private var clickCost: Int = 5
    private var timeTick: Int = 0
    private var tickCost: Int = 20
    private var speed: Long = 1000
    private var speedCost: Int = 50


    fun tick(){
        this.time += this.timeTick
    }

    fun click(){
        this.time += this.timeClick
    }

    fun increaseClick(){
        if (this.time >= this.clickCost) {
            ++timeClick
            timeClick = floor((timeClick * 1.1)).toInt()
            this.time -= this.clickCost
            this.clickCost = floor(this.clickCost.toFloat() * 1.2).toInt()
        }
    }

    fun increaseTick(){
        if (this.time >= this.tickCost) {
            ++timeTick
            timeTick = floor((timeTick * 1.5)).toInt()
            this.time -= this.tickCost
            this.tickCost = floor(this.tickCost.toFloat() * 1.5).toInt()
        }
    }

    fun increaseSpeed(){
        if (this.time >= this.speedCost) {
            speed = floor(speed.toFloat() * 0.9).toLong()
            this.time -= this.speedCost
            this.speedCost = floor(this.speedCost.toFloat() * 2.5).toInt()
        }
    }

    fun getTime(): Int{
        return this.time
    }

    fun getClick(): Int{
        return this.timeClick
    }

    fun getTick(): Int{
        return this.timeTick
    }

    fun getSpeed(): Long{
        return this.speed
    }

    fun getClickCost(): Int{
        return this.clickCost
    }

    fun getTickCost(): Int{
        return this.tickCost
    }

    fun getSpeedCost(): Int{
        return this.speedCost
    }

}
