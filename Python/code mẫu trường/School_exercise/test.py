from datetime import timedelta
t1 = timedelta(weeks = 12, days = 10, hours = 4, seconds = 20)
t2 = timedelta(days = 17, hours = 5, minutes = 3, seconds = 30)
t3 = t1 - t2
print('t3 =', t3)