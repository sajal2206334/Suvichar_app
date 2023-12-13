package com.example.suvichar.data

import com.example.suvichar.R
import com.example.suvichar.model.Suvichar

class Datasource() {
    fun loadAffirmations(): List<Suvichar> {
        return listOf<Suvichar>(
            Suvichar(R.string.affirmation1, R.drawable.image1),
            Suvichar(R.string.affirmation2, R.drawable.image2),
            Suvichar(R.string.affirmation3, R.drawable.image3),
            Suvichar(R.string.affirmation4, R.drawable.image4),
            Suvichar(R.string.affirmation5, R.drawable.image5),
            Suvichar(R.string.affirmation6, R.drawable.image6),
            Suvichar(R.string.affirmation7, R.drawable.image7),
            Suvichar(R.string.affirmation8, R.drawable.image8),
            Suvichar(R.string.affirmation9, R.drawable.image9),
            Suvichar(R.string.affirmation10, R.drawable.image10))
    }
}