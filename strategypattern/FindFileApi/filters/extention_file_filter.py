import os 
from file_filter import FileFilter

class ExtensionFileFilter(FileFilter):
    def __init__(self,extension):
        self.extension = extension.lower()

    def matches(self,filepath):
        return os.path.isfile(filepath) and filepath.lower().endswith(self.extension)
