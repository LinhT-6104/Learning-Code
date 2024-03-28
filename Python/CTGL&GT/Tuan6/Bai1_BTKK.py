#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'isBalanced' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def isBalanced(x):
    stack = []
    parentheses_pairs = [('(', ')'), ('{', '}'), ('[', ']')]
    
    for c in x:
        for open, close in parentheses_pairs:
            if c == open:
                stack.append(c)
            elif c == close:
                if not stack or stack.pop() != open:
                    return "NO"
    return "YES" if not stack else "NO"


    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        s = input()

        result = isBalanced(s)

        fptr.write(result + '\n')

    fptr.close()
