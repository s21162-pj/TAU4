import unittest

import hamcrest

from ProductionWorker import ProductionWorker


class ProductionWorkerTest(unittest.TestCase):
    def setUp(self):
        self.temp = ProductionWorker()
        self.temp.set_change_number(1)
        self.temp.set_pay_hour(20)

    def test_initial_change_number(self):
        hamcrest.assert_that(self.temp.get_change_number(), hamcrest.equal_to(1))

    def test_initial_pay_hour(self):
        hamcrest.assert_that(self.temp.get_pay_hour(), hamcrest.all_of(hamcrest.equal_to(20), hamcrest.instance_of(int)))

    def test_set_change_number(self):
        self.temp.set_change_number(2)
        hamcrest.assert_that(self.temp.get_change_number(), hamcrest.all_of(hamcrest.equal_to(2), hamcrest.instance_of(int), hamcrest.is_not(float)))

    def test_set_pay_hour(self):
        self.temp.set_pay_hour(22.2)
        hamcrest.assert_that(self.temp.get_pay_hour(), hamcrest.all_of(hamcrest.equal_to(22.2), hamcrest.instance_of(float), hamcrest.close_to(22, 0.5),
                                                                       hamcrest.greater_than_or_equal_to(22)))

    def test_set_exceeding_change_number(self):
        hamcrest.assert_that(hamcrest.calling(self.temp.set_change_number).with_args(3),
                             hamcrest.raises(Exception, pattern="Change needs to be 1 or 2"))

    def test_set_wrong_change_number(self):
        hamcrest.assert_that(hamcrest.calling(self.temp.set_change_number).with_args(1.2),
                             hamcrest.raises(Exception, pattern="Change needs to be 1 or 2"))

    def test_set_wrong_pay_hour(self):
        hamcrest.assert_that(hamcrest.calling(self.temp.set_pay_hour).with_args("not a number"),
                             hamcrest.raises(Exception, pattern="Must be a number"))

    def test_set_pay_hour_less_than_0(self):
        hamcrest.assert_that(hamcrest.calling(self.temp.set_pay_hour).with_args(-2), hamcrest.raises(Exception))

    def tearDown(self):
        self.temp = None
