package org.photoAlbum

import scala.io._
import scalaj.http._
import scala.collection.mutable.Map

trait PhotoRepo {

  val urlParamsMap: scala.collection.mutable.Map[String,String] = Map()

  def addParam(key: String, value: String) = { urlParamsMap += key -> value }

  def setParams(paramsList: List[List[String]]): Unit = {
    for(paramPair <- paramsList) {
      addParam(paramPair.head, getKth(1, paramPair))
    }
  }

  def getKth(index:Int, myList:List[String]): String = {
    if(index == 0){
      myList.head
    } else {
      getKth(index - 1, myList.tail)
    }
  }

  def parametizeInput(text: String): List[List[String]] = {
    text.split(", ").toList.map(x => x.split(" ", 2).toList)
  }

}

object PhotoAlbumBoot extends PhotoRepo with App {

  println("What's your query?(albumId, id, title, url, or thumbnailUrl)")
  println("Ex: 'albumId 3, title 1'")
  val input: String = scala.io.StdIn.readLine().toString()
  println("You entered: " + input)
  println("Please wait patiently.")
  val myUri: String = "https://jsonplaceholder.typicode.com/photos"
  val paramsList: List[List[String]] = parametizeInput(input)

  println("me " + input.split(",").toList.toString)
  println("paramsList " + paramsList)

  setParams(paramsList)

  println("map params " + urlParamsMap.toString())

  val result2: scalaj.http.HttpResponse[String] = Http(myUri).params(urlParamsMap.toSeq).asString
  println(result2.body.toString())
}
