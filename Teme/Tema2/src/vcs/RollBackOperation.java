package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

/**
 * Synchronises the state of the active filesystem with that of the last commit.
 */
public final class RollBackOperation extends VcsOperation {
    public RollBackOperation(OperationType type) {
        super(type, null);
    }

    @Override
    public int execute(Vcs vcs) {
        vcs.setActiveSnapshot(vcs.getCurrHead().getLastCommit().cloneFileSystem());
        return ErrorCodeManager.OK;
    }
}
