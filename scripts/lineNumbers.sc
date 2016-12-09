@main
def addLineNumbers(totalNumOfLines: Int) {

  val baseString = "urn:cts:greekLit:tlg0012.tlg001.msA:21."

  val endBaseString = ""","""""

  val lineCount = totalNumOfLines

  val count = 1

  for (i <- count to lineCount) {
    println(baseString + i + endBaseString)
  }
}
