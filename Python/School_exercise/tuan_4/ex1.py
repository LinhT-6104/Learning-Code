ngay,thang,nam = [int(input()) for x in ['ngay','thang','nam']]

from datetime import date,timedelta
Today = date(nam,thang,ngay)
tomorrow = Today + timedelta(days = 1)
yesterday = Today - timedelta(days = 1)

print(yesterday.strftime('%d/%m/%Y'))
print(tomorrow.strftime('%d/%m/%Y'))