import unittest

from hamcrest import assert_that, is_, is_not

from CustomMatcher import on_first_change, minimal_brutto_pay
from ProductionWorker import ProductionWorker


class ProductionWorkerTest(unittest.TestCase):
    def test_worker_on_illegal_pay(self):
        worker = ProductionWorker()
        worker.set_pay_hour(1)
        assert_that(worker, is_not(minimal_brutto_pay()))

    def test_worker_on_legal_pay(self):
        worker = ProductionWorker()
        worker.set_pay_hour(40)
        assert_that(worker, is_(minimal_brutto_pay()))

    def test_worker_on_first_change(self):
        worker = ProductionWorker()
        worker.set_change_number(1)
        assert_that(worker, is_(on_first_change()))

    def test_worker_on_second_change(self):
        worker = ProductionWorker()
        worker.set_change_number(2)
        assert_that(worker, is_not(on_first_change()))



