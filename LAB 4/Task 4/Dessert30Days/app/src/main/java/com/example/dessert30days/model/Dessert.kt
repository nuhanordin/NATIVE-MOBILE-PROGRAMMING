package com.example.dessert30days.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Dessert(
    @StringRes val stringResourceId: Int,
    @StringRes val stringResourceId1: Int,
    @DrawableRes val imageResourceId: Int
)