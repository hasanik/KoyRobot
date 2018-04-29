import command.LeftCommand
import command.MoveCommand
import command.PlaceCommand
import command.RightCommand
import org.junit.Test

import org.junit.Assert.*

class RobotSimulatorTest {

    //Tests the move method
    @Test
    fun whenGivenExtraMoveCommandsRobotIsWithinBounds() {
        RobotSimulator.run(PlaceCommand.build("PLACE 4,0,EAST"))
        RobotSimulator.run(MoveCommand) // Robot moves to x = 5
        RobotSimulator.run(MoveCommand) //Robot moves to x =6 table is only 5 wide

        assertEquals(5, RobotSimulator.robot.currentPosition.xPosition)

    }

    @Test
    fun whenGivenLeftCommand() {
        RobotSimulator.run(PlaceCommand.build("PLACE 0,0,NORTH"))

        RobotSimulator.run(LeftCommand)
        assertEquals(Direction.WEST, RobotSimulator.robot.directionFacing)

        RobotSimulator.run(LeftCommand)
        assertEquals(Direction.SOUTH, RobotSimulator.robot.directionFacing)

        RobotSimulator.run(LeftCommand)
        assertEquals(Direction.EAST, RobotSimulator.robot.directionFacing)

        RobotSimulator.run(LeftCommand)
        assertEquals(Direction.NORTH, RobotSimulator.robot.directionFacing)
    }

    @Test
    fun whenGivenRightCommand() {
        RobotSimulator.run(PlaceCommand.build("PLACE 0,0,NORTH"))

        RobotSimulator.run(RightCommand)
        assertEquals(Direction.EAST, RobotSimulator.robot.directionFacing)

        RobotSimulator.run(RightCommand)
        assertEquals(Direction.SOUTH, RobotSimulator.robot.directionFacing)

        RobotSimulator.run(RightCommand)
        assertEquals(Direction.WEST, RobotSimulator.robot.directionFacing)

        RobotSimulator.run(RightCommand)
        assertEquals(Direction.NORTH, RobotSimulator.robot.directionFacing)
    }

}