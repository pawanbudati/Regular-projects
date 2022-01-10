def devideAndRule(input1,n):
    for i in range(1,n-1):
        sum = 0
        for j in range(i):
            sum += input1[j]
        sum2 = 0
        for k in range(i+1,n):
            sum2 += input1[k]
        if sum==sum2:
            return i
    else:
        return 0


i = int(input())
s = list(map(int,input().split()))
print(devideAndRule(s,i))