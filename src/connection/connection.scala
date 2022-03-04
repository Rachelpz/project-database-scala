package connection
import model.{Contrato_Proveedor, Linea_P, Operacion, Recurso, UEB}

import java.sql.DriverManager
import scala.collection.mutable.{HashMap, MultiMap, Set}
import java.util.Properties
import java.sql.{Connection, DriverManager, ResultSet, Statement}
import scala.{:+, ::}
import scala.collection.convert.ImplicitConversions.{`collection asJava`, `map AsJavaMap`}
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
object connection {

  val url = "jdbc:postgresql://localhost:5432/Biocubafarma_DB"
  val username = "postgres"
  val password = "1234"
  var connection: Connection = null

  def main(args: Array[String]): Unit =   {

  firstFunction()//ej 5
  secFunction()//ej 8
  thirdFunction()//conocer formas de producc x ueb


  }

def firstFunction():Unit= {
  try {

    Class.forName("org.postgresql.Driver")
    connection = DriverManager.getConnection(url, username, password)


    val statement = connection.createStatement()
    val resultSet = statement.executeQuery("SELECT nombre_prov ,recurso.tipo FROM contrato_proveedor join recurso on recurso.contrato_prov=contrato_proveedor.contrato_id order by contrato_proveedor.nombre_prov")
    val map =new mutable.HashMap[String , Set[String]] with mutable.MultiMap[String,String]

    while ( resultSet.next() ) {

      val  host = new Contrato_Proveedor(resultSet.getString("nombre_prov").trim)
      val host2 = new Recurso(resultSet.getString("tipo").trim)

      map.addBinding(host.nombre_prov,host2.tipo)


    }

    return println(map)
  } catch {
    case e => e.printStackTrace
  }
  this.connection.close()
}


  def secFunction():Unit= {
    try {

      Class.forName("org.postgresql.Driver")
      connection = DriverManager.getConnection(url, username, password)


      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT nombre_ueb, nombre_linea ,operacion.nombre,operacion.tecnologo FROM ueb join linea_p on linea_p.ueb=ueb.ueb_id join maquina on linea_p.linea_id=maquina.linea_p join operacion on operacion.maquina_id=maquina.id_maq order by nombre_ueb")
      var A:mutable.Map[String,String] = mutable.Map()
      val map =new mutable.HashMap[String , Set[String]] with mutable.MultiMap[String,String]

      var result=Set[String]()


      while ( resultSet.next() ) {
        val  host = new UEB(resultSet.getString("nombre_ueb").trim)
        val host2 = new Linea_P(resultSet.getString("nombre_linea").trim)
        val host3 = new Operacion(resultSet.getString("nombre").trim,resultSet.getString("tecnologo").trim)


        map.addBinding(host.nombre_ueb,host2.nombre_linea.+("-").+(host3.nombre).+("-").+(host3.tecnologo))



      }
      return println(map)
    } catch {
      case e => e.printStackTrace
    }
    this.connection.close()
  }


  def thirdFunction():Unit= {
    try {

      Class.forName("org.postgresql.Driver")
      connection = DriverManager.getConnection(url, username, password)


      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("Select linea_p.forma ,nombre_linea, ueb.nombre_ueb from ueb join linea_p on linea_p.ueb=ueb.ueb_id order by ueb.nombre_ueb")
      val map =new mutable.HashMap[String , Set[String]] with mutable.MultiMap[String,String]

      while ( resultSet.next() ) {
        val  host = new UEB(resultSet.getString("nombre_ueb").trim)
        val host2 = new Linea_P(resultSet.getString("nombre_linea").trim,resultSet.getString("forma").trim)

        map.addBinding(host.nombre_ueb,host2.forma_Farm)
      }
      return println(map)
    } catch {
      case e => e.printStackTrace
    }
    this.connection.close()
  }

}
