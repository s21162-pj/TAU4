import numbers

from Employee import Employee


class ProductionWorker(Employee):
    def __init__(self):
        self.__pay_hour = None
        self.__change_number = None

    def get_change_number(self):
        return self.__change_number

    def get_pay_hour(self):
        return self.__pay_hour

    def set_change_number(self, value):
        if value != 1 and value != 2:
            raise Exception("Change needs to be 1 or 2")
        self.__change_number = value

    def set_pay_hour(self, value):
        if not isinstance(value, numbers.Number):
            raise Exception("Must be a number")
        if value < 0:
            raise Exception("Must be greater than 0")
        self.__pay_hour = value