#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'twoStacks' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER maxSum
#  2. INTEGER_ARRAY a
#  3. INTEGER_ARRAY bz
#

def twoStacks(maxSum, a, b):
    sum = 0
    a_count = 0
    b_count = 0
    result = 0
    while a_count < len(a) :
        if sum+a[a_count] > maxSum :
            break
        else:
            sum += a[a_count]
            a_count += 1
        
        
    result = a_count
        
    while b_count < len(b) :
        sum += b[b_count]
        b_count += 1
        while sum > maxSum and a_count>0:
            sum -= a[a_count-1]
            a_count -= 1
        
        if ((a_count+b_count > result) and (sum <= maxSum)) :
            result  = a_count+b_count
    return result

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    g = int(input().strip())

    for g_itr in range(g):
        first_multiple_input = input().rstrip().split()

        n = int(first_multiple_input[0])

        m = int(first_multiple_input[1])

        maxSum = int(first_multiple_input[2])

        a = list(map(int, input().rstrip().split()))

        b = list(map(int, input().rstrip().split()))

        result = twoStacks(maxSum, a, b)

        fptr.write(str(result) + '\n')

    fptr.close()
