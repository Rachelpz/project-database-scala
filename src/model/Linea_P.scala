package model

class Linea_P (val code_linea:String,val nombre_linea:String,val forma_Farm:String,val ueb:UEB){
  def this(nombre_linea:String)=this("",nombre_linea,"",null)
  def this(nombre_linea:String,forma_Farm:String)=this("",nombre_linea,forma_Farm,null)
}
