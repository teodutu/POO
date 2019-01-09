package commands;

import java.util.Stack;

public class CommandManager {
    private Stack<Command> undoStack, redoStack;

    // TODO
    /* - void undo()
       - void redo()
       - void executeCommand(Command c)
       - maybe check if undo() and redo() are available ?
             -> check GameState class, see the errors
       - keep track of the commands somehow
    */

    public CommandManager() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void executeCommand(Command cmd) {
        undoStack.push(cmd);
        redoStack.clear();
        cmd.execute();
    }

    public void undo() {
        Command undoneCmd = undoStack.pop();

        redoStack.push(undoneCmd);
        undoneCmd.undo();
    }

    public void redo() {
        Command undoneCmd = redoStack.pop();

        undoStack.push(undoneCmd);
        undoneCmd.execute();
    }

    public boolean isUndoAvailable() {
        return !undoStack.isEmpty();
    }

    public boolean isRedoAvailable() {
        return !redoStack.isEmpty();
    }
}
