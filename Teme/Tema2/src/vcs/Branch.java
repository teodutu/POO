package vcs;

import filesystem.FileSystemSnapshot;

import java.util.ArrayList;

/**
 * Each instance of this class will represent a separate branch of the VCS.
 * There is a list for each element of a commit: the system state, the message and the ID,
 * together with the name of the branch.
 */
public final class Branch {
    private String name;
    private ArrayList<FileSystemSnapshot> commits;
    private ArrayList<String> commitMsgs;
    private ArrayList<Integer> commitIDs;

    Branch(String branchName, FileSystemSnapshot fileSystemSnapshot, String message, int id) {
        name = branchName;
        commits = new ArrayList<>();
        commitMsgs = new ArrayList<>();
        commitIDs = new ArrayList<>();
        addCommit(fileSystemSnapshot, message, id);
    }

    void addCommit(FileSystemSnapshot fileSystemSnapshot, String message, int id) {
        commits.add(fileSystemSnapshot);
        commitMsgs.add(message);
        commitIDs.add(id);
    }

    /**
     * Every commit past the given index is removed.
     *
     * @param commitIndex the index after which all commits are removed
     */
    void backToIndex(int commitIndex) {
        int prevLen = commitIDs.size();
        int currPos;

        for (int i = commitIndex + 1; i < prevLen; ++i) {
            currPos = commitIDs.size() - 1;

            commitIDs.remove(currPos);
            commitMsgs.remove(currPos);
            commits.remove(currPos);
        }
    }

    FileSystemSnapshot getLastCommit() {
        return commits.get(commits.size() - 1);
    }

    /**
     * Gets the id of the commit with a given position in the list.
     *
     * @param pos the position of the ID
     * @return    the required ID
     */
    int getID(int pos) {
        try {
            return commitIDs.get(pos);
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }

    /**
     * Gets the id of the message at a given position in the list.
     *
     * @param pos the given ID
     * @return   the index of message
     */
    String getMsg(int pos) {
        try {
            return commitMsgs.get(pos);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * Gets the index of the commit with a specific ID.
     *
     * @param id the given ID
     * @return   the index of ID
     */
    int findID(int id) {
        return commitIDs.indexOf(id);
    }

    String getBranchName() {
        return name;
    }

    String getLastMsg() {
        return commitMsgs.get(commitMsgs.size() - 1);
    }

    int getLastCommitID() {
        return commitIDs.get(commitIDs.size() - 1);
    }

    int getNumCommits() {
        return commits.size();
    }

    /**
     * Checks whether the name of the current branch is the given String.
     *
     * @param branch the name to be checked
     * @return       true if the name and the parameter are identical, false
     *               otherwise
     */
    public boolean equals(String branch) {
        return name.equals(branch);
    }
}
