package am.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), View.OnClickListener{
    var selectPlayer = R.drawable.o
    var player2 = R.drawable.x
    val arrayXO = Array(9) {i -> ' '}
    var num = -1
    var count = 0
    var bool = false
    val listIndex = mutableListOf(0,1,2,3,4,5,6,7,8)
     lateinit var image :ImageView
     lateinit var image2 :ImageView
     lateinit var image3 :ImageView
     lateinit var image4 :ImageView
     lateinit var image5 :ImageView
     lateinit var image6 :ImageView
     lateinit var image7 :ImageView
     lateinit var image8 :ImageView
     lateinit var image9 :ImageView

     lateinit var  arrImage: Array<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.imageView)
        image2 = findViewById(R.id.imageView2)
        image3 = findViewById(R.id.imageView3)
        image4 = findViewById(R.id.imageView4)
        image5 = findViewById(R.id.imageView5)
        image6 = findViewById(R.id.imageView6)
        image7 = findViewById(R.id.imageView7)
        image8 = findViewById(R.id.imageView8)
        image9 = findViewById(R.id.imageView9)
        arrImage = arrayOf(image,image2,image3,image4,image5,image6,image7,image8,image9)
        var a = image.setOnClickListener(this)
        println(a)
        image2.setOnClickListener(this)
        image3.setOnClickListener(this)
        image4.setOnClickListener(this)
        image5.setOnClickListener(this)
        image6.setOnClickListener(this)
        image7.setOnClickListener(this)
        image8.setOnClickListener(this)
        image9.setOnClickListener(this)

        val restart = findViewById<Button>(R.id.restart)
        val select_o = findViewById<ImageButton>(R.id.select_o)
        val select_x = findViewById<ImageButton>(R.id.select_x)

        select_x.setOnClickListener(View.OnClickListener {
            selectPlayer = R.drawable.x; player2 = R.drawable.o
        })

        select_o.setOnClickListener(View.OnClickListener {
            selectPlayer = R.drawable.o; player2 = R.drawable.x
        })


        restart.setOnClickListener(View.OnClickListener {
            listIndex.clear()
            for (i in 0..8) {
                arrImage[i].setImageResource(0)
                arrayXO[i] = ' '
                listIndex.add(i)
            }
            num = -1
            count = 0
            bool = false
        })
       println(arrayXO.size)
       println(arrImage.size)

    }

    override fun onClick(v: View?) {
        if (v != null) {

            when{
                v.getId() == R.id.imageView  && arrayXO[0] == ' ' -> { num = 0; xo()}
                v.getId() == R.id.imageView2 && arrayXO[1] == ' ' -> { num = 1; xo()}
                v.getId() == R.id.imageView3 && arrayXO[2] == ' ' -> { num = 2; xo()}
                v.getId() == R.id.imageView4 && arrayXO[3] == ' ' -> { num = 3; xo()}
                v.getId() == R.id.imageView5 && arrayXO[4] == ' ' -> { num = 4; xo()}
                v.getId() == R.id.imageView6 && arrayXO[5] == ' ' -> { num = 5; xo()}
                v.getId() == R.id.imageView7 && arrayXO[6] == ' ' -> { num = 6; xo()}
                v.getId() == R.id.imageView8 && arrayXO[7] == ' ' -> { num = 7; xo()}
                v.getId() == R.id.imageView9 && arrayXO[8] == ' ' -> { num = 8; xo()}

            }
        }
    }

    fun xo(){
        if (num != -1){

            arrImage[num].setImageResource(selectPlayer)
            listIndex.remove(num)
            arrayXO[num] = if (selectPlayer == R.drawable.x) 'x' else 'o'

                    count++
                println("count = $count")


                    for (i in 0..arrayXO.size-1){
                        if (arrayXO[0] == arrayXO[num]  && arrayXO[0] == arrayXO[4] && arrayXO[0] == arrayXO[8]){
                            Toast.makeText(this,"${arrayXO[num].toUpperCase()}  WINNER!",Toast.LENGTH_SHORT).show()
                            bool = true
                            break
                        }
                        if (arrayXO[2] == arrayXO[num] &&  arrayXO[2] == arrayXO[4] && arrayXO[2] == arrayXO[6]){
                            Toast.makeText(this,"${arrayXO[num].toUpperCase()}  WINNER!",Toast.LENGTH_SHORT).show()
                            bool = true
                            break
                        }
                        if (i + 6 < 9 && arrayXO[i] == arrayXO[num]  && arrayXO[i] == arrayXO[i+3] && arrayXO[i] == arrayXO[i+6]){
                            Toast.makeText(this,"${arrayXO[num].toUpperCase()}  WINNER!",Toast.LENGTH_SHORT).show()
                            bool = true
                            break
                        }
                        if (i + 2 < 9 && i%3 == 0 && arrayXO[i] == arrayXO[num]  &&  arrayXO[i] == arrayXO[i+1] && arrayXO[i] == arrayXO[i+2]){
                            Toast.makeText(this,"${arrayXO[num].toUpperCase()}  WINNER!",Toast.LENGTH_SHORT).show()
                            bool = true
                            break
                        }
                    }
                println(bool)


         if (listIndex.isNotEmpty()) {
           var randIndex = listIndex.random()
           if (bool == false){
                arrImage[randIndex].setImageResource(player2)
               listIndex.remove(randIndex)
               print(randIndex)
                arrayXO[randIndex] = if (player2 == R.drawable.x) 'x' else 'o'
                for (i in 0..arrayXO.size-1){
                    if (arrayXO[0] == arrayXO[randIndex]  && arrayXO[0] == arrayXO[4] && arrayXO[0] == arrayXO[8]){
                        Toast.makeText(this,"${arrayXO[randIndex].toUpperCase()}  WINNER!",Toast.LENGTH_SHORT).show()
                        bool = true
                        break
                    }
                    if (arrayXO[2] == arrayXO[randIndex]  &&  arrayXO[2] == arrayXO[4] && arrayXO[2] == arrayXO[6]){
                        Toast.makeText(this,"${arrayXO[randIndex].toUpperCase()}  WINNER!",Toast.LENGTH_SHORT).show()
                        bool = true
                        break
                    }
                    if (i + 6 < 9 && arrayXO[i] == arrayXO[randIndex]  && arrayXO[i] == arrayXO[i+3] && arrayXO[i] == arrayXO[i+6]){
                        Toast.makeText(this,"${arrayXO[randIndex].toUpperCase()}  WINNER!",Toast.LENGTH_SHORT).show()
                        bool = true
                        break
                    }
                    if (i + 2 < 9 && i%3 == 0 && arrayXO[i] == arrayXO[randIndex]  &&  arrayXO[i] == arrayXO[i+1] && arrayXO[i] == arrayXO[i+2]){
                        Toast.makeText(this,"${arrayXO[randIndex].toUpperCase()}  WINNER!",Toast.LENGTH_SHORT).show()
                        bool = true
                        break
                    }
                }}


            }
            if (count == 5 && bool == false) Toast.makeText(this,  "The game ended in a draw․",Toast.LENGTH_SHORT).show()
            if (bool == true){
                for (i in 0..8)
                    if (arrayXO[i] == ' ')
                        arrayXO[i] = '0'
                Toast.makeText(this,"Click restart ",Toast.LENGTH_SHORT).show()
            }
        }
    }
}