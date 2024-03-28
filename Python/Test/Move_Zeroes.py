nums = "12056"
n = len(nums)
curIndex = 0
nums = list(nums)

for i in range(n):
    if nums[i] != '0':
        nums[curIndex] = nums[i]
        curIndex += 1

# nums = nums[:curIndex]

for i in range(n):
    print(nums[i], end=" ")
