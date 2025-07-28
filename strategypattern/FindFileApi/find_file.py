import os

class FindFile:
    @staticmethod
    def find_files(directory,file_filter):
        result = []
        for root,dirs,files in os.walk(directory):
            for file in files:
                filepath = os.path.join(root,file)
                print("checking:", filepath)
                if file_filter.matches(filepath):
                    result.append(filepath)
        return result
    
    