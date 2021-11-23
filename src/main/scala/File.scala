import better.files.File.root
import better.files.{File, _}

import java.io.PrintWriter

object File extends App {
//  val writer = new PrintWriter(new File("demo1.txt"))
//  writer.write("This is a demo \n This is demo2 \n This is demo3")
//  writer.close()
//
//  val read = Source.fromFile("demo1.txt").getLines.foreach{x=>println(x)}
//  println(read)
//
//  val fr: FileReader = new FileReader("demo1.txt")
//  val br: BufferedReader = new BufferedReader(fr)
// var line: Any =
//    (line = br.readLine) != null
//
//    if (line.contains("Akshit")) { // you can add here any value you want to change
//      line = line.replace("Akshit", "Aman") // himanshu change in Akshit
//    }
//
//  fr.close()

  val file1: File = "/home/knoldus/ScalaFileDirectory/file1.txt"
    .toFile
    .createIfNotExists()

  val print_Writer = new PrintWriter("file1.txt")

  // Writing to the file
  print_Writer.write("Hello, This is Geeks For Geeks")

  // Closing printwriter
  print_Writer.close()


  val html = (root/"home/knoldus/ScalaFileDirectory"/"test.html")
    .createIfNotExists()
    .append("<h1>")
    .appendLines("", "Header", "</h1>")

  html.overwrite("<p>Just one paragraph</p>")

  val simpleFile = (root/"/home/knoldus/ScalaFileDirectory/file1.txt")
    .append("simple text")

  //simple text
  println(simpleFile.contentAsString)

  val simpleFile1 = (root/"home/knoldus/ScalaFileDirectory/file1.txt")
    .overwrite("")
    .appendLines("#1 line", "#2 line", "#3 line")

  simpleFile1.lines.map(line => println(s"decor $line decor"))

  val forDelete = (root/"home/knoldus/ScalaFileDirectory/file1.txt")
    .createIfNotExists()

  if (forDelete.exists)
    forDelete.delete()
}