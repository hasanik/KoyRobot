import command.MoveCommand
import command.PlaceCommand
import org.junit.Test

import org.junit.Assert.*

class RobotSimulatorTest {
    @Test
    fun robotIsWithinBounds() {
        RobotSimulator.run(PlaceCommand.build("PLACE 4,0,EAST"))
        RobotSimulator.run(MoveCommand) // Robot moves to x = 5
        RobotSimulator.run(MoveCommand) //Robot moves to x =6 table is only 5 wide

        assertEquals(5, RobotSimulator.robot.currentPosition.xPosition)

    }

}