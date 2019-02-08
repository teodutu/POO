package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

/**
 * Performs checkout operations, either to a different branch, or to another commit on the same
 * branch.
 */
public final class CheckoutOperation extends VcsOperation {
    public CheckoutOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    /**
     * Changes either the current working branch in the VCS, or the current commit on this branch.
     *
     * @param vcs the vcs
     * @return    the error code that resulted following the checkout operation
     */
    @Override
    public int execute(Vcs vcs) {
        // if there are no tracked operations
        if (!vcs.getTrackedOps().isEmpty()) {
            return ErrorCodeManager.VCS_STAGED_OP_CODE;
        }

        // if the checkout is to another commit
        if (operationArgs.get(0).equals("-c")) {
            Branch currHead = vcs.getCurrHead();
            int commitIndex = currHead.findID(Integer.parseInt(operationArgs.get(1)));

            if (commitIndex == -1) {
                return ErrorCodeManager.VCS_BAD_PATH_CODE;
            }

            currHead.backToIndex(commitIndex);
            vcs.setActiveSnapshot(currHead.getLastCommit().cloneFileSystem());
        } else {
            // if the checkout changes the branch itself
            Branch nextBranch = vcs.findBranch(operationArgs.get(0));

            if (nextBranch == null) {
                return ErrorCodeManager.VCS_BAD_CMD_CODE;
            } else {
                vcs.setCurrHead(nextBranch);
            }
        }

        return ErrorCodeManager.OK;
    }
}
