import os
from file_filter import FileFilter

class SizeFileFilter(FileFilter):
    def __init__(self,min_size_bytes):
        self.min_size_bytes = min_size_bytes
    
    def matches(self,filepath):
        return os.path.isfile(filepath) and os.path.getsize(filepath)>self.min_size_bytes
