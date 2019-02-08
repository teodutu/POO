package vcs;

import utils.AbstractOperation;
import utils.ErrorCodeManager;
import utils.OperationType;
import utils.OutputWriter;

import java.util.ArrayList;

/**
 * The class is responsible for displaying the changes that have been brought to the filesystem
 * since the last commit.
 */
public final class StatusOperation extends VcsOperation {
    public StatusOperation(OperationType type) {
        super(type, null);
    }

    /**
     * Takes each filesystem operation that has been performed onto the active snapshot and prints
     * it to the OutputWriter of the VCS.
     *
     * @param vcs the vcs
     * @return    always 0
     */
    @Override
    public int execute(Vcs vcs) {
        OutputWriter writer = vcs.getOutputWriter();

        writer.write("On branch: " + vcs.getCurrBranch() + "\n");
        writer.write("Staged changes:\n");

        for (AbstractOperation op : vcs.getTrackedOps()) {
            // each operation is printed differently, in accordance with its functionality
            switch (op.getType()) {
                case TOUCH:
                    writer.write("\tCreated file " + op.getOperationArgs().get(1) + "\n");
                    break;
                case MAKEDIR:
                    writer.write("\tCreated directory " + op.getOperationArgs().get(1) + "\n");
                    break;
                case CHANGEDIR:
                    writer.write("\tChanged directory to "
                                     + op.getOperationArgs().get(1) + "\n");
                    break;
                case WRITETOFILE:
                    ArrayList<String> currWords = op.getOperationArgs();
                    int numWords = currWords.size() - 1;

                    // the changes made to the file are being listed
                    writer.write("\tAdded \"");
                    for (int i = 1; i < numWords; ++i) {
                        writer.write(currWords.get(i) + " ");
                    }
                    writer.write(currWords.get(numWords - 1) + "\" to file "
                            + currWords.get(0) + "\n");
                    break;
                case REMOVE:
                    ArrayList<String> currArgs = op.getOperationArgs();
                    String firstArg = currArgs.remove(0);

                    // if the REMOVE tag represents a directory removal
                    if (firstArg.equals("rmdir") || firstArg.equals("rm")) {
                        if (firstArg.equals("rm")) {
                            currArgs.remove(0);
                        }

                        writer.write("\tRemoved directory ");
                    } else {
                        // if a file was removed
                        writer.write("\tRemoved file ");
                    }

                    writer.write(currArgs.get(0) + "\n");
                    break;
                default:
                    break;
            }
        }

        return ErrorCodeManager.OK;
    }
}
