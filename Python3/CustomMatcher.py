from hamcrest.core.base_matcher import BaseMatcher
from hamcrest.core.helpers.hasmethod import hasmethod


class IsProductionWorkerOnChange(BaseMatcher):
    def __init__(self, change):
        self.change = change

    def _matches(self, worker):
        if not hasmethod(worker, "get_change_number") or (self.change != 1 and self.change != 2):
            return False
        return worker.get_change_number() == self.change

    def describe_to(self, description):
        description.append_text("Worker is not on change number ").append_text(self.change)


class MinimalPayRate(BaseMatcher):
    def __init__(self, form):
        self.form = form

    def _matches(self, worker):
        if self.form == "brutto":
            return worker.get_pay_hour() >= 20
        else:
            return worker.get_pay_hour() >= 10

    def describe_to(self, description):
        description.append_text("The pay rate is less than minimal ").append_text(self.form). \
            append_text(" in zloty")


def on_first_change():
    return IsProductionWorkerOnChange(1)


def minimal_brutto_pay():
    return MinimalPayRate("brutto")
