package model

class Mat_Envase(override val codigo:String, override val nombre:String, override val fecha_v:String, override val cantidad:Int, override val unidad:String, override val contrato:Contrato_Proveedor, override val ueb: UEB, override val tipo: String) extends Recurso(codigo,nombre,fecha_v,cantidad,unidad,contrato,tipo,ueb){

}
