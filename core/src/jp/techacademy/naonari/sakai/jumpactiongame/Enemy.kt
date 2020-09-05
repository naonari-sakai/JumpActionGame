package jp.techacademy.naonari.sakai.jumpactiongame

import com.badlogic.gdx.graphics.Texture

class Enemy(texture: Texture, srcX: Int, srcY: Int, srcWidth: Int, srcHeight: Int)
    : GameObject(texture, srcX, srcY, srcWidth, srcHeight) {

    companion object{
        val ENEMY_WIDTH = 1.0f
        val ENEMY_HEIGHT = 1.4f

        val ENEMY_VELOCITY = 3.0f
        val ENEMY_VELOCITY_Y = 15.0f
    }

    init {
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT)
        velocity.x = ENEMY_VELOCITY
        velocity.y = ENEMY_VELOCITY

    }

    //座標を更新する
    fun update(deltaTime: Float){
        x += velocity.x * deltaTime
        y += velocity.y * deltaTime


        if (x < Enemy.ENEMY_WIDTH / 2 ){
            velocity.x = -velocity.x
            x = Enemy.ENEMY_WIDTH
        }

        if (y < Enemy.ENEMY_HEIGHT / 2 ){
            velocity.y = -velocity.y
        }

        if (y > GameScreen.WORLD_HEIGHT - ENEMY_HEIGHT /2){
            velocity.y = -velocity.y
        }

        if (x > GameScreen.WORLD_WIDTH - ENEMY_WIDTH /2){
            velocity.x = -velocity.x
            x = GameScreen.WORLD_WIDTH - ENEMY_WIDTH /2
        }

    }


}