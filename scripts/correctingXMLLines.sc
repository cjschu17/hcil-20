import scala.io.Source
import scala.xml.XML

@main
def fixLineNumbers(xmlFile: String, dropLeft: Int, dropRight: Int, numToBeAdded: Int) {

  val sourceXML = Source.fromFile(xmlFile).getLines.toVector

  val linesToBeEdited = sourceXML.drop(dropLeft).dropRight(dropRight)

  val editedLinesString = "<div>" + linesToBeEdited.mkString + "</div>"

  val editedXML = XML.loadString(editedLinesString)

  val lineNodes = editedXML \ "l"

  for (l <- lineNodes) {
    val attribute = l \ "@n"
    val uneditedNum = attribute.text.toInt
    val num = uneditedNum + numToBeAdded
    println("""<l n="""" + num + """">""" + l.text + """</l>""")
  }
}
