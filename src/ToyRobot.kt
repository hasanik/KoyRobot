class ToyRobot(var currentPosition: Position, var directionFacing: Direction) {

    fun place(x: Int, y: Int, f: Direction) {
        currentPosition.xPosition = x;
        currentPosition.yPosition = y;
        directionFacing = f;
    }

    //MOVE will move the toy robot one unit forward in the direction it is currently facing
    fun move() {

    }

    fun rotate90() {}
}