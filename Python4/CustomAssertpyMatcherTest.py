import unittest
from assertpy import assert_that, add_extension, assert_warn

from Car import Car


def is_model_of_cars_starts_with_f(self):
    models = ["ferrari", "fiskar", "fiat", "ford", "fraser"]
    if self.val.lower() not in models:
        return self.error(f'{self.val} is not beginning with letter F')
    return self


def have_legal_speed_in_town(self):
    if self.val > 50:
        return self.error(f'{self.val} is too fast in town area')
    return self


add_extension(is_model_of_cars_starts_with_f)
add_extension(have_legal_speed_in_town)


class CustomAssertpyMatcherTests(unittest.TestCase):
    def test_bentley(self):
        car = Car(2005, "Ferrari")
        assert_that(car.get_make()).is_model_of_cars_starts_with_f()

    def test_toyota(self):
        car = Car(2005, "Honda")
        assert_warn(car.get_make()).is_model_of_cars_starts_with_f()

    def test_low_speed(self):
        car = Car(2005, "Honda")
        car.accelerate()
        assert_that(car.get_speed()).have_legal_speed_in_town()

    def test_high_speed(self):
        car = Car(2005, "Honda")
        for _ in range(30):
            car.accelerate()
        assert_warn(car.get_speed()).have_legal_speed_in_town()
