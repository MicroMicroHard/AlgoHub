class DemoStudy:
    name = "DemoStudy"
    age = 12

    def __init__(self, Name):
        self.name = Name

    # def __init__(self): python grammar 不可以同时定义两个 __init__
    #     print("welcome ---")

    def SayHi(self):
        print('Hello world! i am %s' % self.name)


class DE(DemoStudy):  # 继承 grammar
    add = "3456"

    def __init__(self):  # python grammar 父类没有写基本构造方法的话，子类需要补上 __init__
        pass
