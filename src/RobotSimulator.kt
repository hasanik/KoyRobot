import command.*

object RobotSimulator {
    lateinit var robot: ToyRobot
    private val table: TableTop = TableTop(5, 5)

    fun run(command: BaseCommand?) {
        when (command) {
            is PlaceCommand -> place(command.position, Direction.valueOf(command.f))
            is MoveCommand -> move()
            is LeftCommand -> left()
            is RightCommand -> right()
            is ReportCommand -> report()
        }

    }

    private fun isWithinBoundry(position: Position): Boolean {

        return (position.xPosition < table.width && position.yPosition < table.height);
    }

    fun isRobotPlaced(): Boolean {
        return (robot != null);
    }

    private fun place(position: Position, f: Direction) {
        if (isWithinBoundry(position))
            robot = ToyRobot(position, f)
    }

    //is on table
    //if on edge > cant move in that direction
    private fun move() {
        if (isWithinBoundry(robot.currentPosition) && isRobotPlaced()) {
            when (robot.directionFacing) {
                Direction.NORTH -> robot.currentPosition.yPosition++
                Direction.EAST -> robot.currentPosition.xPosition++
                Direction.SOUTH -> robot.currentPosition.yPosition--
                Direction.WEST -> robot.currentPosition.xPosition--
            }

        } else {
            print("Robot didnt move")
        }
    }

    private fun left() {
        when (robot.directionFacing) {
            Direction.NORTH -> robot.directionFacing = Direction.WEST
            Direction.EAST -> robot.directionFacing = Direction.NORTH
            Direction.SOUTH -> robot.directionFacing = Direction.EAST
            Direction.WEST -> robot.directionFacing = Direction.SOUTH
        }
    }

    private fun right() {

    }

    private fun report() {
        if (robot != null) {
            print("X :" + robot.currentPosition.xPosition)
            print("Y :" + robot.currentPosition.yPosition)
            print("Direction Facing :" + robot.directionFacing.name)
        } else
            print("Robot not initialized")
    }


}
