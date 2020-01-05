package com.tikslab.bonchcab.model.pojo

enum class DayOfWeek {
    MONDAY {
        override fun toString(): String {
            return "Понедельник"
        }
    },
    TUESDAY {
        override fun toString(): String {
            return "Вторник"
        }
    },
    WEDNESDAY {
        override fun toString(): String {
            return "Среда"
        }
    },
    THURSDAY {
        override fun toString(): String {
            return "Четверг"
        }
    },
    FRIDAY {
        override fun toString(): String {
            return "Пятница"
        }
    },
    SATURDAY {
        override fun toString(): String {
            return "Суббота"
        }
    },
    SUNDAY {
        override fun toString(): String {
            return "Воскресенье"
        }
    };




}