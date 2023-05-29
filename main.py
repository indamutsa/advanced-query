# Basic python
# ================
# create a list of 100 numbers
numbers = [i for i in range(100)]

def get_even_numbers(numbers):
    # get even numbers from the list
    even_numbers = [i for i in numbers if i % 2 == 0]
    return even_numbers

# print(get_even_numbers(numbers))

odd_numbers = [i for i in numbers if i % 2 != 0]
# print(odd_numbers)

class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def __repr__(self):
        return f"Person({self.name}, {self.age})"

#  a list of 10 people
people = [
    Person("John", 30),
    Person("Jane", 29),
    Person("Dave", 31),
    Person("Dora", 33),
    Person("Dexter", 32),
    Person("Dennis", 34),
    Person("Daisy", 35),
    Person("Don", 36),
    Person("Doris", 37),
    Person("Denise", 38),
]

# get people older than 30
older_than_30 = [person for person in people if person.age > 30]
# print(older_than_30)


# Leetcode problems
# ===================

# 1. Two Sum
# Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
# You may assume that each input would have exactly one solution, and you may not use the same element twice.
# You can return the answer in any order.

# Example 1:
# Input: nums = [2,7,11,15], target = 9
# Output: [0,1]
# Output: Because nums[0] + nums[1] == 9, we return [0, 1].
# Example 2:
# Input: nums = [3,2,4], target = 6
# Output: [1,2]
# Example 3:
# Input: nums = [3,3], target = 6
# Output: [0,1]
# Constraints:
# 2 <= nums.length <= 103
# -109 <= nums[i] <= 109
# -109 <= target <= 109
# Only one valid answer exists.

# Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

from typing import List
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # create a dictionary
        nums_dict = {}
        # loop through the list
        for index, num in enumerate(nums):
            # check if the target - num is in the dictionary
            if target - num in nums_dict:
                # return the index of the current number and the index of the number that adds up to the target
                return [index, nums_dict[target - num]]
            # if not add the current number to the dictionary
            nums_dict[num] = index

nums = [2,7,11,15]
target = 9

solution = Solution().twoSum(nums, target)

# print solution
print(solution)


"""
A progrma that converts a roman numeral to an integer
"""
ROMAN_NUMERALS = {
    "I": 1,
    "V": 5,
    "X": 10,
    "L": 50,
    "C": 100,
    "D": 500,
    "M": 1000,
}

class Solution:
    def romanToInt(self, s: str) -> int:
        # create a variable to hold the sum
        sum = 0
        # loop through the string
        for index, char in enumerate(s):
            # check if the current char is less than the next char
            if index < len(s) - 1 and ROMAN_NUMERALS[char] < ROMAN_NUMERALS[s[index + 1]]:
                # subtract the current char from the sum
                sum -= ROMAN_NUMERALS[char]
            else:
                # add the current char to the sum
                sum += ROMAN_NUMERALS[char]
        return sum

TEST_CASES = [
    ("III", 3),
    ("IV", 4),
    ("IX", 9),
    ("LVIII", 58),
    ("MCMXCIV", 1994),
]

for test_case in TEST_CASES:
    roman_numeral, expected = test_case
    actual = Solution().romanToInt(roman_numeral)
    assert actual == expected, f"Expected {expected}, but got {actual}"
    print(actual, expected == actual)


print(Solution().romanToInt("III"))   
print(Solution().romanToInt("IV"))


# Finance data analysis
# ======================

import requests

"""
Use alpha vantage to get stock data and plot it on graph
"""

API_KEY = "XONB2J6F64P1RJAJ"
STOCK_SYMBOL = "MSFT"


def get_daily_stock_data(symbol: str):
    # get daily stock data
    url = f"https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol={symbol}&apikey={API_KEY}"
    response = requests.get(url)
    data = response.json()
    return data

def main():
    pass

if __name__ == "__main__":
    main()
