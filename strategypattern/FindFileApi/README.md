## You need to design a FindFile API that works similarly to the Unix find command.
Focus initially on 2 use cases:

-Find all files over 5MB under a directory.
-Find all XML files under a directory.

But your design should be extensible so more use cases can be added easily later.

Can be done using strategy pattern

🛠️ Solution Overview – FindFile API (Strategy Pattern)
✅ Goal: Design a FindFile API similar to Unix find command.

Use Case 1: Find all files over 5MB under a directory.

Use Case 2: Find all .xml files under a directory.

Requirement: Extensible design to support more filter types later.

🧩 Design Approach: Strategy Pattern
🧠 Used the Strategy Design Pattern to decouple filtering logic from file traversal logic.

Created a common interface: FileFilter with method matches(filepath).

Each filtering condition is a pluggable strategy (a separate class).

🧱 Components
FileFilter (Abstract Base Class):

Defines the method matches(filepath).

ExtensionFileFilter:

Implements FileFilter.

Checks if file extension matches (e.g., .xml).

SizeFileFilter:

Implements FileFilter.

Checks if file size exceeds a threshold (e.g., 5MB).

FindFile:

Contains static method find_files(directory, file_filter).

Traverses all files in the given directory recursively.

Delegates filtering to the strategy's matches() method