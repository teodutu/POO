package vcs;

import utils.ErrorCodeManager;
import utils.IDGenerator;
import utils.OperationType;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Adds the current state of the filesystem to the commit list.
 */
public final class CommitOperation extends VcsOperation {
    public CommitOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    /**
     * Creates a new commit which contains a clone of the current state of the filesystem, a message
     * and an ID.
     *
     * @param vcs the vcs
     * @return    the appropriate error code (0 if the operation finished successfully)
     */
    @Override
    public int execute(Vcs vcs) {
        // when no changes have been made to the filesystem, no commit is necessary.
        if (vcs.getTrackedOps().isEmpty()) {
            return ErrorCodeManager.VCS_BAD_CMD_CODE;
        }

        // the commit message is stored in a string
        operationArgs.remove(0);
        vcs.getTrackedOps().clear();
        StringJoiner joiner = new StringJoiner(" ");

        for (String word : operationArgs) {
            joiner.add(word);
        }

        // the new commit is being created with the current filesystem snapshot, its message and a
        // uniquely generated ID
        String currMsg = joiner.toString();
        vcs.getCurrHead().addCommit(vcs.getActiveSnapshot().cloneFileSystem(), currMsg,
                                    IDGenerator.generateCommitID());

        return ErrorCodeManager.OK;
    }
}
