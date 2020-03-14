package com.example.myandroidproject

import com.example.networkapp.R

class Util private constructor(val data: Int) {

    companion object {

        fun setTextColorForTemp(temp: Double?): Int {
            if (temp != null) {
                return when {
                    temp >= ZERO_GRADS && temp < PLUS_TEN_GRADS -> R.color.normal
                    temp >= PLUS_TEN_GRADS && temp < PLUS_TWENTY_GRADS -> R.color.mediumHot
                    temp >= PLUS_TWENTY_GRADS -> R.color.veryHot
                    temp < ZERO_GRADS && temp > MINUS_TEN_GRADS -> R.color.winter
                    temp <= MINUS_TEN_GRADS && temp > MINUS_TWENTY_GRADS -> R.color.mediumCold
                    temp <= MINUS_TWENTY_GRADS -> R.color.veryCold
                    else -> R.color.black
                }
            }
            return R.color.black
        }

        fun getWindType(degInt: Int?): String? {
            val deg = degInt?.toDouble()
            if (deg != null) {
                return when {
                    deg <= NORTH_WIND1 -> "С"
                    deg <= NORTHWEST_WIND1 -> "СЗ"
                    deg <= EAST_WIND -> "В"
                    deg <= SOUTHEAST_WIND -> "ЮВ"
                    deg <= SOUTH_WIND -> "Ю"
                    deg <= SOUTHWEST_WIND -> "ЮЗ"
                    deg <= WEST_WIND -> "З"
                    deg <= NORTHWEST_WIND2 -> "СЗ"
                    deg <= NORTH_WIND2 -> "С"
                    else -> "Нет данных"
                }
            }
            return "null"
        }

        private const val NORTH_WIND1: Double = 22.5
        private const val NORTHWEST_WIND1: Double = 67.5
        private const val EAST_WIND: Double = 112.5
        private const val SOUTHEAST_WIND: Double = 157.5
        private const val SOUTH_WIND: Double = 202.5
        private const val SOUTHWEST_WIND: Double = 247.5
        private const val WEST_WIND: Double = 292.5
        private const val NORTHWEST_WIND2: Double = 337.5
        private const val NORTH_WIND2: Double = 360.0

        private const val ZERO_GRADS: Double = 0.0
        private const val PLUS_TEN_GRADS: Double = 10.0
        private const val PLUS_TWENTY_GRADS: Double = 20.0
        private const val MINUS_TEN_GRADS: Double = -10.0
        private const val MINUS_TWENTY_GRADS: Double = -20.0
    }
}
