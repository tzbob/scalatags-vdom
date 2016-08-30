package scalatags.vdom

import scala.scalajs.js
import scalatags.vdom.raw.VNode
import scalatags.vdom.raw.VirtualDom.VTreeChild

class Builder(
    ) {
  import scalatags.generic.Frag

  val attributes = js.Dictionary.empty[js.Any]
  val style      = js.Dictionary.empty[String]
  val children   = js.Array[Frag[_, VTreeChild]]()

  def addChild(f: Frag[_, VTreeChild]): Unit = children.push(f)

  def appendAttribute(key: String, value: js.Any): Unit =
    attributes.update(key, value)

  def addStyle(key: String, value: String): Unit =
    style.update(key, value)

  def make(tag: String): VNode = {
    import js.JSConverters._

    val renderedChildren = Option(children.map(_.render)).orUndefined

    this.appendAttribute("style", style)
    val finalAttributes = Option(attributes).orUndefined

    new VNode(tag, finalAttributes, renderedChildren)
  }

}
