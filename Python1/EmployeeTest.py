import unittest

import hamcrest

from Employee import Employee


class EmployeeTest(unittest.TestCase):
    def setUp(self):
        self.temp = Employee()
        self.temp.set_firstname("Robert")
        self.temp.set_lastname("Brzoskowski")

    def test_initial_firstname(self):
        hamcrest.assert_that(self.temp.get_firstname(), hamcrest.all_of(hamcrest.equal_to("Robert"), hamcrest.instance_of(str)))

    def test_initial_lastname(self):
        hamcrest.assert_that(self.temp.get_lastname(), hamcrest.all_of(hamcrest.starts_with("B"), hamcrest.instance_of(str), hamcrest.ends_with("i")))

    def test_set_firstname(self):
        self.temp.set_firstname("Jakub")
        hamcrest.assert_that(self.temp.get_firstname(), hamcrest.contains_string("Jak"))

    def test_set_lastname(self):
        self.temp.set_lastname("Rak")
        hamcrest.assert_that(self.temp.get_lastname(), hamcrest.starts_with("R"))

    def test_set_wrong_firstname_int(self):
        hamcrest.assert_that(hamcrest.calling(self.temp.set_firstname).with_args(55))

    def test_set_wrong_firstname(self):
        hamcrest.assert_that(hamcrest.calling(self.temp.set_firstname).with_args("55.0"),
                             hamcrest.raises(Exception, pattern="Only letters allowed in firstname"))

    def test_set_wrong_lastname_int(self):
        hamcrest.assert_that(hamcrest.calling(self.temp.set_lastname).with_args(55))

    def test_set_wrong_lastname(self):
        hamcrest.assert_that(hamcrest.calling(self.temp.set_lastname).with_args("55.0"),
                             hamcrest.raises(Exception, pattern="Only letters allowed in lastname"))

    def tearDown(self):
        self.temp = None



