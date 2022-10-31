from ClassDemo import DemoStudy, DE

df = DE()
df.SayHi()

print(4 & 12)
print(6 < 2 < 8)
print(6 < 12 & 4 < 8)
print(6 < 12 and 4 < 8)  # grammar python 中的比较，需要使用 and

if 1 < 2:
    print("-----")
    if 1 < 2 & 4 < 3:
        print("++++")
