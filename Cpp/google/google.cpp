#include "mgoogle.h"
#include "google.h"

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