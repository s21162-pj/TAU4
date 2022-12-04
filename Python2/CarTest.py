import unittest

from assertpy import assert_that

from Car import Car


class CarTest(unittest.TestCase):
    def setUp(self):
        self.temp = Car(2005, "Honda")

    def test_get_speed_after_init(self):
        assert_that(self.temp.get_speed()).is_zero()

    def test_get_speed_after_accelerate(self):
        self.temp.accelerate()
        assert_that(self.temp.get_speed()).is_greater_than_or_equal_to(5)

    def test_get_speed_after_twice_accelerate(self):
        self.temp.accelerate()
        self.temp.accelerate()
        assert_that(self.temp.get_speed()).is_equal_to(10)

    def test_get_speed_after_accelerate_and_brake(self):
        self.temp.accelerate()
        self.temp.brake()
        assert_that(self.temp.get_speed()).is_less_than(5)

    def test_get_speed_after_twice_brake(self):
        self.temp.brake()
        self.temp.brake()
        assert_that(self.temp.get_speed()).is_not_equal_to(-10)

    def test_older_than_2000(self):
        assert_that(Car).raises(Exception).when_called_with(1999, "sample").is_equal_to("older than 2000")

    def test_year_as_float_type(self):
        assert_that(Car).raises(Exception).when_called_with(2022.5, "sample").starts_with("int"). \
            is_equal_to("int required")

    def test_other_make_of_the_car(self):
        car = Car(2008, "BMW")
        assert_that(car.get_make()).contains("B", "M")

    def test_other_make_list(self):
        car = Car(2008, "BMW")
        assert_that(car.get_make()).is_not_in("Honda", "VW")

    def test_other_make_contains_only_letters(self):
        car = Car(2005, "Hondao")
        assert_that(car.get_make()).contains_only("H", "o", "n", "d", "a")

    def tearDown(self):
        self.temp = None
