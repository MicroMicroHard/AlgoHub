class Animal:

    def eat(self):
        print("-----吃-----")

    def drink(self):
        print("-----喝-----")


class Dog(Animal):

    def bark(self): # 关于self： https://www.jb51.net/article/166981.htm
        print("-----汪汪叫------")


class XTQ(Dog):
    """定义了一个哮天犬 类"""
    pass


class Cat(Animal):
    def catch(self):
        print("----捉老鼠----")


xtq = XTQ()
xtq.eat()
xtq.bark()
