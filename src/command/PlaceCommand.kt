package command

import Position

object PlaceCommand : BaseCommand() {
    override val name: String
        get() = "PLACE"
    val pattern: Regex = Regex("PLACE( )([0-5],)([0-5],)(NORTH|SOUTH|EAST|WEST)")

    lateinit var position: Position
    lateinit var f: String

    fun build(arg: String): PlaceCommand? {
        if (arg.matches(pattern)) {
            position = Position(arg.get(6).toString().toInt(), arg.get(8).toString().toInt())
            f = arg.substring(10)
            return this
        } else
            return null
    }

}