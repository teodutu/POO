package vcs;

import filesystem.FileSystemOperation;
import filesystem.FileSystemSnapshot;
import utils.AbstractOperation;
import utils.IDGenerator;
import utils.OutputWriter;
import utils.Visitor;

import java.util.ArrayList;

/**
 * The VCS itself, which stores all the data related to the operations, branches and commits.
 */
public final class Vcs implements Visitor {
    private final OutputWriter outputWriter;
    private ArrayList<AbstractOperation> trackedOps;
    private ArrayList<Branch> branches;
    private FileSystemSnapshot activeSnapshot;
    private Branch currHead;

    /**
     * Vcs constructor.
     *
     * @param outputWriter the output writer
     */
    public Vcs(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    /**
     * Does initialisations.
     * Creates the branches and operations lists and adds the first commit on the master branch.
     */
    public void init() {
        activeSnapshot = new FileSystemSnapshot(outputWriter);
        trackedOps = new ArrayList<>();
        branches = new ArrayList<>();
        currHead = new Branch("master", activeSnapshot.cloneFileSystem(),
                     "First commit", IDGenerator.generateCommitID());
        branches.add(currHead);
    }

    /**
     * Adds another operation to the list.
     *
     * @param operation the operation to be added
     */
    public void trackOperation(AbstractOperation operation) {
        trackedOps.add(operation);
    }

    String getCurrBranch() {
        return currHead.getBranchName();
    }

    Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.equals(branchName)) {
                return branch;
            }
        }

        return null;
    }

    ArrayList<AbstractOperation> getTrackedOps() {
        return trackedOps;
    }

    OutputWriter getOutputWriter() {
        return outputWriter;
    }

    void addBranch(Branch newBranch) {
        branches.add(newBranch);
    }

    FileSystemSnapshot getActiveSnapshot() {
        return activeSnapshot;
    }

    void setActiveSnapshot(FileSystemSnapshot newSnapshot) {
        activeSnapshot = newSnapshot;
    }

    String getCurrCommitMsg() {
        return currHead.getLastMsg();
    }

    int getCurrCommitId() {
        return currHead.getLastCommitID();
    }

    Branch getCurrHead() {
        return currHead;
    }

    void setCurrHead(Branch nextBranch) {
        currHead = nextBranch;
    }

    /**
     * Visits a file system operation.
     *
     * @param fileSystemOperation the file system operation
     * @return the return code
     */
    public int visit(FileSystemOperation fileSystemOperation) {
        return fileSystemOperation.execute(this.activeSnapshot);
    }

    /**
     * Visits a vcs operation.
     *
     * @param vcsOperation the vcs operation
     * @return return code
     */
    @Override
    public int visit(VcsOperation vcsOperation) {
         return vcsOperation.execute(this);
    }
}
