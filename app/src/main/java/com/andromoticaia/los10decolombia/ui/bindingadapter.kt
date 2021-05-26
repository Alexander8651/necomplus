package com.andromoticaia.los10decolombia.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

//Obtiene la imagen y las visualiza en el imageview
@BindingAdapter("getImage")
fun bindImage(imageView: ImageView, image:String?){
    Glide.with(imageView.context).load(image).into(imageView)
}