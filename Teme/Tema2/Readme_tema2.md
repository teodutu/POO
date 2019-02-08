# Homework 2: VCS

- since the provided Javadocs were written in English, so will this Readme

## General considerations:

- for convenience reasons, the commitId field and its subsequent methods have been deleted from the
'FileSystemSnapshot' class;

- otherwise, the provided template has been left unchanged, except, of course, for the classes and
methods concerning the VCS.

- the new types of operations have been dealt with by means of the provided 'OperationParser',
'OperationFactory' and 'Context' classes and by making use of the 'OperationType' enum;


## The 'vcs' package:

- contains a class for each operation type, all extending VcsOperation, and illustrating both the
Visitor Pattern and the Factory Pattern (the latter being achieved by means of the OperationFactory
class):
    - BranchOperation;

    - CheckoutOperation;

    - CommitOperation;

    - InvalidVcsOperation;

    - LogOperation;

    - StatusOperation;

- apart from these classes, which , the class 'Branch' was also created and the 'Vcs' class has
received quite a few new members and methods;

- each instance of Branch represents a separate branch in the VCS; thus, its fields and methods
manipulate the name of the branch, the commit messages, the commit IDs and the commits themselves
(the last 3 fields being kept as ArrayLists);

- Vcs is responsible for the functionality of the whole VCS and is therefore required to perform a
multitude of tasks:

    - tracks each filesystem operation by adding it to an ArrayList;

    - holds the current state of the filesystem as a FileSystemSnapshot;

    - maintains the current head position as a variable of type Branch, whose last commit will be
    the HEAD;

    - stores all branches in an ArrayList;

    - implements the necessary methods in order to ensure proper communication between these fields.
