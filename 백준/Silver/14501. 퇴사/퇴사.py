import sys

N = int(input())
d = [0]*(N+2)
Time = [0]
Pay = [0]

for a in range(N):
    puts = sys.stdin.readline().split()
    Time.append(int(puts[0]))
    Pay.append(int(puts[1]))



for a in range(1,N+1):
    for i in range(a+Time[a] , N+2):
        if d[i] < d[a]+Pay[a]:
            d[i] = d[a] + Pay[a]
       



print(d[-1])
