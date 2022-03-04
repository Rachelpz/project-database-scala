package model

class Recurso (val codigo:String,val nombre:String,val fecha_v:String,val cantidad:Int,val unidad:String,val contrato:Contrato_Proveedor,val tipo:String,val ueb:UEB){
  def this(tipo:String)=this("","","",0,"",null,tipo,null);
}
