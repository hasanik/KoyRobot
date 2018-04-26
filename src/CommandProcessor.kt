import command.*

object CommandProcessor {

    fun processCommand(arg: String): BaseCommand? {
        when (arg) {
            MoveCommand.name -> return MoveCommand
            RightCommand.name -> return RightCommand
            LeftCommand.name -> return LeftCommand
            ReportCommand.name -> return ReportCommand
            else -> return PlaceCommand.build(arg)
        }
        return null
    }
}