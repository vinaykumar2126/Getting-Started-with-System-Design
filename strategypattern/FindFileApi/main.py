from find_file import FindFile
from filters.size_file_filter import SizeFileFilter
from filters.extention_file_filter import ExtensionFileFilter

if __name__ == "__main__":
    directory = "C:\\Users\\OdiN\\OneDrive\\Desktop\\systemdesign\\strategypattern\\FindFileApi"

    print("files>5mb")

    large_filter = SizeFileFilter(5*1024*1024)
    for file in FindFile.find_files(directory,large_filter):
        print(file)
    print("\nXML Files:")

    xml_filter = ExtensionFileFilter(".xml")
    for file in FindFile.find_files(directory,xml_filter):
        print(file)
