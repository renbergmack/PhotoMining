package org.photoAlbum

import scala.collection.mutable.Map
import scalaj.http.{HttpResponse, Http}
import org.scalatest._
import Matchers._

object PhotoTestRepo {
  val input: String = """albumId 3, id 136, title aut voluptas aut temporibus, url http://placehold.it/600/2e1c14, thumbnailUrl http://placehold.it/150/2e1c14"""
  val paramsList: List[List[String]] = List(List("albumId", "3"), List("id", "136"), List("title", "aut voluptas aut temporibus"), List("url", "http://placehold.it/600/2e1c14"), List("thumbnailUrl", "http://placehold.it/150/2e1c14"))
  val titleParamsList: List[String] = List("title", "aut voluptas aut temporibus")
  val urlParamsTestMap = Map("thumbnailUrl" -> "http://placehold.it/150/2e1c14", "albumId" -> "3", "url" -> "http://placehold.it/600/2e1c14", "title" -> "aut voluptas aut temporibus", "id" -> "136")
  val photosUri: String = "https://jsonplaceholder.typicode.com/photos"
}

class PhotoTest extends FlatSpec with PhotoRepo {

  "Function 'parametizeInput' " should " return a list of parameter lists " in {
    parametizeInput(PhotoTestRepo.input) should be (PhotoTestRepo.paramsList)
  }

  "Function 'getKth' " should " return element of list relative to the index paramter " in {
    getKth(1, PhotoTestRepo.titleParamsList) should be ("aut voluptas aut temporibus")
  }

  "Function 'setParams' " should " add params sequentially into 'urlParamsMap' " in {
    setParams(PhotoTestRepo.paramsList)
    urlParamsMap should be (PhotoTestRepo.urlParamsTestMap)
  }

  "HTTP Request " should " return Photo database response json " in {
    val photosGetResponse: scalaj.http.HttpResponse[String] = Http(PhotoTestRepo.photosUri).params(urlParamsMap.toSeq).asString
    photosGetResponse.code should be (200)
  }
}
