package vcs;

import utils.AbstractOperation;
import utils.OperationType;

import java.util.ArrayList;

/**
 * Base class for all operations related to the VCS.
 * Thus, every derived class will be required to implement the execute method.
 */
public abstract class VcsOperation extends AbstractOperation {
    /**
     * Vcs operation constructor.
     *
     * @param type          type of the operation
     * @param operationArgs the arguments of the operation
     */
    public VcsOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    /**
     * Executes the operation.
     *
     * @param vcs the vcs
     * @return the return code
     */
    public abstract int execute(Vcs vcs);

    /**
     * Accepts the vcs visitor.
     *
     * @param vcs the vcs visitor
     * @return the error that associated with each operation and state of the
     *         filesystem
     */
    @Override
    public final int accept(Vcs vcs) {
        return vcs.visit(this);
    }
}
