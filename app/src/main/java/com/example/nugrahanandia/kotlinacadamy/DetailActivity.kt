package com.example.nugrahanandia.kotlinacadamy

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.*

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        /*DetailActivityUI().setContentView(this)*/

        val intent = getIntent()

        if (intent.hasExtra("name") && intent.hasExtra("image") && intent.hasExtra("detail")) {
            var name = intent.getStringExtra("name")
            var image = intent.getIntExtra("image", 0)
            var detail = intent.getStringExtra("detail")

            tvName.text = name

            Glide.with(this)
                    .asBitmap()
                    .load(image)
                    .into(image1)

            description.text = detail
        }
    }

    /*class DetailActivityUI : AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            relativeLayout {
                imageView {
                    id = Ids.image1
                    setImageResource(R.drawable.img_madrid)
                }.lparams(width = dip(100), height = dip(100)) {
                    centerHorizontally()
                    topMargin = dip(20)
                }
                textView("Real Madrid CF") {
                    id = Ids.tvName
                    textSize = 20f
                }.lparams(width = wrapContent, height = wrapContent) {
                    below(Ids.image1)
                    centerHorizontally()
                    topMargin = dip(10)
                }
                textView("Real Madrid Club de Fútbol,Royal Madrid Football Club), commonly known as Real Madrid, is a professional football club based in Madrid, Spain.") {
                    id = Ids.description
                }.lparams(width = wrapContent, height = wrapContent) {
                    below(R.id.tvName)
                    centerHorizontally()
                    topMargin = dip(20)
                }
            }
        }

        private object Ids {
            val description = 1
            val image1 = 2
            val tvName = 3
        }
    }*/
}
