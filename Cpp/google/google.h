#ifndef INCLUDED_GOOGLE
#define INCLUDED_GOOGLE

#include <string>
#include <vector>
#include <unordered_map>

namespace LeetCode {

class MGoogle;

class Google
{
public:
    Google(MGoogle& m_google);
    bool foo(bool useDui);

    // 0001. Two Sum
    static std::vector<int> twoSum(std::vector<int>& nums, int target);
    // Given an array of integers, return indices of the two numbers 
    // such that they add up to a specific target.

    // 686. Repeated String Match
    static int repeatedStringMatch(std::string A, std::string B);
    // Given two strings A and B, find the minimum number of times A 
    // has to be repeated such that B is a substring of it. 
    // If no such solution, return -1.


protected:
    MGoogle& m_google;
};

} // namespace LeetCode

#endif