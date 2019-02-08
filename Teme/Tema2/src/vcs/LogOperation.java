package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;
import utils.OutputWriter;

/**
 * Tracks the commits on the current branch by means of their IDs and messages.
 */
public final class LogOperation extends VcsOperation {
    public LogOperation(OperationType type) {
        super(type, null);
    }

    /**
     * Writes the commits in the current branch to the vcs OutputWriter.
     *
     * @param vcs the vcs
     * @return    an error code which is always 0
     */
    @Override
    public int execute(Vcs vcs) {
        OutputWriter outputWriter = vcs.getOutputWriter();
        Branch currBranch = vcs.getCurrHead();
        int numCommits = currBranch.getNumCommits();

        // the ID and the message of each commit on the branch is being written to the
        // output
        for (int i = 0; i < numCommits; ++i) {
            outputWriter.write("Commit id: " + currBranch.getID(i) + "\n");
            outputWriter.write("Message: " + currBranch.getMsg(i) + "\n");

            if (i != numCommits - 1) {
                outputWriter.write("\n");
            }
        }

        return ErrorCodeManager.OK;
    }
}
