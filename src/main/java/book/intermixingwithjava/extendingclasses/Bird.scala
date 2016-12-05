package book.intermixingwithjava.extendingclasses

/**
  * Created by hovaheb on 12/5/2016.
  */
abstract class Bird {
  //def fly();
  @throws(classOf[NoFlyException])def fly();
}
