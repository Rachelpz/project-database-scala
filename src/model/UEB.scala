package model

class UEB(val code_ueb:String,val nombre_ueb:String,val localizacion:String,val emp:Empresa){
  def this(nombre_ueb:String)=this("",nombre_ueb,"",null)
}
