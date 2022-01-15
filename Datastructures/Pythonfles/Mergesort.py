def merge_sort(a):
    il = len(a)
    if il<=1:
        return;
    mi = il//2
    left = a[:mi]
    right = a[mi:]
    merge_sort(left)
    merge_sort(right)
    lL = len(left)
    rL = len(right)
    i,j,k = 0,0,0
    while(i<lL and j<rL):
        if(left[i]<right[j]):
            a[k] = left[i]
            i+=1;k+=1
        else:
            a[k] = right[j]
            j+=1;k+=1
    while(i<lL):
        a[k]=left[i];i+=1;k+=1
    while(j<rL):
        a[k]=right[j];j+=1;k+=1
    return
from random import randrange
a = []
for i in range(int(input())):
    a.append(randrange(100000))
print(*a,sep="\n")
print()
print()
merge_sort(a)
print(*a,sep = "\n")