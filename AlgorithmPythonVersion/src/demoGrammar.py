age = 8
name = "bnvcvb"
print("我的年纪是%d岁" % age)  # format grammar
print("我的年纪是%s岁" % age)  # format grammar 另外，在这个里面，所有字符都可以用字符串%s表示

print("我的年纪是%d岁,我的姓名是：%s" % (age, name))  # format grammar
print("我的名字是{name}，我的年龄是{age}岁")  # python grammar 无论第一种还是第二种 print的括号内需要有"", 另外， " " 也可以写成 ' '

# !/usr/bin/python
print("你好，世界")

list = ["a", "b", "c"]  # format grammar
print(list)  # grammar：print list 必须加()，否则报错， print(list)

list = ['runoob', 786, 2.23, 'john', 70.2]
tinylist = [123, 'john']
print(list)  # 输出完整列表
print(list[0])  # 输出列表的第一个元素
print(list[1:3])  # 输出第二个至第三个元素
print(list[2:])  # 输出从第三个开始至列表末尾的所有元素
print(tinylist * 2)  # 输出列表两次
print(list + tinylist)  # 打印组合的列表

if True:
    print("True")
else:
    print("False")

if __name__ == '__main__':
    unittest.main()
