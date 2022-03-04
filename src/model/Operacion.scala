package model

class Operacion (val cod:String,val nombre:String,val tecnologo: String,val maquina:Maquina){
  def this(nombre:String,tecnologo: String)=this("",nombre,tecnologo,null)
}
