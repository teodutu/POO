package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

/**
 * Takes care of any VCS operation with an invalid name.
 */
public final class InvalidVcsOperation extends VcsOperation {
    public InvalidVcsOperation(OperationType type) {
        super(type, null);
    }

    /**
     * In case the vcs command does not respect the format of any other command, an error code is
     * returned.
     *
     * @param vcs the vcs
     * @return    the error code -1
     */
    @Override
    public int execute(Vcs vcs) {
        return ErrorCodeManager.VCS_BAD_CMD_CODE;
    }
}
