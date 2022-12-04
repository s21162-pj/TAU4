class Employee:
    def __init__(self):
        self.__firstname = None
        self.__lastname = None

    def get_lastname(self):
        return self.__lastname

    def get_firstname(self):
        return self.__firstname

    def set_lastname(self, value):
        if any(chr.isdigit() for chr in value):
            raise Exception("Only letters allowed in lastname")
        self.__lastname = value

    def set_firstname(self, value):
        if any(chr.isdigit() for chr in value):
            raise Exception("Only letters allowed in firstname")
        self.__firstname = value