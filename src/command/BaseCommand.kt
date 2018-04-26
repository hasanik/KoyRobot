package command
import Printer

import ToyRobot

abstract class BaseCommand {
    abstract val name: String
}

object MoveCommand : BaseCommand() {
    override val name: String
        get() = "MOVE"
}

object LeftCommand : BaseCommand() {
    override val name: String
        get() = "LEFT"

}

object RightCommand : BaseCommand() {
    override val name: String
        get() = "RIGHT"
}

object ReportCommand : Printer, BaseCommand() {
    override val name: String
        get() = "REPORT"

    override fun print(robot: ToyRobot) {
        print(robot.currentPosition.xPosition)
        print(robot.currentPosition.yPosition)
        print(robot.directionFacing)
    }
}
