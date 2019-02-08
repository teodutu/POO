package utils;

import filesystem.CatOperation;
import filesystem.CdOperation;
import filesystem.LsOperation;
import filesystem.MkdirOperation;
import filesystem.RemoveOperation;
import filesystem.TouchOperation;
import filesystem.WriteToFileOperation;
import filesystem.PrintOperation;
import filesystem.InvalidFileSystemOperation;
import vcs.BranchOperation;
import vcs.CheckoutOperation;
import vcs.CommitOperation;
import vcs.StatusOperation;
import vcs.LogOperation;
import vcs.RollBackOperation;
import vcs.InvalidVcsOperation;

import java.util.ArrayList;

public final class OperationFactory {
    private static OperationFactory instance = null;

    private OperationFactory() {
    }

    /**
     * Gets the instance.
     *
     * @return the instance
     */
    public static OperationFactory getInstance() {
        if (instance == null) {
            instance = new OperationFactory();
        }

        return instance;
    }

    /**
     * Creates a custom operation.
     *
     * @param type the operation type
     * @param args the operation arguments
     * @return the operation
     */
    public AbstractOperation createOperation(OperationType type, ArrayList<String> args) {
        switch (type) {
            case CAT:
                return new CatOperation(type, args);
            case CHANGEDIR:
                return new CdOperation(type, args);
            case LIST:
                return new LsOperation(type, args);
            case MAKEDIR:
                return new MkdirOperation(type, args);
            case REMOVE:
                return new RemoveOperation(type, args);
            case TOUCH:
                return new TouchOperation(type, args);
            case WRITETOFILE:
                return new WriteToFileOperation(type, args);
            case PRINT:
                return new PrintOperation(type, args);
            case FILESYSTEM_INVALID_OPERATION:
                return new InvalidFileSystemOperation(type, args);
            case STATUS:
                return new StatusOperation(type);
            case BRANCH:
                return new BranchOperation(type, args);
            case COMMIT:
                return new CommitOperation(type, args);
            case CHECKOUT:
                return new CheckoutOperation(type, args);
            case LOG:
                return new LogOperation(type);
            case ROLLBACK:
                return new RollBackOperation(type);
            case VCS_INVALID_OPERATION:
                return new InvalidVcsOperation(type);
            default:
                return null;
        }
    }
}
