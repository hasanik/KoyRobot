import command.PlaceCommand
import org.junit.Assert.*
import org.junit.Test

class CommandProcessorTest {

    @Test
    fun validPlaceCommand() {
        var command = CommandProcessor.processCommand("PLACE 0,0,NORTH")
        command as PlaceCommand
        assertNotNull(command)
        assertEquals(0, command.position.xPosition)
        assertEquals(0, command.position.yPosition)
        assertEquals("NORTH", command.f)
    }

    @Test
    fun invalidPlaceCommand() {
        var command = CommandProcessor.processCommand("foo")

        assertNull(command)
    }

    @Test
    fun outofBoundsInvalidPlaceCommand() {
        var command = CommandProcessor.processCommand("PLACE 0,6,NORTH")
        assertNull(command)
    }

}