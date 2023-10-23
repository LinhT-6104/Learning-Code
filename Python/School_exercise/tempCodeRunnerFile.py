from datetime import date, datetime
today = date(year = 2023, month = 8, day = 10)
new_year = date(year = 2024, month = 1, day = 1)
time_left_for_newyear = new_year - today
print('Thời gian sang năm mới:', time_left_for_newyear)

t1 = datetime(year = 2023, month = 8, day = 10, hour = 3, minute = 5)
t2 = datetime(year = 2024, month = 8, day = 10, hour = 3, minute = 5)
diff = t2 - t1
print('Time left for new year:', diff)