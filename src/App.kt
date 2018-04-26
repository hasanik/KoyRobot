fun main(args:Array<String>){
    for (command in args) {
        RobotSimulator.run(CommandProcessor.processCommand(command))
    }
}