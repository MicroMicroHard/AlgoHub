"""
 * @Class: judgeDays 
 * @author: micromicrohard
 * @date: 2022/5/2220:55
 * @author—Email: ljfirst@mail.ustc.edu.cn
 * @description: 输入某年某月某日，判断这一天是这一年的第几天？
 * @blogURL:
"""


class judgeDays:
    DofM = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30]

    def __init__(self):
        pass

    def IsLeapYear(self, year):
        year = int(year)   # grammar 需要强转，防止出错
        if year / 400 == 0:
            return year % 400 == 0 or (year % 4 == 0 and year % 100 != 0)

    def Method(self, year_month_days):
        dataList = year_month_days.split("-")  # split grammar
        if self.IsLeapYear(dataList[0]):       # python grammar 类调用自己的方法需要使用self
            self.DofM[2] += 1
        count = 0
        for i in range(int(dataList[1])):
            count += self.DofM[i]
        return count


instance = judgeDays()
value = instance.Method("2021-12-5")
print(value)
