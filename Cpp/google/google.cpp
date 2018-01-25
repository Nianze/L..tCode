#include "mgoogle.h"
#include "google.h"

namespace LeetCode {

Google::Google(MGoogle& mgoogle)
    :m_google(mgoogle) {};

bool Google::foo(bool useDui) {
    if (useDui) {
        return m_google.dui();
    } else {
        return m_google.cuo();
    }
}

std::vector<int> Google::twoSum(std::vector<int>& nums, int target) {
	std::unordered_map<int, int> map;
	std::vector<int> indices;
	for (int i = 0; i != nums.size(); ++i) {
		if (map.find(nums[i]) != map.end()) {
			indices.push_back(map[nums[i]]);
			indices.push_back(i);
			return indices;
		}
		map[target - nums[i]] = i;
	}
	return indices;
}


int Google::repeatedStringMatch(std::string A, std::string B) {
	// ad-hoc method
	// time: O( N * (M+N) ), M = len(A), N = len(B), M+N = len(C)
	// space: O(M + N), for creation of string C with possible size of len(A + B - 1)

	// Ceil of len(B)/len(A)
	int repeatTimes =(A.size() + B.size() - 1) / A.size();
	std::string C(A);
	int dupTimes = repeatTimes;
	while (--dupTimes) {
		C.append(A);
	}
	if (-1 == C.find(B)) {
		if (-1 == C.append(A).find(B)) {
			return -1;
		}
		return repeatTimes + 1;
	}
	return repeatTimes;

	// modified string find method
}

} // namespace LeetCode