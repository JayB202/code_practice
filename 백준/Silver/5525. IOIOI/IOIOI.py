import sys

def count_PN(N, M, S):
    count = 0
    current_run_length = 0

    for i in range(M):
        if i == 0:
            if S[i] == 'I':
                current_run_length = 1
            else:
                current_run_length = 0
        else:
            if S[i] != S[i-1]:
                current_run_length +=1
            else:
                if S[i] == 'I':
                    current_run_length =1
                else:
                    current_run_length =0
        if S[i] == 'I' and current_run_length >= 2*N +1:
            count +=1
    return count

def main():
    import sys
    import sys
    input = sys.stdin.read
    data = input().split()
    N = int(data[0])
    M = int(data[1])
    S = data[2]
    result = count_PN(N, M, S)
    print(result)

if __name__ == "__main__":
    main()
