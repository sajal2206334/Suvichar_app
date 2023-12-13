package com.example.suvichar.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Suvichar(
   @StringRes val stringResourceId : Int,
   @DrawableRes val imageResourceId : Int
)
