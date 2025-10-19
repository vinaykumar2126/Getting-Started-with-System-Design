import json
class csvtojson:
    def __init__(self,file_path):
        self.file_path = file_path

    def parse(self):
        with open(self.file_path) as f:
            lines = f.readlines()

        headers = lines[0].strip().split(',')
        data = []
        for line in lines[1:]:
            record = {}
            values = line.strip().split(',')
            for i in range(len(headers)):
                record[headers[i]] = values[i]
            data.append(record)
        # print(json.dumps(data, indent=4)) #shotcut to print json data
        # return data 

        json_str="[\n"
        for i,row in enumerate(data):
            json_str+=" {\n"
            for j,(key,value) in enumerate(row.items()):
                json_str += f'    "{key}": "{value}"'
                if j<len(row)-1:
                    json_str+=","
                json_str+=" \n"
            json_str+=" }"
            if i<len(data)-1:
                json_str+=","
            json_str+=" \n"
        json_str+="]"
        return json_str



parser = csvtojson("c:\\Users\\OdiN\\OneDrive\\Desktop\\systemdesign\\CSVtoJSON\\path.csv")
print(parser.parse())

