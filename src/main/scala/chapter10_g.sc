object chapter10_g {

  // #########23 Merge two sequential collections into pairs with zip

  // Done in previous recipes
  val women = List("Mary", "Noot")
  val men = List("Tom", "Oscar")

  val couples = women zip men

  // once it became a sequence of tuples, it can be converted to Map
  couples.toMap

  // if a collection has some extra elements than others, those extra will be dropped
  val fruits = Array("Orange", "Banana", "Kaki", "Apple")
  val nums = Array(1, 2)
  fruits.zip(nums) // gives Array((Orange,1), (Banana,2))


  // #########24 Create a lazy view on a collection

  // In scala, "view' can be created on a collection; view makes the result
  // non-strict, lazy.

  1 to 10 // strict: shows number from 1 to 10
  (1 to 10).view // type is SeqView
  // For above case, Int is the type of the view's elements

  // it can be "force"d back to strict collection
  val view = (1 to 10).view
  view.force

  // view comes to effect when using transformer methods like map
  (1 to 10).map(_ *2)
  (1 to 10).view.map(_*2)

  // This result will be immediately shown because it is lazy (it won't execute
  // within map
  val x = (1 to 10).view.map{ e =>
    Thread.sleep(10000)
    e*2
  }

  // But without view, it will wait for 10 seconds until it shows up
  val y = (1 to 10).map{ e =>
    Thread.sleep(1000)
    e*2
  }

  // Another use case of using view is to treat a collection like a database view
  val arr = (1 to 10).toArray
  val viewArray= arr.view.slice(2, 5)

  arr(2) = 42

  // the view is affected on above change
  viewArray.foreach(println) // 42 is there
  // when changing the elements in the view
  viewArray(0) = 10
  viewArray(1) = 20
  viewArray(2) = 30

  // the array is affected
  arr


  // ###########25 Populate a collection with a Range

  // two ways to create Range
  // use range method on the companion object of supported ty[es
  Array.range(1, 6)
  List.range(5, 7)
  Vector.range(10, 16)
  // OR create a range and convert to desired seq
  (1 to 7).toArray
  (1 to 7).toList
  (1 to 7).toVector
}