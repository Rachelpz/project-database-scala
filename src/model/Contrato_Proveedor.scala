package model

class Contrato_Proveedor(val cod:String,val nombre_prov:String) {
  def this(nombre_prov:String)=this("",nombre_prov);
}
