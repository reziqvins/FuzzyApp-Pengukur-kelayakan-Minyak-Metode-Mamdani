package BelajarKotlin

fun main(){
    val visko = 990.0
    val densi  = 517.68

    // FUZZYFICATION

    // Start TB
    var result_visko:Array<Double> = arrayOf()
    var DK_visko :Array<String> = arrayOf()

    fun rumus_pertama(x: Double,c :Double, d : Double):Double{
        val hitung = (-(x - d ))/(d - c)
        return hitung
    }
    fun rumus_kedua(x: Double,a :Double, b : Double):Double{
        val hitung = (x-a)/(b-a)
        return hitung
    }

    when{
        visko < 0.0 -> {
            result_visko+= 0.0
        }
        visko in 0.0..900.0 -> {
            DK_visko +="Buruk"
            result_visko+= 1.0
        }
        visko in 901.0..924.9 ->{
            val a = 900.0
            val b = 925.0
            DK_visko  += "Buruk"
            DK_visko  += "Cukup"
            result_visko  += rumus_pertama(visko ,a,b)
            result_visko  += rumus_kedua(visko ,a,b)

        }
        visko in 925.0..949.9-> {
            DK_visko  +="Cukup"
            result_visko += 1.0;
        }
        visko in 950.0..984.9-> {
            val a = 950.0
            val b = 985.0
            DK_visko += "Cukup"
            DK_visko += "Baik"
            result_visko += rumus_pertama(visko ,a,b)
            result_visko += rumus_kedua(visko ,a,b)
        };
        visko in 985.0..1019.9 -> {
            DK_visko  +="Baik"
            result_visko += 1.0;
        }
        visko  > 1020.0 -> {
            result_visko  += 0.0
        }
        visko  > 1500.0 -> {
            println("Data Tidak Valid")
        }
    }

    // Finish TB

    //Start BB
    var result_densi :Array<Double> = arrayOf()
    var DK_densi :Array<String> = arrayOf()


    when{
        densi < 0.0 -> result_densi+= 0.0 ;
        densi in 0.0..500.0 -> {
            DK_densi +="Bagus"
            result_densi += 1.0
        }
        densi in 501.0..541.9 ->{
            val a = 500.0
            val b = 542.0
            DK_densi += "Bagus"
            DK_densi += "Sedang"
            result_densi += rumus_pertama(densi,a,b)
            result_densi += rumus_kedua(densi,a,b)

        }
        densi in 542.0..631.9 -> {
            DK_densi +="Sedang"
            result_densi += 1.0;
        }
        densi in 632.0..718.9 -> {
            val a = 631.0
            val b = 719.0
            DK_densi += "Sedang"
            DK_densi += "Jelek"
            result_densi += rumus_pertama(densi,a,b)
            result_densi += rumus_kedua(densi,a,b)
        };
        densi in 719.0..799.9 -> {
            DK_densi +="Jelek"
            result_densi += 1.0;
        }
        densi > 800.0 -> {
            result_densi += 0.0
        }
        densi > 1000.0 -> {
            println("Data Tidak Valid")
        };
    }

    println(result_visko.toList())
    println(DK_visko.toList())
    println(result_densi.toList())
    println(DK_densi.toList())



    println("------------------------------")

    // INFERENCE
    var number_inference : Array<Double> = arrayOf()
    var DK_inference : Array<String> = arrayOf()
    var key : Int = 0
    var success : Boolean = false
    //Conjungsion
    if(visko < 0.0 || densi < 0.0){
        println("Data Tidak Valid 1")
    }else{
        if(visko >= 1500.0 || densi >= 1000.0){
            println("Data Tidak Valid 2")
        }else{
            if(DK_visko.isNotEmpty() && DK_densi.isNotEmpty()){
                for(i in result_visko){
                    for(j in result_densi){
                        if(i <= j ){
                            number_inference += i
                        }else{
                            number_inference += j
                        }
                    }
                }
                success = true
            }else{
                println("Data Tidak Valid 3")
            }
        }
    }
    println(number_inference.toList())

    for(i in DK_visko){
        for(j in DK_densi){
            if(i == "Buruk" && j == "Jelek"){
                DK_inference += "uruk"
            } else if(i == "Buruk" && j == "Sedang"){
                DK_inference += "Buruk"
            }else if(i == "Buruk" && j == "Bagus"){
                DK_inference += "Buruk"
            }else if(i == "Cukup" && j == "Jelek"){
                DK_inference += "Buruk"
            }else if(i == "Cukup" && j == "Sedang"){
                DK_inference += "Sedang"
            }else if(i == "Cukup" && j == "Bagus"){
                DK_inference += "Sedang"
            }else if(i == "Baik"  && j == "Jelek"){
                DK_inference += "Buruk"
            }else if(i == "Baik" && j == "Sedang"){
                DK_inference += "Sedang"
            }else if(i == "Baik" && j == "Bagus"){
                DK_inference += "Baik"
            }else{
                println("Data tidak tersedia")
            }
        }
    }

    println(DK_inference.toList())

//    Pengecekan Apakah masuk disjunction atau tidak
    var number_disjuction : Array<Double> = arrayOf()
    var DK_disjuction : Array<String> = arrayOf()



    fun disjunction(arr : Array<String>){
        var tempo : Array<Int> = arrayOf()
        var tempo2 : Array<Int> = arrayOf()
        var tempo3 : Array<Double> = arrayOf()
        var tempo4 : Array<Int> = arrayOf()
        var tempo5 : Array<Int> = arrayOf()

        // Mengecek nama yang sama pada array, jika ada dikelompokkan dan masukkan index tsb ke dalam array baru
        for(i in DK_inference.indices){
            if(DK_inference[0] == DK_inference[i]){
                tempo += i
            }else{
                tempo2 += i
            }
        }

        for(j in tempo2){
            val a = tempo2[0]
            if(DK_inference[a] == DK_inference[j]){
                tempo4 += j
            }else{
                tempo5 += j
            }
        }


        println(tempo.toList())
        println(tempo2.toList())

        var result : Array<Double> = arrayOf()
        var result2 : Array<Double> = arrayOf()
        // Pengecekan Index, ambil index dgn nilai terbesar masukkan ke dalam variabel tempo3
        if(tempo5.isNotEmpty()){
            println(tempo.toList())
            println(tempo4.toList())
            println(tempo5.toList())
            // Clear
            if(tempo.size == 2){
                // Ambil Nilai string dari index terbesar
                if(tempo[0] > tempo[1]){
                    val a = tempo[0]
                    DK_disjuction += DK_inference[a]
                }else{
                    val a = tempo[1]
                    DK_disjuction += DK_inference[a]
                }


                // Ambil nilai integer dari index terbesar
                for(i in tempo4){
                    result += number_inference[i]
                }
                tempo3 += result.toList().sortedDescending().first()

                for(i in tempo4){
                    tempo3 += number_inference[i]
                    DK_disjuction += DK_inference[i]
                }
                for(i in tempo5){
                    tempo3 += number_inference[i]
                    DK_disjuction += DK_inference[i]
                }


            }else if(tempo4.size == 2){
                if(tempo4[0] > tempo4[1]){
                    val a = tempo4[0]
                    DK_disjuction += DK_inference[a]
                }else{
                    val a = tempo4[1]
                    DK_disjuction += DK_inference[a]
                }
                for(i in tempo4){
                    result += number_inference[i]
                }
                tempo3 += result.toList().sortedDescending().first()
                for(i in tempo){
                    tempo3 += number_inference[i]
                    DK_disjuction += DK_inference[i]
                }
                for(i in tempo5){
                    tempo3 += number_inference[i]
                    DK_disjuction += DK_inference[i]
                }

            }else if(tempo5.size == 2){
                if(tempo5[0] > tempo5[1]){
                    val a = tempo5[0]
                    DK_disjuction += DK_inference[a]
                }else{
                    val a = tempo5[1]
                    DK_disjuction += DK_inference[a]
                }
                for(i in tempo5){
                    result += number_inference[i]
                }
                tempo3 += result.toList().sortedDescending().first()
                for(i in tempo){
                    tempo3 += number_inference[i]
                    DK_disjuction += DK_inference[i]
                }
                for(i in tempo4){
                    tempo3 += number_inference[i]
                    DK_disjuction += DK_inference[i]
                }

            }else{
                println("error")
            }


        }else if(tempo.size == 2 && tempo2.size == 2){
            for(i in tempo){
                result += number_inference[i]
            }
            tempo3 += result.toList().sortedDescending().first()
            result = arrayOf()

            if(tempo[0] > tempo[1]){
                val a = tempo[0]
                DK_disjuction += DK_inference[a]
            }else{
                val a = tempo[0]
                DK_disjuction += DK_inference[a]
            }

            if(tempo2[0] > tempo2[1]){
                val a = tempo2[0]
                DK_disjuction += DK_inference[a]
            }else{
                val a = tempo2[0]
                DK_disjuction += DK_inference[a]
            }

//            for(i in tempo3){
//                DK_disjuction += DK_inference[i.toInt()]
//            }

            for(i in tempo2){
                result += number_inference[i]
            }

            result2 += result.toList().sortedDescending().first()

            for(i in result2){
//                DK_disjuction += DK_inference[i.toInt()]
                tempo3 += i
            }

        }else if(tempo.size == 3 && tempo2.size == 1){
            for(i in tempo){
                result += number_inference[i]
            }
            tempo3 += result.toList().sortedDescending().first()

            // Ambil nilai string dari tempo3
            for(i in tempo3){
                DK_disjuction += DK_inference[i.toInt()]
            }

            for(i in tempo2){
                DK_disjuction += DK_inference[i]
                tempo3 += number_inference[i]

            }

        }else if(tempo.size == 1 && tempo2.size == 3){
            for(i in tempo2){
                result += number_inference[i]

            }
            tempo3 += result.toList().sortedDescending().first()

            // Ambil nilai string dari tempo3
            for(i in tempo3){
                DK_disjuction += DK_inference[i.toInt()]
            }

            for(i in tempo){
                DK_disjuction += DK_inference[i]
                tempo3 += number_inference[i]

            }
        }else{
            println("Ups Ada data yang tidak terduga")
        }



        number_disjuction += tempo3

        println(number_disjuction.toList())
        println(DK_disjuction.toList())
    }

    // Pengecekan Apakah Hasilnya nanti 1 dan 1
    var cek = 0

    if(DK_inference.size > 2){
        for(i in DK_inference.indices){
            for(j in 1..DK_inference.size-1){
                // Pengecekan apakah ada nama yang sama pada suatu array
                if(DK_inference[0] == DK_inference[j]){
                    key = 1
                }
            }
        }
    }else if(DK_inference.size == 2){
        if(DK_inference[0] == DK_inference[1]){
            cek = 1
        }
    }else{
        println("Lempar Defuzzi karena key = 0")
    }


    // Jika ada nama yang sama menjalankan disjunction
    if(key == 1){
        disjunction(DK_inference)
    }else if(cek == 1){
        DK_disjuction += DK_inference[0]
        if(number_inference[0] > number_inference[1]){
            number_disjuction += number_inference[0]
        }else{
            number_disjuction += number_inference[1]
        }
    }
    else{
        for(i in number_inference){
            number_disjuction += i
        }
        for(i in DK_inference){
            DK_disjuction += i
        }
    }

    println(DK_disjuction.toList())
    println(number_disjuction.toList())


    println()


    //DEFUZZYFICATION
    val range_Bagus = Array<Int>(5){it*11}
    val range_Sedang = Array<Int>(5){it*5+55}
    val range_Buruk = Array<Int>(5){it*5+75}
    var final_result = 0.0
    var string_result = ""



    fun rumus_defuzzi() {

        if (DK_disjuction.size == 3) {
            if (DK_disjuction[0] == "Bagus" && DK_disjuction[1] == "Sedang" && DK_disjuction[2] == "Buruk") {
                final_result =
                        ((range_Bagus.sum() * number_disjuction[0]) + (range_Sedang.sum() * number_disjuction[1]) + (range_Buruk.sum() * number_disjuction[2])) / ((number_disjuction[0] * 5) + (number_disjuction[1] * 5) + (number_disjuction[2] * 5))
            } else if (DK_disjuction[0] == "Bagus" && DK_disjuction[1] == "Buruk" && DK_disjuction[2] == "Sedang") {
                final_result =
                        ((range_Bagus.sum() * number_disjuction[0]) + (range_Buruk.sum() * number_disjuction[1]) + (range_Sedang.sum() * number_disjuction[2])) / ((number_disjuction[0] * 5) + (number_disjuction[1] * 5) + (number_disjuction[2] * 5))
            } else if (DK_disjuction[0] == "Buruk" && DK_disjuction[1] == "Sedang" && DK_disjuction[2] == "Bagus") {
                final_result =
                        ((range_Buruk.sum() * number_disjuction[0]) + (range_Sedang.sum() * number_disjuction[1]) + (range_Bagus.sum() * number_disjuction[2])) / ((number_disjuction[0] * 5) + (number_disjuction[1] * 5) + (number_disjuction[2] * 5))
            } else if (DK_disjuction[0] == "Buruk" && DK_disjuction[1] == "Bagus" && DK_disjuction[2] == "Sedang") {
                final_result =
                        ((range_Buruk.sum() * number_disjuction[0]) + (range_Bagus.sum() * number_disjuction[1]) + (range_Sedang.sum() * number_disjuction[2])) / ((number_disjuction[0] * 5) + (number_disjuction[1] * 5) + (number_disjuction[2] * 5))
            } else if (DK_disjuction[0] == "Sedang" && DK_disjuction[1] == "Bagus" && DK_disjuction[2] == "Buruk") {
                final_result =
                        ((range_Sedang.sum() * number_disjuction[0]) + (range_Bagus.sum() * number_disjuction[1]) + (range_Buruk.sum() * number_disjuction[2])) / ((number_disjuction[0] * 5) + (number_disjuction[1] * 5) + (number_disjuction[2] * 5))
            } else if (DK_disjuction[0] == "Sedang" && DK_disjuction[1] == "Buruk" && DK_disjuction[2] == "Bagus") {
                final_result =
                        ((range_Sedang.sum() * number_disjuction[0]) + (range_Buruk.sum() * number_disjuction[1]) + (range_Bagus.sum() * number_disjuction[2])) / ((number_disjuction[0] * 5) + (number_disjuction[1] * 5) + (number_disjuction[2] * 5))
            } else {
                println("Terjadi Kesalahan 2")
            }

        } else if (DK_disjuction.size == 2) {
            if (DK_disjuction[0] == "Baik" && DK_disjuction[1] == "Sedang") {
                final_result =
                        ((range_Bagus.sum() * number_disjuction[0]) + (range_Sedang.sum() * number_disjuction[1])) / ((number_disjuction[0] * 5) + (number_disjuction[1] * 5))
            } else if (DK_disjuction[0] == "Baik" && DK_disjuction[1] == "Buruk") {
                final_result =
                        ((range_Bagus.sum() * number_disjuction[0]) + (range_Buruk.sum() * number_disjuction[1])) / ((number_disjuction[0] * 5) + (number_disjuction[1] * 5))
            } else if (DK_disjuction[0] == "Sedang" && DK_disjuction[1] == "Bagus") {
                final_result =
                        ((range_Sedang.sum() * number_disjuction[0]) + (range_Bagus.sum() * number_disjuction[1])) / ((number_disjuction[0] * 5) + (number_disjuction[1] * 5))
            } else if (DK_disjuction[0] == "Sedang" && DK_disjuction[1] == "Buruk") {
                final_result =
                        ((range_Sedang.sum() * number_disjuction[0]) + (range_Buruk.sum() * number_disjuction[1])) / ((number_disjuction[0] * 5) + (number_disjuction[1] * 5))
            } else if (DK_disjuction[0] == "Buruk " && DK_disjuction[1] == "Bagus") {
                final_result =
                        ((range_Buruk.sum() * number_disjuction[0]) + (range_Bagus.sum() * number_disjuction[1])) / ((number_disjuction[0] * 5) + (number_disjuction[1] * 5))
            } else if (DK_disjuction[0] == "Buruk" && DK_disjuction[1] == "Sedang") {
                println("mus")
                final_result =
                        ((range_Buruk.sum() * number_disjuction[0]) + (range_Sedang.sum() * number_disjuction[1])) / ((number_disjuction[0] * 5) + (number_disjuction[1] * 5))
            } else {
                println("Terjadi Kesalahan 3")
            }

        } else {
            if (DK_disjuction[0] == "Buruk") {
                final_result = (range_Buruk.sum() * number_disjuction[0]) / (number_disjuction[0] * 5)
            } else if (DK_disjuction[0] == "Sedang") {
                final_result = (range_Sedang.sum() * number_disjuction[0]) / (number_disjuction[0] * 5)
            } else if (DK_disjuction[0] == "Bagus") {
                final_result = (range_Bagus.sum() * number_disjuction[0]) / (number_disjuction[0] * 5)
            } else {
                println("Terjadi Kesalahan 4")
            }
        }



        if (success == true) {
            if (final_result.toInt() in 0..55) {
                string_result = "Bagus"
            } else if (final_result.toInt() in 56..70) {
                string_result = "Sedang"
            } else if (final_result.toInt() in 71..100) {
                string_result = "Buruk"
            } else {
                string_result = "Data Tidak Valid"
            }
        } else {
            print("datakosong")
        }

    }

    rumus_defuzzi()
    println(final_result.toInt())
    println(string_result)


}




