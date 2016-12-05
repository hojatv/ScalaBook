package book.intermixingwithjava.extendingclasses

/**
  * Created by hovaheb on 12/5/2016.
  */
class Ostrich extends Bird{
  override def fly() ={
    throw new NoFlyException
  }
}
