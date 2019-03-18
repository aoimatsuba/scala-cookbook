import scala.collection.mutable

object chapter11_f {

  // ###########27 Using a Queue
  // FIFO (first in, first out)
  val q = mutable.Queue(1, 2, 3, 4, 5)
  q.dequeue() // the first element, which is 1 will dequeue

  val queue = new collection.mutable.Queue[String]
  queue += "Kyupio"
  queue += ("Aoi", "Izuki")

  queue.enqueue("Tomo")
  queue
  queue.dequeue()

  // dequeueFirst and dequeueAll to remove elements by specifying a predicate
  queue.dequeueFirst(_.startsWith("I"))
  queue ++= Array("Lichin", "Raseru", "Hugo")
  queue.dequeueAll(_.length > 4)
  queue


  // ############28 Using a Stack
  // LIFO (last in, first out)
  // push, top, pop to add, peek, and get elements
  var fruits = collection.mutable.Stack[String]()
  fruits.push("banana")
  fruits.push("kumquat", "orange", "passion fruit")

  fruits.top
  // the top element will be still there since it is just peeking
  fruits
  fruits.pop()
  // the top element is taken
  fruits


  // ##########29 Using a Range
  1 to 10 // Range (inclusive)
  4 until 14 //Range but doesn't include 14
  val r = 4 until 38 by 2
  r.toList

  // Some sequences have a range method in their object to perform the same function
  val array = Array(5 to 9)

  // Tabulate is another good approach to populate collections too
  val x = List.tabulate(6)(_ * 2)
  val v = Vector.tabulate(4)(_ * 2 + 4)


}