package org.photoAlbum

import scala.collection.mutable.Map
import scala.util._ //{ Success, Failure}
import org.scalatest._
import matchers.ShouldMatchers._

class PhotoTest extends FlatSpec /*extends PhotoAlbumBoot*/ with Matchers {

  val myUri: String = "https://jsonplaceholder.typicode.com/photos"
  val fakeInput: String = """albumId 3, id 136, title aut voluptas aut temporibus, url http://placehold.it/600/2e1c14, thumbnailUrl http://placehold.it/150/2e1c14"""
  val jsonPhotoStatus: String = """[
  {
    "albumId": 3,
    "id": 136,
    "title": "aut voluptas aut temporibus",
    "url": "http://placehold.it/600/2e1c14",
    "thumbnailUrl": "http://placehold.it/150/2e1c14"
  }
]
"""

  it should "My function photoUrlsCount should match correctly on an integer" in {
    //PhotoObject.photoUrlsCount should be (jsonPhotoStatus)
    println("Mackattack")
  }

  // it should "My function totalTweetsCounted should show a success case" in {
  //
  //   PhotoObject.totalTweetsCounted onComplete {
  //     case Success(value) => value should equal(StatusInfo("1"))
  //     case Failure(exp) => fail(exp)
  //   }
  //}

}
