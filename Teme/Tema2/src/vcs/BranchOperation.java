package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

/**
 * Creates a new branch.
 */
public final class BranchOperation extends VcsOperation {
    public BranchOperation(OperationType type, ArrayList<String> args) {
        super(type, args);
    }

    /**
     * If the branch to be created does not already exist, then it is is created.
     *
     * @param vcs the vcs
     * @return    the error code of the operation
     */
    @Override
    public int execute(Vcs vcs) {
        String newBranch = operationArgs.get(0);

        // if the branch that is required to be created already exists, an error code is returned
        if (vcs.findBranch(newBranch) != null) {
            return ErrorCodeManager.VCS_BAD_CMD_CODE;
        }

        // otherwise, the new branch is created
        vcs.addBranch(new Branch(newBranch, vcs.getActiveSnapshot().cloneFileSystem(),
                                   vcs.getCurrCommitMsg(), vcs.getCurrCommitId()));

        return ErrorCodeManager.OK;
    }
}
