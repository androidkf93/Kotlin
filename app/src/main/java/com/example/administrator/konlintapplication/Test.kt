package com.example.konlitapp

class Test (name: String, surName: String){
    val n = name
    val sur = surName;
    init{
        System.out.print("name= " + n + "surName" + sur)
    }

    fun print(){
        System.out.print("name= \n" + n + "surName" + sur)
    }
}