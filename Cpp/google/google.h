#include <string>
#include <vector>
#include <unordered_map>

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

protected:
    MGoogle& m_google;
};
