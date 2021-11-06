package tictactoe


var cells = listOf<CharArray>(
        charArrayOf('_', '_', '_'),
        charArrayOf('_', '_', '_'),
        charArrayOf('_', '_', '_'),
)


fun enter1(){
    while (true) {
        print("Enter the coordinates: ")
        val (x, y) = readLine()!!.split(" ").map { it.first() }

        if (!x.isDigit() || !y.isDigit()) {
            println("You should enter numbers!")
        } else if (x.digitToInt() < 1 || x.digitToInt() > 3 || y.digitToInt() < 1 || y.digitToInt() > 3){
            println("Coordinates should be from 1 to 3!")
        } else if (cells[x.digitToInt() - 1][y.digitToInt() - 1] == '_') {
            cells[x.digitToInt() - 1][y.digitToInt() - 1] = 'X'
            printBoard(cells)
            break
        } else {
            println("This cell is occupied! Choose another one!")
        }
    }
}
fun enter2(){
    while (true) {
        print("Enter the coordinates: ")
        val (x, y) = readLine()!!.split(" ").map { it.first() }

        if (!x.isDigit() || !y.isDigit()) {
            println("You should enter numbers!")
        } else if (x.digitToInt() < 1 || x.digitToInt() > 3 || y.digitToInt() < 1 || y.digitToInt() > 3){
            println("Coordinates should be from 1 to 3!")
        } else if (cells[x.digitToInt() - 1][y.digitToInt() - 1] == '_') {
            cells[x.digitToInt() - 1][y.digitToInt() - 1] = 'O'
            printBoard(cells)
            break
        } else {
            println("This cell is occupied! Choose another one!")
        }
    }
}

fun printBoard(cells: List<CharArray>) {
    println("""
        ---------
        | ${cells[0].joinToString(" ")} |
        | ${cells[1].joinToString(" ")} |
        | ${cells[2].joinToString(" ")} |
        ---------
    """.trimIndent())

}


    fun main() {
   /* print("Enter cells: ")
    val cells = readLine()!!.chunked(3).map { it.toCharArray() }*/

       printBoard(cells)
        for( i : Int in 0..4){
            if(check(cells).toBoolean()) {
                enter1()

            }
            else{
                println(check(cells))
                break
            }
            if(check(cells).toBoolean()) {
                enter2()

            }
            else{
                println(check(cells))
                break
            }

        }

}


fun check(cell: List<CharArray>) : String {

    var c = CharArray(9)
    var aQ = 0
    for(i : Int in 0..2){
        for(j :Int in 0..2){

            c[aQ]=cell[i][j]
            aQ += 1
        }
    }

    var d = 0
    var e = 0
    var f = 0
    val g = 'X'
    val h = 'O'
    var i = 0
    var j = 0
    var k = 0
    var l= 0
    repeat(9){
        if(c[f]==g){
            d += 1
        }
        else if(c[f]==h){
            e += 1
        }
        f += 1
    }
   if(d!=0 || e!=0){
        if(d>e){
          i= d-e
       } else{
           i= e-d
       }

   }



    if((c[0]==c[1]) && (c[1]==c[2])){
      if(c[0]==g){
          j=j+1
      }
      else if(c[0]==h){
          k=k+1
      }
  }
    if((c[3]==c[4]) && (c[4]==c[5])){
        if(c[3]==g){
            j=j+1
        }
        else if(c[3]==h){
            k=k+1
        }
    }
    if((c[6]==c[7]) && (c[7]==c[8])){
        if(c[6]==g){
            j=j+1
        }
        else if(c[6]==h){
            k=k+1
        }
    }
    if((c[0]==c[3]) && (c[3]==c[6])){
        if(c[0]==g){
            j=j+1
        }
        else if(c[0]==h){
            k=k+1
        }
    }
    if((c[1]==c[4]) && (c[4]==c[7])){
        if(c[1]==g){
            j += 1
        }
        else if(c[1]==h){
            k=k+1
        }
    }
    if((c[2]==c[5]) && (c[5]==c[8])){
        if(c[2]==g){
            j=j+1
        }
        else if(c[2]==h){
            k=k+1
        }
    }
    if((c[0]==c[4]) && (c[4]==c[8])){
        if(c[0]==g){
            j=j+1
        }
        else if(c[0]==h){
            k=k+1
        }
    }
    if((c[2]==c[4]) && (c[4]==c[6])){
        if(c[2]==g){
            j=j+1
        }
        else if(c[2]==h){
            k=k+1
        }
    }
    if(j!=0 || k!=0){
        if(j>k){
            l = j-k
        } else if(k>j){
            l=k-j
        } else{
            l=-1
        }
    }
    val Z =d+e

    if((j==0 && k==0) && ((i<2) && (Z<9))){

        return "true"


    }else if(j>k){
        return "X wins"
    } else if(k>j) {
        return "O wins"
    } else{
         return "Draw"
    }



}









